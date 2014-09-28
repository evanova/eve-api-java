package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.tlabs.eve.parser.AbstractXMLParser;
import com.tlabs.eve.parser.BaseRule;

import org.apache.commons.digester.Digester;
import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class EveAPIParser<T extends EveAPIResponse> extends AbstractXMLParser<T> {

    private static class ErrorRule extends BaseRule {
        public void doBegin(java.lang.String name, org.xml.sax.Attributes attributes) {
            String errCode = attributes.getValue("code");

            EveAPIResponse r = (EveAPIResponse) getDigester().peek();
            try {
                r.setErrorCode(Integer.parseInt(errCode));
            }
            catch (NumberFormatException e) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Invalid errorCode '" + errCode + "': " + e.getLocalizedMessage());
                }
                r.setErrorCode(0);
            }
        }

        public void doBody(java.lang.String name, java.lang.String text) {
            EveAPIResponse r = (EveAPIResponse) getDigester().peek();

            if (!StringUtils.isBlank(text)) {
                r.setErrorMessage(text);
            }
        }
    }

    private abstract static class DateRule extends BaseRule {

        public void doBody(java.lang.String name, java.lang.String text) {
            final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2010-05-23 16:43:51
            EveAPIResponse r = (EveAPIResponse) getDigester().peek();

            if (StringUtils.isBlank(text)) {
                setDate(r, new Date());
            }
            else {
                try {
                    setDate(r, dateFormat.parse(text));
                }
                catch (ParseException e) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Unparsable date '" + text + "': " + e.getLocalizedMessage());
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
