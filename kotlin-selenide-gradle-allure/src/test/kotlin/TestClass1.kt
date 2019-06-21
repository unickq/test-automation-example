import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import io.qameta.allure.Feature
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.By


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestClass1 : BaseTest() {

    @Test
    @Feature("Search")
    fun testPass() {
        `$`(By.name("q")).setValue("allure-nunit").pressEnter()
        `$$`(".repo-list li h3").filterBy(Condition.text("unickq/allure-nunit")).shouldHaveSize(1)
    }
}

