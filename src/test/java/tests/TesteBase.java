package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TesteBase {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1928x1080";  // меняем размер окна браузера
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager"; // не дожидаемся полной загрузки страницы сайта
        //Configuration.holdBrowserOpen = true;  // браузер не закроется в конце теста
    }

}