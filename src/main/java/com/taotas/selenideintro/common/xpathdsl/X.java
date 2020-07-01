package com.taotas.selenideintro.common.xpathdsl;

public class X {

    public X(String value) {
    }

    public static X all() {
        return new X("//*");
    }

    private String selector = "";

    public X by(String predicate) {
        selector += "[" + predicate + "]";
        return this;
    }

    public X child(String value) {
        selector += "//" + value;
        return this;
    }

    public X descendant() {
        selector += "//*";
        return this;
    }

    public String x() {
        return selector;
    }
}
