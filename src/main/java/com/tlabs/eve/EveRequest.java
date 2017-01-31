package com.tlabs.eve;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;


public abstract class EveRequest<T extends EveResponse> {

    private final Class<T> responseClass;
    private final String page;

    private final Map<String, String> params;

    protected EveRequest(Class<T> responseClass, String page) {
        super();
        this.responseClass = responseClass;
        this.page = page;
        this.params = new LinkedHashMap<>(2);//Order is important for CREST support
    }

    public String toURI(final String root) {
        return buildUri(root, this);
    }

    public final String getPage() {
        return page;
    }

    public final Map<String, String> getParameters() {
        return Collections.unmodifiableMap(this.params);
    }

    public final String getParam(final String p) {
        return this.params.get(p);
    }

    public final void putParam(String p, String v) {
        if (null == v) {
            this.params.remove(p);
        }
        else {
            this.params.put(p, v);
        }
    }

    public final Integer getInt(final String p) {
        try {
            final String v = getParam(p);
            return (null == v) ? null : Integer.parseInt(v);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }

    public final void putParam(String p, Integer a) {
        if (null == a) {
            this.params.remove(a);
        }
        else {
            this.params.put(p, Integer.toString(a));
        }
    }

    public final Long getLong(final String p) {
        try {
            final String v = getParam(p);
            return (null == v) ? null : Long.parseLong(v);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }

    public final void putParam(String p, Long a) {
        if (null == a) {
            this.params.remove(p);
        }
        else {
            this.params.put(p, Long.toString(a));
        }
    }

    public final void putParam(String p, String[] values) {
        if (null == values) {
            this.params.remove(p);
            return;
        }

        String s = "";
        for (Object v : values) {
            s = s + v + ",";
        }
        this.params.put(p, StringUtils.removeEnd(s, ","));
    }

    public final void putParam(String p, long[] values) {
        if (null == values) {
            this.params.remove(p);
            return;
        }

        String s = "";
        for (long v : values) {
            s = s + Long.toString(v) + ",";
        }
        this.params.put(p, StringUtils.removeEnd(s, ","));
    }

    public final String removeParam(final String p) {
        return this.params.remove(p);
    }

    public final T createError(final int err, final String msg) {
        T t = create();
        t.setErrorCode(err);
        t.setErrorMessage((null == msg) ? "Error code " + err : msg);
        return t;
    }

    public final T create() {
        try {
            T t = responseClass.newInstance();
            t.setCached(false);
            return t;
        }
        catch (Exception e) {
            System.err.println(this.getClass().getName());
            throw new RuntimeException(e);
        }
    }

    //removes duplicates
    protected static String[] filter(String[] names) {
        List<String> l = new ArrayList<>(names.length);
        for (String s : names) {
            String replaced = StringUtils.replace(s, " ", "%20");
            if (!l.contains(replaced)) {
                l.add(replaced);
            }
        }
        return l.toArray(new String[l.size()]);
    }

    //removes duplicates
    protected static long[] filter(long[] ids) {
        List<Long> l = new ArrayList<>(ids.length);
        for (Long id : ids) {
            if (!l.contains(id)) {
                l.add(id);
            }
        }
        Long[] fck = l.toArray(new Long[l.size()]);
        long[] r = new long[fck.length];
        for (int i = 0; i < fck.length; i++) {
            r[i] = fck[i];
        }
        return r;
    }

    //removes duplicates
    protected static long[] filter(Long[] ids) {
        List<Long> l = new ArrayList<>(ids.length);
        for (Long id : ids) {
            if ((id > 0) && !l.contains(id)) {
                l.add(id);
            }
        }
        Long[] fck = l.toArray(new Long[l.size()]);
        long[] r = new long[fck.length];
        for (int i = 0; i < fck.length; i++) {
            r[i] = fck[i];
        }
        return r;
    }

    private static String buildUri(final String rootUri, final EveRequest<?> request) {
        final StringBuilder sb =
                new StringBuilder().
                        append(rootUri).
                        append(request.getPage());
        final Map<String, String> parameters = request.getParameters();
        boolean first = true;
        for (Map.Entry<String, String> e: parameters.entrySet()) {
            if (first) {
                sb.append("?");
                first = false;
            }
            else {
                sb.append("&");
            }
            sb.append(e.getKey());
            sb.append("=");
            sb.append(e.getValue());
        }
        return sb.toString();
    }
}
