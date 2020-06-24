package com.taotas.selenideintro.common.xpathselectors;

public class X {

    public static String hasCssClass(String value) {
        return "contains(" +
                "concat(' ',normalize-space(@class), ' '), " +
                "' " + value + " '" +
                ")";
    }

    public static String filterBy(String predicate) {
        return "[" + predicate + "]";
    }

    public static String not(String predicate) {
        return "not(" + predicate + ")";
    }

    public static String filterByCssClass(String value) {
        return filterBy(hasCssClass(value));
    }

    public static String filterByNoCssClass(String value) {
        return filterBy(not(hasCssClass(value)));
    }
}
