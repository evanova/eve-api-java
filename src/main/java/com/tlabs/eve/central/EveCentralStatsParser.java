package com.tlabs.eve.central;

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

import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetElementPropertyRule;

public final class EveCentralStatsParser extends EveCentralParser<EveCentralStatsResponse> {

    private static class IdRule extends BaseRule {
        @Override
        public void doBegin(String name, Attributes attributes) {
            getDigester().push(Long.parseLong(attributes.getValue("id")));
        }

        @Override
        public void doEnd(String name) {
            digester.pop();
        }
    }

    private static class AddRule extends BaseRule {

        private final int type;

        public AddRule(final int type) {
            this.type = type;
        }

        @Override
        public void doBegin(String name, Attributes attributes) {
            EveCentralPrice p = new EveCentralPrice();
            p.setID((Long) getDigester().peek());
            p.setType(this.type);
            getDigester().push(p);
        }

        @Override
        public void doEnd(String name) {
            EveCentralPrice p = (EveCentralPrice) digester.pop();
            EveCentralStatsResponse r = (EveCentralStatsResponse) digester.peek(1);
            r.add(p);
        }
    }

    public EveCentralStatsParser() {
        super(EveCentralStatsResponse.class);
    }

    private static final String ALL = "evec_api/marketstat/type/all";
    private static final String BUY = "evec_api/marketstat/type/buy";
    private static final String SELL = "evec_api/marketstat/type/sell";

    @Override
    protected void onInit(Digester digester) {
        digester.addRule("evec_api/marketstat/type", new IdRule());
        digester.addRule(ALL, new AddRule(EveCentralPrice.MARKET));
        digester.addRule(BUY, new AddRule(EveCentralPrice.BUY));
        digester.addRule(SELL, new AddRule(EveCentralPrice.SELL));

        digester.addRule(ALL + "/volume", new SetElementPropertyRule("volume"));
        digester.addRule(ALL + "/avg", new SetElementPropertyRule("average"));
        digester.addRule(ALL + "/max", new SetElementPropertyRule("max"));
        digester.addRule(ALL + "/min", new SetElementPropertyRule("min"));
        digester.addRule(ALL + "/stddev", new SetElementPropertyRule("deviation"));
        digester.addRule(ALL + "/median", new SetElementPropertyRule("median"));
        digester.addRule(ALL + "/percentile", new SetElementPropertyRule("percentile"));

        digester.addRule(BUY + "/volume", new SetElementPropertyRule("volume"));
        digester.addRule(BUY + "/avg", new SetElementPropertyRule("average"));
        digester.addRule(BUY + "/max", new SetElementPropertyRule("max"));
        digester.addRule(BUY + "/min", new SetElementPropertyRule("min"));
        digester.addRule(BUY + "/stddev", new SetElementPropertyRule("deviation"));
        digester.addRule(BUY + "/median", new SetElementPropertyRule("median"));
        digester.addRule(BUY + "/percentile", new SetElementPropertyRule("percentile"));

        digester.addRule(SELL + "/volume", new SetElementPropertyRule("volume"));
        digester.addRule(SELL + "/avg", new SetElementPropertyRule("average"));
        digester.addRule(SELL + "/max", new SetElementPropertyRule("max"));
        digester.addRule(SELL + "/min", new SetElementPropertyRule("min"));
        digester.addRule(SELL + "/stddev", new SetElementPropertyRule("deviation"));
        digester.addRule(SELL + "/median", new SetElementPropertyRule("median"));
        digester.addRule(SELL + "/percentile", new SetElementPropertyRule("percentile"));
    }
}
