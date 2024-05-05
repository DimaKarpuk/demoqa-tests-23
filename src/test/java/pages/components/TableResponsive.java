package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableResponsive {
    public static void  responsiveTable(String key, String value) {
        $(".table-responsive").shouldBe(text(key)).parent()
                .shouldHave(text(value));
    }
}
