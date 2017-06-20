package com.tlabs.eve;

import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class EveLocale {

    public static final EveLocale DEFAULT = new EveLocale(Locale.US);
    public static final EveLocale GERMAN = new EveLocale(Locale.GERMAN);
    public static final EveLocale FRENCH = new EveLocale(Locale.FRENCH);
    public static final EveLocale JAPANESE = new EveLocale(Locale.JAPANESE);
    public static final EveLocale RUSSIAN = new EveLocale(new Locale("ru"));
    public static final EveLocale CHINESE = new EveLocale(Locale.CHINESE);

    private Locale locale;
    private String value;

    private EveLocale(Locale locale) {
        this.locale = locale;
        this.value = this.locale.getLanguage();
        if (StringUtils.isNotBlank(locale.getCountry())) {
            this.value = this.value + "-" + locale.getCountry();
        }
        this.value = this.value().toLowerCase();
    }

    public String value() {
        return this.value;
    }

    public long time() {
        return Calendar.getInstance(this.locale).getTimeInMillis();
    }

    public long offset() {
        return Calendar.getInstance(this.locale).getTimeInMillis() - Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
    }

}
