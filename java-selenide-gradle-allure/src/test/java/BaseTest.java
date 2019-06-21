import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    static {
        Configuration.baseUrl = "https://github.com";
    }

    @BeforeEach
    void beforeEach() {
        open("/");
    }

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @AfterAll
    public static void tearDown() {
        SelenideLogger.removeListener("allure");
    }
}
