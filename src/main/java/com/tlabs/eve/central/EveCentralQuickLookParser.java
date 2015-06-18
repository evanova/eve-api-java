package com.tlabs.eve.central;



import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetElementPropertyRule;

import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class EveCentralQuickLookParser extends EveCentralParser<EveCentralQuickLookResponse> {

    private static final class DateExpires extends BaseRule {
        @Override
        public void doBody(String name, String text) {
            //<expires>2013-10-05</expires>
            final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            final EveCentralOrder order = (EveCentralOrder) getDigester().peek();
            try {
                order.setTimeExpired(format.parse(text + " 00:00:00 GMT").getTime());
            }
            catch (ParseException e) {
                System.err.println("EveCentralQuickLookParser: Unparseable date " + text);
            }
        }
    }

    private static final class DateReported extends BaseRule {

        @Override
        public void doBody(String name, String text) {
            Calendar now = GregorianCalendar.getInstance();
            now.setTimeInMillis(System.currentTimeMillis());

            //<reported_time>06-23 10:48:24</reported_time>
            final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            final EveCentralOrder order = (EveCentralOrder) getDigester().peek();
            try {
                order.setTimeReported(format.parse(now.get(Calendar.YEAR) + "-" + text + " GMT").getTime());
            }
            catch (ParseException e) {
                System.err.println("EveCentralQuickLookParser: Unparseable date " + text);
            }
        }
    }

    private static class AddRule extends BaseRule {

        private final int type;

        public AddRule(final int type) {
            this.type = type;
        }

        @Override
        public void doBegin(String name, Attributes attributes) {
            EveCentralOrder o = new EveCentralOrder();
            o.setType(this.type);
            getDigester().push(o);
        }

        @Override
        public void doEnd(String name) {
            EveCentralOrder p = (EveCentralOrder) digester.pop();
            EveCentralQuickLookResponse r = (EveCentralQuickLookResponse) digester.peek(0);
            r.add(p);
        }
    }

    public EveCentralQuickLookParser() {
        super(EveCentralQuickLookResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addRule("evec_api/quicklook/item", new SetElementPropertyRule("typeID"));
        digester.addRule("evec_api/quicklook/itemname", new SetElementPropertyRule("typeName"));
        digester.addRule("evec_api/quicklook/hours", new SetElementPropertyRule("postedLastInHours"));
        digester.addRule("evec_api/quicklook/minqty", new SetElementPropertyRule("typeMinimumQuantity"));

        digester.addRule("evec_api/quicklook/buy_orders/order", new AddRule(EveCentralOrder.BUY));
        digester.addRule("evec_api/quicklook/sell_orders/order", new AddRule(EveCentralOrder.SELL));

        //FIXME why is evec_api/quicklook/*/order/ not working?
        digester.addRule("evec_api/quicklook/buy_orders/order", new SetAttributePropertyRule("id", "orderID"));
        digester.addRule("evec_api/quicklook/buy_orders/order/region", new SetElementPropertyRule("regionID"));
        digester.addRule("evec_api/quicklook/buy_orders/order/station", new SetElementPropertyRule("stationID"));
        digester.addRule("evec_api/quicklook/buy_orders/order/station_name", new SetElementPropertyRule("stationName"));
        digester.addRule("evec_api/quicklook/buy_orders/order/security", new SetElementPropertyRule("security"));
        digester.addRule("evec_api/quicklook/buy_orders/order/price", new SetElementPropertyRule("price"));
        digester.addRule("evec_api/quicklook/buy_orders/order/vol_remain", new SetElementPropertyRule("volumeRemaining"));
        digester.addRule("evec_api/quicklook/buy_orders/order/min_volume", new SetElementPropertyRule("volumeMinimum"));
        digester.addRule("evec_api/quicklook/buy_orders/order/expires", new DateExpires());
        digester.addRule("evec_api/quicklook/buy_orders/order/reported_time", new DateReported());

        //FIXME why is evec_api/quicklook/*/order/ not working?
        digester.addRule("evec_api/quicklook/sell_orders/order", new SetAttributePropertyRule("id", "orderID"));
        digester.addRule("evec_api/quicklook/sell_orders/order/region", new SetElementPropertyRule("regionID"));
        digester.addRule("evec_api/quicklook/sell_orders/order/station", new SetElementPropertyRule("stationID"));
        digester.addRule("evec_api/quicklook/sell_orders/order/station_name", new SetElementPropertyRule("stationName"));
        digester.addRule("evec_api/quicklook/sell_orders/order/security", new SetElementPropertyRule("security"));
        digester.addRule("evec_api/quicklook/sell_orders/order/price", new SetElementPropertyRule("price"));
        digester.addRule("evec_api/quicklook/sell_orders/order/vol_remain", new SetElementPropertyRule("volumeRemaining"));
        digester.addRule("evec_api/quicklook/sell_orders/order/min_volume", new SetElementPropertyRule("volumeMinimum"));
        digester.addRule("evec_api/quicklook/sell_orders/order/expires", new DateExpires());
        digester.addRule("evec_api/quicklook/sell_orders/order/reported_time", new DateReported());

    }
}
