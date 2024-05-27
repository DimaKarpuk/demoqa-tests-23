package tests;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class TextBoxTests extends TestsBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    @DisplayName("Тест на регистрацию с полными данными")
    @Test
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
            step("Открываем страницу регистрации", () -> {
                registrationPage.openPage();
            });
            step("Заполняем форму регистрации с полными данными", () -> {
                registrationPage.setFirstName(randomUtils.randomFirstName)
                        .setLastName(randomUtils.randomLastName)
                        .setEmailName(randomUtils.randomEmail)
                        .setGender(randomUtils.randomGender)
                        .setNumber(randomUtils.randomPhoneNumb)
                        .setDateOfBirth(randomUtils.randomDay,randomUtils.randomMoth,randomUtils.randomYear)
                        .setSubjects(randomUtils.randomSubjects)
                        .choiceHobbies(randomUtils.randomHobbies)
                        .uploadFrom(randomUtils.randomFileJpg)
                        .setAddress(randomUtils.randomAddress)
                        .setState(randomUtils.randomState)
                        .setCity(randomUtils.randomCity)
                        .pressSubmit();
            });
            step("Проверяем таблицу успешной регистрации с полными данными", () -> {registrationPage.tableResponsive
                            ("Student Name",randomUtils.randomFirstName + " " + randomUtils.randomLastName )
                    .tableResponsive("Student Email",randomUtils.randomEmail)
                    .tableResponsive("Gender",randomUtils.randomGender)
                    .tableResponsive("Mobile",randomUtils.randomPhoneNumb)
                    .tableResponsive("Date of Birth",randomUtils.randomDay + " " + randomUtils.randomMoth
                            + "," + randomUtils.randomYear)
                    .tableResponsive("Subjects",randomUtils.randomSubjects)
                    .tableResponsive("Hobbies",randomUtils.randomHobbies)
                    .tableResponsive("Picture",randomUtils.randomFileJpg)
                    .tableResponsive("Address",randomUtils.randomAddress)
                    .tableResponsive("State and City",randomUtils.randomState +" " +randomUtils.randomCity);
            });
        }
    @DisplayName("Тест на регистрацию с минимальными данными")
    @Test
    void partialRegistrationTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
            step("Открываем страницу регистрации", () -> {
                registrationPage.openPage();
        });
            step("Заполняем успешную форму регистрации с минимальными данными", () -> {
                registrationPage.setFirstName(randomUtils.randomFirstName)
                        .setLastName(randomUtils.randomLastName)
                        .setGender(randomUtils.randomGender)
                        .setNumber(randomUtils.randomPhoneNumb)
                        .setDateOfBirth(randomUtils.randomDay,randomUtils.randomMoth,randomUtils.randomYear)
                        .pressSubmit();
            });
            step("Проверяем таблицу успешной регистрации с минимальными данными", () -> {
                registrationPage.tableResponsive("Student Name",randomUtils.randomFirstName
                                + " " + randomUtils.randomLastName )
                        .tableResponsive("Gender",randomUtils.randomGender)
                        .tableResponsive("Mobile",randomUtils.randomPhoneNumb)
                        .tableResponsive("Date of Birth",randomUtils.randomDay + " " + randomUtils.randomMoth
                                + "," + randomUtils.randomYear);
            });
    }
    @Tag("simple")
    @DisplayName("Тест на регистрацию с негативными данными")
    @Test
    void invalidRegistrationTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
            step("Открываем страницу регистрации", () -> {
                registrationPage.openPage();
            });
            step("Заполняем форму регистрации с негативными данными", () -> {
                registrationPage.setFirstName(randomUtils.randomFirstName)
                        .setLastName(randomUtils.randomLastName)
                        .setGender(randomUtils.randomGender)
                        .setDateOfBirth(randomUtils.randomDay,randomUtils.randomMoth,randomUtils.randomYear)
                        .pressSubmit();
            });
            step("Проверяем неуспешную регистрацию", () -> {
                registrationPage.incorrectResponsive();
            });
    }
}
