import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import io.qameta.allure.Feature
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.By

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestClass2 : BaseTest() {

    @Test
    @Feature("Search")
    fun testFail() {
        Selenide.`$`(By.name("q")).setValue("allure-nunit").pressEnter()
        Selenide.`$`(".repo-list li h3")
            .shouldHave(Condition.text("unickq"))
    }
}