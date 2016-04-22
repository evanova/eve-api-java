/**
 * 
 */
package com.tlabs.eve.parser;




import org.apache.commons.digester3.Rule;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BaseRule extends Rule {
    private static final Logger LOG = LoggerFactory.getLogger(BaseRule.class);

    public void doBegin(final String name, final org.xml.sax.Attributes attributes) {

    }

    public final void begin(final String namespace, final String name, final org.xml.sax.Attributes attributes) {
        doBegin(name, attributes);
    }

    public void doBody(final String name, final String text) {

    }

    public final void body(final String namespace, final String name, final String text) {
        doBody(name, text.trim());
    }

    public void doEnd(final String name) {
    }

    public final void end(final String namespace, final String name) {
        doEnd(name);
    }

    protected static boolean setProperty(final Object bean, final String property, final String value) {
        try {
            return setPropertyImpl(bean, property, value);
        }
        catch (NumberFormatException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(e.getMessage(), e);
            }
            return setPropertyImpl(bean, property, "0");
        }
        catch (Exception e) {
            if (LOG.isWarnEnabled()) {
                LOG.warn(e.getMessage(), e);
            }
            return false;
        }
    }

    private static boolean setPropertyImpl(final Object bean, final String property, final String value) {
        Method stringMethod = getSetMethod(bean, property, String.class);
        if (null != stringMethod) {
            return invokeMethod(bean, stringMethod, value);
        }

        Method booleanMethod = getSetMethod(bean, property, boolean.class);
        if (null == booleanMethod) {
            booleanMethod = getSetMethod(bean, property, Boolean.class);
        }
        if (null != booleanMethod) {
            return invokeMethod(bean, booleanMethod, "1".equals(value));
        }

        Method longMethod = getSetMethod(bean, property, long.class);
        if (null == longMethod) {
            longMethod = getSetMethod(bean, property, Long.class);
        }
        if (null != longMethod) {
            long longValue;
            try {
                longValue = Long.parseLong(value);//is it really a long value?
            }
            catch (NumberFormatException e) {
                longValue = parseDateTime(value);
                if (longValue == 0) {
                    longValue = parserRSSDateTime(value);
                }
            }

            return invokeMethod(bean, longMethod, longValue);
        }

        Method doubleMethod = getSetMethod(bean, property, double.class);
        if (null == doubleMethod) {
            doubleMethod = getSetMethod(bean, property, Double.class);
        }
        if (null != doubleMethod) {
            return invokeMethod(bean, doubleMethod, Double.parseDouble(value));
        }

        Method floatMethod = getSetMethod(bean, property, float.class);
        if (null == floatMethod) {
            floatMethod = getSetMethod(bean, property, Float.class);
        }
        if (null != floatMethod) {
            return invokeMethod(bean, floatMethod, Float.parseFloat(value));
        }

        Method integerMethod = getSetMethod(bean, property, int.class);
        if (null == integerMethod) {
            integerMethod = getSetMethod(bean, property, Integer.class);
        }
        if (null != integerMethod) {
            return invokeMethod(bean, integerMethod, Integer.parseInt(value));
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("No suitable setter: " + property + "@" + bean.getClass().getSimpleName());
        }
        return false;
    }

    private static boolean invokeMethod(final Object bean, final Method method, final Object value) {
        try {
            method.invoke(bean, value);
            return true;
        }
        catch (InvocationTargetException e) {
            LOG.warn("InvocationTargetException: " + e.getMessage(), e);
            return false;
        }
        catch (IllegalAccessException e) {
            LOG.warn("IllegalAccessException: " + e.getMessage(), e);
            return false;
        }
    }

    private static Method getSetMethod(final Object bean, final String property, final Class<?> targetClass) {
        String methodName = "set" + property.substring(0, 1).toUpperCase() + property.substring(1);

        try {
            return bean.getClass().getMethod(methodName, targetClass);
        }
        catch (NoSuchMethodException e) {
            return null;
        }
    }

    private static long parseDateTime(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return 0l;
        }
        try {
            final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2010-05-23 16:43:51         
            return dateFormat.parse(dateTime).getTime();
        }
        catch (ParseException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("parseDateTime(" + dateTime + "): " + e.getMessage());
            }
            return 0l;
        }
    }

    private static long parserRSSDateTime(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return 0l;
        }
        try {
            final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");//2013-09-03T11:29:41Z       
            return dateFormat.parse(dateTime).getTime();
        }
        catch (ParseException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("parserRSSDateTime(" + dateTime + "): " + e.getMessage());
            }
            return 0l;
        }
    }
}
