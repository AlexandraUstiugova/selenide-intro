package com.taotas.selenideintro.tasks.xpathversion;

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
        elements(By.xpath("//*[@id='todo-list']//li")).shouldHave(exactTexts("a", "b", "c"));

        element(By.xpath("//*[@id='todo-list']//li[.//text()='b']//*" +
                "[contains(concat(' ',normalize-space(@class), ' '), ' toggle ')]"))
                .click();
        elements(By.xpath("//*[@id='todo-list']//li" +
                "[contains(concat(' ', normalize-space(@class),' '), ' completed ')]"))
                .shouldHave(exactTexts("b"));
        elements(By.xpath("//*[@id='todo-list']//li" +
                "[not(contains(concat(' ', normalize-space(@class),' '), ' completed '))]"))
                .shouldHave(exactTexts("a", "c"));
    }
}
