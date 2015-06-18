package com.tlabs.eve.parser;



public class SetElementPropertyRule extends BaseRule {

    private String propertyName = null;

    public SetElementPropertyRule() {
        super();
        this.propertyName = null;
    }

    public SetElementPropertyRule(String propertyName) {
        super();
        this.propertyName = propertyName;
    }

    @Override
    public void doBody(String name, String text) {
        Object bean = getDigester().peek();
        if (null == this.propertyName) {
            setProperty(bean, name, text);
            return;
        }
        setProperty(bean, propertyName, text);
    }
}
