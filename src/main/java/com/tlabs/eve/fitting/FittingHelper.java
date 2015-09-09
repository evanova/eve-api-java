package com.tlabs.eve.fitting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlabs.eve.api.ItemAttribute;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class FittingHelper {

    private static WeakReference<ObjectMapper> jsonMapper = null;

    private FittingHelper() {}

    public static List<Fitting> fromXContent(final InputStream in) throws IOException {
        return new ShipFittingParser().parse(in).getFittings();
    }

    public static void toXContent(final List<Fitting> fittings, final OutputStream out) throws IOException {
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        writer.write(toXContent(fittings));
        writer.flush();
    }

    public static String toXContent(final Fitting fitting) {
        return toXContent(Collections.singletonList(fitting));
    }

    public static String toXContent(final List<Fitting> fittings) {
        final StringBuilder b = new StringBuilder();
        b.append("<?xml version=\"1.0\"?>\n\n");
        b.append("<fittings>\n");
        for (Fitting f: fittings) {
            b.append(toXContentImpl(f));
        }
        b.append("\n</fittings>\n");
        return b.toString();
    }

    public static void toClipboardContent(final List<Fitting> fittings, final OutputStream out) throws IOException {
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        writer.write(toClipboardContent(fittings));
        writer.flush();
    }

    public static String toClipboardContent(final List<Fitting> fittings) {
        final StringBuilder b = new StringBuilder();
        for (Fitting f: fittings) {
            b.append(toClipboardContent(f));
            b.append("\n\n");
        }
        return b.toString();
    }

    public static String toClipboardContent(final Fitting f) {
        final StringBuilder b = new StringBuilder();
        b.append("[");
        b.append(f.getTypeName());
        b.append(",");
        b.append(f.getName());
        b.append("]\n");

        b.append(toClipboard(f, ItemAttribute.FIT_LOW_SLOTS));
        b.append(toClipboard(f, ItemAttribute.FIT_MEDIUM_SLOTS));
        b.append(toClipboard(f, ItemAttribute.FIT_HIGH_SLOTS));
        b.append(toClipboard(f, ItemAttribute.FIT_RIGS_SLOTS));
        b.append(toClipboard(f, ItemAttribute.FIT_SUBSYSTEM_SLOTS));

        return b.toString();
    }

    public static List<Fitting> fromJSONContent(final InputStream in) throws IOException {
        return mapper().readValue(in, List.class);
    }

    public static void toJSONContent(final List<Fitting> fittings, final OutputStream out) throws IOException {
        mapper().writeValue(out, fittings);
        out.flush();
    }

    public static String toJSONContent(final Fitting fitting) {
        return toJSONContent(Collections.singletonList(fitting));
    }

    public static String toJSONContent(final List<Fitting> fittings) {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            mapper().writeValue(out, fittings);
            out.flush();
            return out.toString();
        }
        catch (IOException e) {
            return "";
        }
        finally {
            IOUtils.closeQuietly(out);
        }
    }

    private static String toXContentImpl(final Fitting f) {
        final StringBuilder b = new StringBuilder();
        b.append(String.format("\t<fitting name=\"%s\">\n", f.getName()));
        b.append(String.format("\t\t<description value=\"%s\"/>\n", f.getDescription()));
        b.append(String.format("\t\t<shipType value=\"%s\"/>\n", f.getTypeName()));

        for (Map.Entry<Integer, List<String>> modules: f.getModules().entrySet()) {

            //<hardware slot="med slot 1" type="Civilian EM Ward Field"/>
            //What a terrible XML format...
            final String slot = slotXFormat(modules.getKey());
            for (int i = 0; i < modules.getValue().size(); i++) {
                String m = modules.getValue().get(i);
                if (StringUtils.isNotBlank(m)) {
                    b.append(String.format(
                            "\t\t<hardware slot=\"%1$s\" type=\"%2$s\"/>\n",
                            String.format(slot, Integer.toString(i)),
                            m));
                }
            }
        }
        b.append("\n\t</fitting>");
        return b.toString();
    }

    private static String slotXFormat(final long slotId) {
        switch ((int)slotId) {
            case ItemAttribute.FIT_HIGH_SLOTS:
                return "hi slot %s";
            case ItemAttribute.FIT_MEDIUM_SLOTS:
                return "med slot %s";
            case ItemAttribute.FIT_LOW_SLOTS:
                return "low slot %s";
            case ItemAttribute.FIT_RIGS_SLOTS:
                return "rig slot %s";
            case ItemAttribute.FIT_SUBSYSTEM_SLOTS:
                return "subsystem slot %s";
            default:
                return "cargo %s";
        }
    }

    private static String toClipboard(final Fitting f, final int slotAttributeId) {
        final List<String> modules = f.getModules(slotAttributeId);
        if (CollectionUtils.isEmpty(modules)) {
            return "";
        }
        final StringBuilder b = new StringBuilder();
        for (String m: modules) {
            b.append(m);
            b.append("\n");
        }
        b.append("\n\n");
        return b.toString();
    }

    private static ObjectMapper mapper() {
        ObjectMapper mapper = (null == jsonMapper) ? null : jsonMapper.get();
        if (null == mapper) {
            mapper = new ObjectMapper();
            jsonMapper = new WeakReference<>(mapper);
        }
        return mapper;
    }
}
