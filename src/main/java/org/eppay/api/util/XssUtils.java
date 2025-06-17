package org.eppay.api.util;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class XssUtils {
    public static String clean(String value) {
        return Jsoup.clean(value, Safelist.basic());
    }
}
