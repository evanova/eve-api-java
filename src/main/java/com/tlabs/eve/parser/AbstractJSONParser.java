package com.tlabs.eve.parser;


import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.digester.Digester;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.xml.sax.SAXException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javaws.jnl.XMLFormat;
import com.tlabs.eve.EveParser;
import com.tlabs.eve.EveResponse;

public abstract class AbstractJSONParser<T extends EveResponse> implements EveParser<T> {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String XSLT = "/api/apiv2-json.xsl";

    private static final TransformerFactory transformerFactory = TransformerFactory.newInstance();

    private final Class<T> responseClass;

    public AbstractJSONParser(final Class<T> responseClass) {
        super();
        this.responseClass = responseClass;
    }

    public final T parse(InputStream in) throws IOException {
        try {
            final StreamSource xslt = new StreamSource(XMLFormat.class.getResourceAsStream(XSLT));
            final javax.xml.transform.Transformer transformer = transformerFactory.newTransformer(xslt);

            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
            final StreamResult result = new StreamResult(bos);

            final StreamSource xml = new StreamSource(in);
            transformer.transform(xml, result);

            return mapper.readValue(bos.toByteArray(), this.responseClass);
        }
        catch (TransformerException e) {
            throw new IOException(e);
        }
    }
}
