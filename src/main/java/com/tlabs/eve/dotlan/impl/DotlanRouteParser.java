package com.tlabs.eve.dotlan.impl;


import org.apache.commons.lang3.StringUtils;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

@Deprecated //use ESI
final class DotlanRouteParser {
    private final TransformerFactory transformerFactory;

    public DotlanRouteParser() {
        super();
        this.transformerFactory = TransformerFactory.newInstance();
    }

    public String jumpJSON(String html) throws IOException {
        String replaced = prepareHTML(html);
        replaced = StringUtils.remove(replaced, "<td align=\"center\">");
        replaced = StringUtils.remove(replaced, "<td align=\"center\" style=\"border-left: 2px solid #666666;\">");
        return parseResponse("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + replaced, "/dotlan/dotlan-jump.xsl");
    }

    public String routeJSON(String html) throws IOException {
        return parseResponse("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + prepareHTML(html), "/dotlan/dotlan-route.xsl");
    }

    private static String prepareHTML(String html) throws IOException {
        String replaced = StringUtils.substringAfter(html, "<table cellpadding=\"3\" cellspacing=\"1\" border=\"0\" width=\"100%\" class=\"tablelist table-tooltip\">");
        replaced = StringUtils.substringBefore(replaced, "</table>");
        replaced = StringUtils.substringAfter(replaced, "</tr>");
        replaced = StringUtils.replace(replaced, "&nbsp;", " ");
        return "<table>\n" + replaced + "</table>".trim();
    }

    private String parseResponse(final String table, final String xslt) throws IOException {
        try {
            final StreamSource stylesource = new StreamSource(getClass().getResourceAsStream(xslt));
            final Transformer transformer = this.transformerFactory.newTransformer(stylesource);

            final StreamSource xmlSource = new StreamSource(new StringReader(table));
            final StringWriter writer = new StringWriter();
            final StreamResult result = new StreamResult(writer);

            transformer.transform(xmlSource, result);
            writer.flush();
            return writer.toString();
        }
        catch (TransformerException e) {
            throw new IOException(e.getMessage(), e);
        }
    }
}
