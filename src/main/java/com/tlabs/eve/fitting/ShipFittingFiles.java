package com.tlabs.eve.fitting;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

public class ShipFittingFiles {

    private static final ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
    }

    private ShipFittingFiles() {}

    public static List<Fitting> readXML(final InputStream in) throws IOException {
        final ShipFittingResponse r = new ShipFittingParser().parse(in);
        return r.getFittings();
    }

    public static void writeXML(final List<Fitting> fittings, final OutputStream out) throws IOException {
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        writer.write("<?xml version=\"1.0\"?>\n");
        writer.write("<fittings>");
        for (Fitting f: fittings) {
            writer.write(String.format("<fitting name=\"%s\">", f.getName()));
            writer.write(String.format("<description value=\"%s\"/>", f.getDescription()));
            writer.write(String.format("<shipType value=\"%s\"/>", f.getTypeName()));

            for (Map.Entry<String, String> m: f.getModules().entrySet()) {
                //<hardware slot="med slot 1" type="Civilian EM Ward Field"/>
                //What a terrible XML format...
                writer.write(String.format("<hardware slot=\"%1$s\" type=\"%2$s\"/>", m.getKey(), m.getValue()));
            }
            writer.write("</fitting>");
            writer.flush();
        }
        writer.write("</fittings>");
        writer.flush();
    }

    public static List<Fitting> readJSON(final InputStream in) throws IOException {
        return (List<Fitting>)mapper.readValue(in, List.class);
    }

    public static void writeJSON(final List<Fitting> fittings, final OutputStream out) throws IOException {
        mapper.writeValue(out, fittings);
        out.flush();
    }
}
