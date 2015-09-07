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
        writer.write("<fittings>\n");
        for (Fitting f: fittings) {
            writer.write(String.format("\t<fitting name=\"%s\">\n", f.getName()));
            writer.write(String.format("\t\t<description value=\"%s\"/>\n", f.getDescription()));
            writer.write(String.format("\t\t<shipType value=\"%s\"/>\n", f.getTypeName()));

            for (Map.Entry<String, String> m: f.getModules().entrySet()) {
                //<hardware slot="med slot 1" type="Civilian EM Ward Field"/>
                //What a terrible XML format...
                writer.write(String.format("\t\t<hardware slot=\"%1$s\" type=\"%2$s\"/>\n", m.getKey(), m.getValue()));
            }
            writer.write("\t</fitting>\n");
            writer.flush();
        }
        writer.write("</fittings>\n");
        writer.flush();
    }
/*
    public static void writeCliboard(final List<Fitting> fittings, final OutputStream out) throws IOException {
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        for (Fitting f: fittings) {
            writer.write(String.format("[%1$s, %2$s]\n", f.getTypeName(), f.getName()));
            for (Map.Entry<String, String> m: f.getModules().entrySet()) {
                //writer.write(String.format("\t\t<hardware slot=\"%1$s\" type=\"%2$s\"/>\n", m.getKey(), m.getValue()));
            }
           // writer.write("\t</fitting>\n");
            writer.flush();
        }
        writer.flush();
    }*/

    public static List<Fitting> readJSON(final InputStream in) throws IOException {
        return (List<Fitting>)mapper.readValue(in, List.class);
    }

    public static void writeJSON(final List<Fitting> fittings, final OutputStream out) throws IOException {
        mapper.writeValue(out, fittings);
        out.flush();
    }
}
