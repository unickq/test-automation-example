import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.logevents.LogEventListener
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

open class BaseTest{
    @BeforeEach
    internal fun beforeEach() {
        Selenide.open("https://github.com/")
    }

    @BeforeAll
    fun setUp() {
        Configuration.startMaximized = true
        SelenideLogger.addListener("allure", AllureSelenide().screenshots(true).savePageSource(false))
    }

    @AfterAll
    fun tearDown() {
        SelenideLogger.removeListener<LogEventListener>("allure")
    }
}