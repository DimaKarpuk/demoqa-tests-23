package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    private static
    final SelenideElement firstNameInput = $("#firstName"),
     lastNameInput = $("#lastName"),
     emailInput = $("#userEmail"),
     genderWrapper = $("#genterWrapper"),
     numberInput = $("#userNumber"),
     subjectsInput = $("#subjectsInput"),
     hobbiesSportsInput = $("#hobbies-checkbox-1+label"),
     hobbiesReadingInput = $("#hobbies-checkbox-2+label"),
     uploadPicture = $("#uploadPicture"),
     currentAddress = $("#currentAddress"),
     stateInput  = $("#react-select-3-input"),
     cityInput  = $("#react-select-4-input"),
     submit  = $("#submit"),
    tableResponsive = $(".table-responsive");

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmailName(String value) {
        emailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText("Male")).click();
        return this;
    }
    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        CalendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage choiceHobbiesSports(){
        hobbiesSportsInput.click();
        return this;
    }
    public RegistrationPage choiceHobbiesReading(){
        hobbiesReadingInput.click();
        return this;
    }
    public RegistrationPage uploadFrom(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setAddress(String input){
        currentAddress.setValue(input);
        return this;
    }
    public RegistrationPage setState(String input){
        stateInput.setValue(input).pressEnter();
        return this;
    }
    public RegistrationPage setCity(String input){
        cityInput.setValue(input).pressEnter();
        return this;
    }
    public RegistrationPage pressSubmit(){
        submit.pressEnter();
        return this;
    }
    public RegistrationPage tableResponsive(String key, String value){
        tableResponsive.shouldBe(text(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
