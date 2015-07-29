package com.tlabs.eve.api;



import com.tlabs.eve.HttpClientTest;
import com.tlabs.eve.api.EveAPIRequest.Authenticated;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class EveApiTest extends HttpClientTest {

    private static final String PROPERTY_API_KEYS = "com.tlabs.eve.api.keys.properties";
    private static final String PROPERTY_API_URL = "com.tlabs.eve.api.url";

    public static final String URL = "http://localhost:8080/api";

    public static final class Key {
        public final String keyId;
        public final String keyValue;

        public final String id;//complementary id 

        private static Key create(String[] split, boolean assertId) {
            Validate.notNull(split, "split");
            Validate.isTrue(split.length > 1, "split length=" + split.length);
            if (split.length == 2) {
                return new Key(split[0], split[1], null, false);
            }
            else {
                return new Key(split[0], split[1], split[2], assertId);
            }
        }

        private Key(String keyId, String keyValue, String id, boolean assertId) {
            Validate.isTrue(StringUtils.isNotBlank(keyId), "keyId");
            Validate.isTrue(StringUtils.isNotBlank(keyValue), "keyValue");
            if (assertId) {
                Validate.isTrue(StringUtils.isNotBlank(id), "id");
            }
            this.keyId = keyId;
            this.keyValue = keyValue;
            this.id = id;
        }
    }

    private static final Map<String, List<Key>> APIKEYS = new HashMap<>();

    private String keyID;
    private String keyValue;

    protected Key accountKey;
    protected Key corporationKey;
    protected Key characterKey;

    @BeforeClass
    public static void setupApiKeys() throws IOException {
        APIKEYS.clear();

        final String propertyKeys = System.getProperty(PROPERTY_API_KEYS, "/apikeys.properties");

        InputStream in = EveApiTest.class.getResourceAsStream(propertyKeys);
        if (null == in) {
            final File fin = new File(propertyKeys);
            if (fin.exists()) {
                in = new BufferedInputStream(new FileInputStream(fin));
            }
        }

        if (null == in) {
            throw new IOException("Cannot find '" + propertyKeys + "'");
        }
        try {
            Map<String, List<Key>> keys = loadApiKeys(in);
            APIKEYS.putAll(keys);
        }
        finally {
            IOUtils.closeQuietly(in);
        }
    }

    @Before
    public final void initializeApiKeys() {
        final List<Key> accounts = APIKEYS.get("v2.account.full");
        this.accountKey = CollectionUtils.isEmpty(accounts) ? null : accounts.get(0);
        Assert.assertNotNull("No account key found.", this.accountKey);

        final List<Key> corps = APIKEYS.get("v2.corporation.full");
        this.corporationKey = CollectionUtils.isEmpty(corps) ? null : corps.get(0);
        Assert.assertNotNull("No corporation key found.", this.corporationKey);

        final List<Key> characters = APIKEYS.get("v2.character.full");
        this.characterKey = CollectionUtils.isEmpty(characters) ? null : characters.get(0);
        Assert.assertNotNull("No characters key found.", this.characterKey);
    }

    protected final void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    protected final void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    protected final <T extends EveAPIResponse> T apiCall(final EveAPIRequest<T> r) throws IOException {
        final String url = System.getProperty(PROPERTY_API_URL, URL);

        T q = callEveAPI(url, r);
        if (q.getErrorCode() != 0) {
            throw new IllegalArgumentException("Eve API Error " + q.getErrorCode());
        }
        return q;
    }

    private <T extends EveAPIResponse> T callEveAPI(final String url, final EveAPIRequest<T> r) throws IOException {
        final List<NameValuePair> nvps = new ArrayList<>();

        if (r instanceof Authenticated) {
            Authenticated auth = (Authenticated) r;
            if (StringUtils.isBlank(auth.getKeyID())) {
                nvps.add(new BasicNameValuePair("keyID", this.keyID));
            }
            else {
                nvps.add(new BasicNameValuePair("keyID", auth.getKeyID()));
            }
            if (StringUtils.isBlank(auth.getKey())) {
                nvps.add(new BasicNameValuePair("vCode", this.keyValue));
            }
            else {
                nvps.add(new BasicNameValuePair("vCode", auth.getKey()));
            }
        }

        final Map<String, String> params = r.getParameters();
        for (String p : params.keySet()) {
            if (!"vCode".equalsIgnoreCase(p) && !"keyID".equalsIgnoreCase(p)) {
                String v = params.get(p);
                if (StringUtils.isNotBlank(v)) {
                    nvps.add(new BasicNameValuePair(p, params.get(p)));
                }
            }
        }

        String result = post(url + r.getPage(), nvps);
        return EveAPI.parse(r, IOUtils.toInputStream(result));
    }

    private static Map<String, List<Key>> loadApiKeys(final InputStream in) throws IOException {
        final Map<String, List<Key>> keys = new HashMap<>();
        final BufferedReader r = new BufferedReader(new InputStreamReader(in));
        String l = null;
        while ((l = r.readLine()) != null) {
            l = l.trim();
            if (l.isEmpty()) {
                continue;
            }
            if (l.startsWith("#")) {
                continue;
            }
            String[] split = StringUtils.split(l, "=");
            if ((null == split) || (split.length != 2)) {
                continue;
            }
            String property = split[0];
            String value = split[1];
            if (StringUtils.isBlank(property) || StringUtils.isBlank(value)) {
                continue;
            }

            String[] splitValue = StringUtils.split(value, ":");
            if ((null == splitValue) || split.length < 2) {
                continue;
            }
            final Key k = Key.create(splitValue, false);
            List<Key> current = keys.get(property);
            if (null == current) {
                current = new LinkedList<>();
                keys.put(property, current);
            }
            current.add(k);
        }//while               
        return keys;
    }

}
