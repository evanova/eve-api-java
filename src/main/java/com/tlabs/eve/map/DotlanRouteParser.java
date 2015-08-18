package com.tlabs.eve.map;

import com.tlabs.eve.EveParser;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

//This parser scrapes Dotlan HTML and this is really bad.
public class DotlanRouteParser implements EveParser<DotlanRouteResponse> {

    private static final String XSLT = "/dotlan-route.xsl";
    private static final long CACHED = 1l * 60l * 60l * 1000l; //1h (dotlan has data refreshed every 3h)

    private final TransformerFactory transformerFactory;

    public DotlanRouteParser() {
        super();
        this.transformerFactory = TransformerFactory.newInstance();
    }

    @Override
    public DotlanRouteResponse parse(InputStream in) throws IOException {
        return parse(IOUtils.toString(in));
    }

    public DotlanRouteResponse parse(String html) throws IOException {
        final DotlanRouteResponse r = new DotlanRouteResponse();
        r.setRoute(new Route(parseImpl(html)));
        r.setCachedUntil(System.currentTimeMillis() + CACHED);

        return r;
    }

    private List<SolarSystem> parseImpl(String html) throws IOException {
        String replaced = StringUtils.substringAfter(html, "<table cellpadding=\"3\" cellspacing=\"1\" border=\"0\" width=\"100%\" class=\"tablelist table-tooltip\">");
        replaced = StringUtils.substringBefore(replaced, "</table>");
        replaced = StringUtils.substringAfter(replaced, "</tr>");
        replaced = StringUtils.replace(replaced, "&nbsp;", " ");
        return parseResponse("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<table>\n" + replaced + "</table>");
    }

    private List<SolarSystem> parseResponse(final String table) throws IOException {
        try {
            final StreamSource stylesource = new StreamSource(getClass().getResourceAsStream(XSLT));
            final Transformer transformer = this.transformerFactory.newTransformer(stylesource);

            final StreamSource xmlSource = new StreamSource(new StringReader(table));
            final DOMResult dom = new DOMResult();

            transformer.transform(xmlSource, dom);
            final Node rootNode = dom.getNode().getFirstChild();
            if (null == rootNode) {
                throw new IOException(DotlanRouteParser.class.getSimpleName() + ".parseTable: null first child node");
            }

            return parseTable(rootNode);
        }
        catch (TransformerException e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    private static List<SolarSystem> parseTable(final Node rootNode) {
        final List<SolarSystem> routes = new ArrayList<>();
        final NodeList trs = rootNode.getChildNodes();

        String region = "";
        for (int i = 0; i < trs.getLength(); i++) {
            final SolarSystem entry = parseEntry(trs.item(i));
            if (null != entry) {
                if (StringUtils.isBlank(entry.getRegionName())) {
                    entry.setRegionName(region);
                }
                else {
                    region = entry.getRegionName();
                }
                routes.add(entry);
            }
        }

        return routes;
    }

    private static SolarSystem parseEntry(final Node tr) {
        final NodeList tds = tr.getChildNodes();
        if (tds.getLength() < 6) {
            return null;
        }

        final SolarSystem entry = new SolarSystem();
        entry.setRegionName(getChildText(tds, 0));
        entry.setSolarSystemName(getChildText(tds, 1));
        entry.setSecurityStatus(getChildFloat(tds, 2));
        entry.setHolderName(getChildText(tds, 3));
        entry.setShipKills(getChildInt(tds, 4));
        entry.setShipJumps(getChildInt(tds, 5));
        return entry;
    }

    private static String getChildText(final NodeList list, final int index) {
        if (index >= list.getLength()) {
            return "";
        }
        String text = list.item(index).getTextContent();
        return (StringUtils.isBlank(text)) ? "" : text.trim();
    }

    private static Float getChildFloat(final NodeList list, final int index) {
        if (index >= list.getLength()) {
            return 0f;
        }
        String text = list.item(index).getTextContent();
        try {
            return (StringUtils.isBlank(text)) ? 0f : Float.parseFloat(text.trim());
        }
        catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return 0f;
        }

    }

    private static Integer getChildInt(final NodeList list, final int index) {
        if (index >= list.getLength()) {
            return 0;
        }
        String text = list.item(index).getTextContent();
        try {
            return (StringUtils.isBlank(text)) ? 0 : Integer.parseInt(text.trim());
        }
        catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }
}
