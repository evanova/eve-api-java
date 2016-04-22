package com.tlabs.eve.parser;



import com.tlabs.eve.EveParser;
import com.tlabs.eve.EveResponse;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.ExtendedBaseRules;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

public abstract class AbstractXMLParser<T extends EveResponse> implements EveParser<T> {
    private static final SAXParserFactory SAX = SAXParserFactory.newInstance();

    private final Digester digester;
    private final Class<T> responseClass;

    public AbstractXMLParser(final Class<T> responseClass) {
        super();
        this.responseClass = responseClass;

        this.digester = new Digester() {
            @Override
            public SAXParserFactory getFactory() {
                return SAX;
            }
        };
        this.digester.setRules(new ExtendedBaseRules());
        this.digester.setNamespaceAware(false);
        this.digester.setValidating(false);

        init(this.digester);
    }

    protected void init(Digester digester) {
    }

    protected void doBeforeParse(T t) {
    }

    protected void doAfterParse(T t) {
    }

    public final T parse(InputStream in) throws IOException {
        try {
            T t = responseClass.newInstance();
            doBeforeParse(t);
            t = doParse(in, t);
            doAfterParse(t);
            return t;
        }
        catch (IllegalAccessException e) {
            throw new IOException(e.getMessage());
        }
        catch (InstantiationException e) {
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
