import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class GoogleTest {

    @Test
    void shouldSearch() {
        open("https://www.google.com");

        element(By.name("q")).setValue("selenide").pressEnter();

        elements("#rso .g").shouldHave(sizeGreaterThanOrEqual(6))
                .first().shouldHave(text("Selenide: лаконичные и стабильные UI тесты на Java"))
                .find(".r > a").click();

        Wait().until(titleIs("Selenide: лаконичные и стабильные UI тесты на Java"));

    }
}
