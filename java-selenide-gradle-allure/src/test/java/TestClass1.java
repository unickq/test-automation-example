import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestClass1 extends BaseTest {



    @Test
    @Description("Ololo")

    void t1(){
        $(by("name","q")).setValue("allure-nunit").pressEnter();
        $$(".repo-list li h3").filterBy(text("unickq/allure-nunit")).shouldBe(size(1));
    }

}
