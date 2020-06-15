package com.taotas.selenideintro.xpathversion;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.elements;

public class TodoMvcTest {

    @Test
    void completesTask() {
        open("http://todomvc.com/examples/emberjs/");

        element(By.xpath("//input[@id='new-todo']")).setValue("a").pressEnter();
        element(By.xpath("//input[@id='new-todo']")).setValue("b").pressEnter();
        element(By.xpath("//input[@id='new-todo']")).setValue("c").pressEnter();
        elements(By.xpath("//ul[@id='todo-list']//li")).shouldHave(exactTexts("a", "b", "c"));

        element(By.xpath("//ul[@id='todo-list']//li//label[text()='b']/preceding-sibling::input[@class='toggle']")).click();
        elements(By.xpath("//ul[@id='todo-list']//li[contains(@class,'completed')]")).shouldHave(exactTexts("b"));
        elements(By.xpath("//ul[@id='todo-list']//li[not(contains(@class,'completed'))]")).shouldHave(exactTexts("a", "c"));
    }
}
