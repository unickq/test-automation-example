import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class TestClass2 extends BaseTest {
    @Test
    @Description("Failure example")
    void failedTest() {
        $(by("name", "q")).setValue("allure-nunit").pressEnter();
        $(".repo-list li h3").shouldHave(text("unickq"));
    }
}
