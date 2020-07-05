package com.taotas.selenideintro.common.selectors.xpath.dsl;

public class X {

    private String selector;

    public X(String selectorStart) {
        selector = selectorStart;
    }

    public static X any() {
        return new X(".//*");
    }

    public X by(String predicate) {
        selector += "[" + predicate + "]";
        return this;
    }

    public X byNot(String predicate) {
        return this.by(Its.not(predicate));
    }

    public X child(String element) {
        selector += "/" + element;
        return this;
    }

    public X child() {
        return child("*");
    }

    public X descendant(String element) {
        selector += "//" + element;
        return this;
    }

    public X descendant() {
        return descendant("*");
    }

    public String x() {
        return selector;
    }
}
