package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1928x1080";  // меняем размер окна браузера
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager"; // не дажидаемся полной загрузки страницы сайта
        Configuration.holdBrowserOpen = true;  // браузер не закроется аосле прагона
        Configuration.timeout = 6000; //default 4000
    }


        @Test
        void FillFormTest() {

            open("/automation-practice-form");

            $("[id=firstName]").setValue("DimKa");
            $("[id=lastName]").setValue("karp");
            $("[id=userEmail]").setValue("karpdima@mail.com");
            $("#gender-radio-1+label").click();
            $("[id=userNumber]").setValue("8033321517");

            $(".react-datepicker__input-container").click();
            $(".react-datepicker__month-select").click();
            $("July-slot").click();


           // $("[id=xdget642385_1]").shouldHave(text("Здравствуйте, Дмитрий"));
        }

}
