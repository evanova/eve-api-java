package com.tlabs.eve.parser;



import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.Map;

//FIXME: only because Android 1.5 and commons-beanutil fail...
public class SetAttributePropertyRule extends BaseRule {

    private Map<String, String> propertyMap;

    public SetAttributePropertyRule() {
        super();
        this.propertyMap = null;
    }

    public SetAttributePropertyRule(String property) {
        this(new String[] { property });
    }

    public SetAttributePropertyRule(String xmlProperty, String beanProperty) {
        super();
        this.propertyMap = new HashMap<>(1);
        this.propertyMap.put(xmlProperty, beanProperty);
    }

    public SetAttributePropertyRule(String... properties) {
        super();
        this.propertyMap = new HashMap<>();
        for (String s : properties) {
            this.propertyMap.put(s, s);
        }
    }

    public SetAttributePropertyRule(Map<String, String> propertyMap) {
        super();
        this.propertyMap = propertyMap;
    }

    @Override
    public void doBegin(String name, Attributes attributes) {
        Object bean = getDigester().peek();
        if (null == propertyMap) {
            int count = attributes.getLength();
            for (int i = 0; i < count; i++) {
                setProperty(bean, attributes.getQName(i), attributes.getValue(i));
            }
            return;
        }

        for (String p : propertyMap.keySet()) {
            String v = attributes.getValue(p);
            if (null != v) {
                setProperty(bean, propertyMap.get(p), v);
            }
        }
    }

}
