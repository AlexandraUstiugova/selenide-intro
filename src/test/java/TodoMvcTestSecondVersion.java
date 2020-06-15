import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.elements;

public class TodoMvcTestSecondVersion {

    @Test
    void completesTask() {

        open("http://todomvc.com/examples/emberjs/");

        element("#new-todo").setValue("a").pressEnter();
        element("#new-todo").setValue("b").pressEnter();
        element("#new-todo").setValue("c").pressEnter();
        elements("#todo-list > li").shouldHave(exactTexts("a", "b", "c"));

        element("li:nth-child(2) .toggle").click();
        element("#todo-list > li.completed").shouldHave(exactText("b"));
        elements("#todo-list > li[class=ember-view]").shouldHave(exactTexts("a", "c"));

    }
}
