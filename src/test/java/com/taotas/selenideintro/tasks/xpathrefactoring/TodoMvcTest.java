package com.taotas.selenideintro.tasks.xpathrefactoring;

import com.taotas.selenideintro.common.selectors.xpath.utils.X;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.elements;

public class TodoMvcTest {

    @Test
    void completesTask() {
        open("http://todomvc.com/examples/emberjs/");

        element(By.xpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        element(By.xpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        element(By.xpath("//*[@id='new-todo']")).setValue("c").pressEnter();
        elements(By.xpath("//*[@id='todo-list']//li"))
                .shouldHave(exactTexts("a", "b", "c"));

        element(By.xpath("//*[@id='todo-list']//li[.//text()='b']//*" +
                X.filterByCssClass("toggle")))
                .click();
        elements(By.xpath("//*[@id='todo-list']//li" +
                X.filterByCssClass("completed")))
                .shouldHave(exactTexts("b"));
        elements(By.xpath("//*[@id='todo-list']//li" +
                X.filterByNoCssClass("completed")))
                .shouldHave(exactTexts("a", "c"));
    }
}
