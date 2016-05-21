package com.tlabs.eve.api;



import com.tlabs.eve.parser.AbstractXMLParser;
import com.tlabs.eve.parser.BaseRule;


import org.apache.commons.digester3.Digester;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class EveAPIParser<T extends EveAPIResponse> extends AbstractXMLParser<T> {
    private static final Logger LOG = LoggerFactory.getLogger(EveAPIParser.class);
    
    private static class ErrorRule extends BaseRule {
        public void doBegin(java.lang.String name, org.xml.sax.Attributes attributes) {
            String errCode = attributes.getValue("code");

            EveAPIResponse r = getDigester().peek();
            try {
                r.setErrorCode(Integer.parseInt(errCode));
            }
            catch (NumberFormatException e) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Invalid errorCode '" + errCode + "': " + e.getMessage());
                }
                r.setErrorCode(0);
            }
        }

        public void doBody(java.lang.String name, java.lang.String text) {
            EveAPIResponse r = getDigester().peek();

            if (!StringUtils.isBlank(text)) {
                r.setErrorMessage(text);
            }
        }
    }

    private abstract static class DateRule extends BaseRule {

        public void doBody(java.lang.String name, java.lang.String text) {
            final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2010-05-23 16:43:51
            EveAPIResponse r = getDigester().peek();

            if (StringUtils.isBlank(text)) {
                setDate(r, new Date());
            }
            else {
                try {
                    setDate(r, dateFormat.parse(text));
                }
                catch (ParseException e) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Unparsable date '" + text + "': " + e.getMessage());
                    }
                }
            }
        }

        public abstract void setDate(EveAPIResponse r, Date d);

    }

    public EveAPIParser(Class<T> responseClass) {
        super(responseClass);
    }

    protected void onInit(final Digester digester) {
    }

    @Override
    protected final void init(final Digester digester) {
        digester.addRule("eveapi/error", new ErrorRule());

        digester.addRule("eveapi/currentTime", new DateRule() {
            public void setDate(EveAPIResponse r, Date d) {
                r.setDateTime(d.getTime());
            }
        });

        digester.addRule("eveapi/cachedUntil", new DateRule() {
            public void setDate(EveAPIResponse r, Date d) {
                r.setCachedUntil(d.getTime());
            }
        });
        onInit(digester);
    }
}
