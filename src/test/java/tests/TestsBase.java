package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
public class TestsBase {
    @BeforeAll
    static void beforeAll(){
            Configuration.browserSize = System.getProperty("size","1928x1080");
            Configuration.browser = System.getProperty("browser","chrome");
            Configuration.browserVersion = System.getProperty("version","120.0");
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.pageLoadStrategy = "eager"; // не дожидаемся полной загрузки страницы сайта
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();// добавляем видео запись
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;

            SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterEach
    void addAttach(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }

}