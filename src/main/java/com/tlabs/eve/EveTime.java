package com.tlabs.eve;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class EveTime {

    public static TimeZone EVE = TimeZone.getTimeZone("UTC");
    public static TimeZone LOCAL = TimeZone.getDefault();

    private EveTime() {}

    public static long now() {
        Calendar c = GregorianCalendar.getInstance(EVE);
        return c.getTimeInMillis();
    }

    public static Calendar calendar() {
        return GregorianCalendar.getInstance(EVE);
    }

    public static long local(final long eve) {
        return eve + LOCAL.getOffset(eve);
    }

    public static long local() {
        return local(now());
    }

    public static long eve(final long local) {
        return local - LOCAL.getOffset(local);
    }

}
