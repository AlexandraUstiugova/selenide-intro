package com.taotas.selenideintro.xpathrefactoring;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.elements;

public class TodoMvcTest {

    @Test
    void completesTask() {
        open("http://todomvc.com/examples/emberjs/");

        XPath.createTask("a");
        XPath.createTask("b");
        XPath.createTask("c");
        elements(XPath.taskList).shouldHave(exactTexts("a", "b", "c"));

        XPath.toggleTask("b");
        elements(XPath.completedTask).shouldHave(exactTexts("b"));
        elements(XPath.activeTask).shouldHave(exactTexts("a", "c"));
    }
}
