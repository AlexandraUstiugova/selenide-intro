package com.taotas.selenideintro.xpathdsl;

import com.taotas.selenideintro.common.xpathdsl.Its;
import com.taotas.selenideintro.common.xpathdsl.X;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {

    @Test
    void completesTask() {
        open("http://todomvc.com/examples/emberjs/");

        element(By.xpath(X.all().by(Its.id("new-todo")).x()))
                .setValue("a").pressEnter();
        element(By.xpath(X.all().by(Its.id("new-todo")).x()))
                .setValue("b").pressEnter();
        element(By.xpath(X.all().by(Its.id("new-todo")).x()))
                .setValue("c").pressEnter();
        elements(By.xpath(X.all().by(Its.id("todo-list"))
                .child("li").x()))
                .shouldHave(exactTexts("a", "b", "c"));

        element(By.xpath(X.all().by(Its.id("todo-list"))
                .child("li").by(Its.descendantWithText("b"))
                .descendant().by(Its.cssClass("toggle")).x()))
                .click();
        elements(By.xpath(X.all().by(Its.id("todo-list"))
                .child("li").by(Its.descendantWithText("b"))
                .descendant().by(Its.cssClass("completed")).x()))
                .shouldHave(exactTexts("b"));
        elements(By.xpath(X.all().by(Its.id("todo-list"))
                .child("li").by(Its.descendantWithText("b"))
                .descendant().by(Its.noCssClass("completed")).x()))
                .shouldHave(exactTexts("a", "c"));
    }
}
