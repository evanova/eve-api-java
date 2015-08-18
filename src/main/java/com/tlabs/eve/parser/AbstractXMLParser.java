package com.tlabs.eve.parser;



import com.tlabs.eve.EveParser;
import com.tlabs.eve.EveResponse;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

public abstract class AbstractXMLParser<T extends EveResponse> implements EveParser<T> {

    private final Digester digester;
    private final Class<T> responseClass;

    public AbstractXMLParser(final Class<T> responseClass) {
        super();
        this.responseClass = responseClass;

        this.digester = new Digester();
        //this.digester.setRules(new ExtendedBaseRules());
        this.digester.setNamespaceAware(false);
        this.digester.setValidating(false);

        //BUG Fixes an Android 1.5 (and apparently in 2.1-update1 too) SAX parser bug: cannot have both at the same time,
        //but the Android impl checks those feature against each other incorrectly.
        //This is probably causing or related to the bug described in CharacterSheetParser
        try {
            //this.digester.setFeature("http://xml.org/sax/features/namespaces", false);
            this.digester.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
        }
        catch (SAXNotSupportedException | ParserConfigurationException | SAXNotRecognizedException e) {
            throw new IllegalStateException(e.getMessage());
        }
        init(this.digester);
    }

    protected void init(Digester digester) {
    }

    protected void doBeforeParse(T t) {
    }

    protected void doAfterParse(T t) {
    }

    public synchronized final T parse(InputStream in) throws IOException {
        try {
            T t = responseClass.newInstance();
            doBeforeParse(t);
            t = doParse(in, t);
            doAfterParse(t);
            return t;
        }
        catch (IllegalAccessException | InstantiationException e) {
            throw new IOException(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private T doParse(final InputStream in, final T t) throws IOException {
        this.digester.clear();
        try {
            this.digester.push(t);
            return (T) this.digester.parse(in);
        }
        catch (SAXException e) {
            e.printStackTrace(System.err);
            throw new IOException(e.getMessage());
        }
        finally {
            this.digester.clear();
        }
    }

}
