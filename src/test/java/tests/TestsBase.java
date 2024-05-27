package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestsBase {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1928x1080";  // меняем размер окна браузера
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager"; // не дожидаемся полной загрузки страницы сайта
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud";
    }

}