package com.tlabs.eve;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.protocol.HTTP;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class HttpClientTest {

    public static class NoCheckSSLSocketFactory extends SSLSocketFactory {
        SSLContext sslContext = SSLContext.getInstance("TLS");

        public NoCheckSSLSocketFactory(KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            super(truststore);

            TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            sslContext.init(null, new TrustManager[] { tm }, null);
        }

        @Override
        public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException {
            return sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
        }

        @Override
        public Socket createSocket() throws IOException {
            return sslContext.getSocketFactory().createSocket();
        }
    }

    private static final SchemeRegistry schemeRegistry = new SchemeRegistry();
    private static ThreadSafeClientConnManager connectionManager;

    //FIXME get rid of the catch all (Exception)
    @BeforeClass
    public static void setHttpClient() throws Exception {
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        //FIXME check about the deprecated
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);

            SSLSocketFactory sslf = new NoCheckSSLSocketFactory(trustStore);
            sslf.setHostnameVerifier(new AllowAllHostnameVerifier());
            schemeRegistry.register(new Scheme("https", sslf, 443));
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }
        connectionManager = new ThreadSafeClientConnManager(new BasicHttpParams(), schemeRegistry);
    }

    @AfterClass
    public static void shutdownHttpClient() {
        connectionManager.shutdown();
    }

    protected final String get(String url) {
        HttpClient httpclient = new DefaultHttpClient(connectionManager);
        try {
            HttpGet get = new HttpGet(url);
            return httpclient.execute(get, new BasicResponseHandler());
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
            //fail(e.getLocalizedMessage());
            return null;
            //throw e;
        }
    }

    protected final String get(String url, final Map<String, String> params) {
        return get(url, toNameValuePair(params));
    }

    protected String get(String url, final List<NameValuePair> parameters) {
        String printurl = (parameters.size() == 0) ? url : url + "?";
        for (NameValuePair pair : parameters) {
            printurl = printurl + pair.getName() + "=" + pair.getValue() + "&";
        }
        printurl = StringUtils.removeEnd(printurl, "&");

        HttpClient httpclient = new DefaultHttpClient(connectionManager);
        try {
            HttpGet get = new HttpGet(printurl);
            return httpclient.execute(get, new BasicResponseHandler());
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
            //fail(e.getLocalizedMessage());
            return null;
            //throw e;
        }
    }

    protected final String post(String url) {
        return post(url, (List<NameValuePair>) null);
    }

    protected final String post(String url, final Map<String, String> params) {
        return post(url, toNameValuePair(params));
    }

    protected String post(String url, final List<NameValuePair> parameters) {
        HttpClient httpclient = new DefaultHttpClient(connectionManager);
        try {
            HttpPost post = new HttpPost(url);

            if ((null != parameters) && (parameters.size() > 0)) {
                System.out.println("PARAMS ");
                post.setEntity(new UrlEncodedFormEntity(parameters, HTTP.UTF_8));
            }
            post.addHeader("content-type", "application/x-www-form-urlencoded");
            System.out.println(post.getRequestLine());
            String s = httpclient.execute(post, new BasicResponseHandler());
            //System.out.println(s);
            return s;
        }
        catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage(), e);
        }
    }

    public static List<NameValuePair> toNameValuePair(Map<String, String> params) {
        List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
        for (String p : params.keySet()) {
            pairs.add(new BasicNameValuePair(p, params.get(p)));
        }
        return pairs;
    }

}
