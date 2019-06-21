import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.output.Slf4jLogConsumer;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

public class TestCont {

//    @Rule
//    public BrowserWebDriverContainer chrome =
//            new BrowserWebDriverContainer()
//                    .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("build"))
//                    .withCapabilities(DesiredCapabilities.chrome());
//
//    @Before
//    public void setUp() {
//        RemoteWebDriver driver = chrome.getWebDriver();
//
//        System.out.println(driver == null);
//        WebDriverRunner.setWebDriver(driver);
//    }
//
//    @After
//    public void tearDown() {
//        WebDriverRunner.closeWebDriver();
//    }
//
//    @Test
//    public void search() {
//        RemoteWebDriver driver = chrome.getWebDriver();
//        driver.get("https://www.google.com/en");
//    }
}
