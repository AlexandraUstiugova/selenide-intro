package com.taotas.selenideintro.xpathrefactoring;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class XPath {

    public static By createTaskField = By.xpath("//*[@id='new-todo']");
    public static By taskList = By.xpath("//*[@id='todo-list']//li");
    public static By completedTask = By.xpath("//*[@id='todo-list']//li[contains(concat(' ', normalize-space(@class),' '), ' completed ')]");
    public static By activeTask = By.xpath("//*[@id='todo-list']//li[not(contains(concat(' ', normalize-space(@class),' '), ' completed '))]");

    public static void createTask(String task) {
        element(createTaskField).setValue(task).pressEnter();
    }

    public static void toggleTask(String task) {
        element(By.xpath("//*[@id='todo-list']//li[.//text()='" + task + "']//*" +
                "[contains(concat(' ',normalize-space(@class), ' '), ' toggle ')]"))
                .click();
    }


}
