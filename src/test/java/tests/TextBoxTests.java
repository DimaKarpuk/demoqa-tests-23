package tests;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1928x1080";  // меняем размер окна браузера
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager"; // не дожидаемся полной загрузки страницы сайта
        Configuration.holdBrowserOpen = true;  // браузер не закроется в конце теста
        Configuration.timeout = 6000; //default 4000
    }

        @Test
        void FillFormTest() {
            open("/automation-practice-form");

            $("[id=firstName]").setValue("Dmitry");
            $("[id=lastName]").setValue("Karpuk");
            $("[id=userEmail]").setValue("karpdima@mail.com");
            $("#gender-radio-1+label").click();
            $("[id=userNumber]").setValue("8033321517");

            $("[id=subjectsInput]").scrollTo();

            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").click();
            $("option[value='1991']").click();
            $(".react-datepicker__month-select").click();
            $("option[value='5']").click();
            $(".react-datepicker__day--004").click();

            $("#subjectsInput").setValue("en").pressEnter().setValue("mat").pressEnter();

            $("#hobbies-checkbox-1+label").click();
            $("#hobbies-checkbox-2+label").click();
            $("#hobbies-checkbox-3+label").click();
            $("#hobbies-checkbox-2+label").click();

            $("#uploadPicture").uploadFromClasspath("cats.jpg"); //добавляем файл с папки resources

            $("#currentAddress").setValue("Belarus");

            $("#react-select-3-input").setValue("Haryana").pressEnter();
            $("#react-select-4-input").setValue("Panipat").pressEnter();

            $("#submit").pressEnter();


            $(".table-responsive").shouldHave(text("Dmitry Karpuk"));
            $(".table-responsive").shouldHave(text("karpdima@mail.com"));
            $(".table-responsive").shouldHave(text("Male"));
            $(".table-responsive").shouldHave(text("8033321517"));
            $(".table-responsive").shouldHave(text("04 June,1991"));
            $(".table-responsive").shouldHave(text("English, Maths"));
            $(".table-responsive").shouldHave(text("Sports, Music"));
            $(".table-responsive").shouldHave(text("cats.jpg"));
            $(".table-responsive").shouldHave(text("Belarus"));
            $(".table-responsive").shouldHave(text("Haryana Panipat"));
        }


}

