package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResponsive;
import utils.RandomUtils;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends RandomUtils {
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage removeBanner(){
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
     dateOfBirthInput = $("#dateOfBirthInput"),
     subjectsInput = $("#subjectsInput"),
     hobbiesInput = $("#hobbiesWrapper"),
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
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        CalendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage choiceHobbies(String value){
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage uploadFrom(String value){
        uploadPicture.uploadFromClasspath("jpg/"+value);
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
        TableResponsive.responsiveTable(key, value);
        return this;
    }
    public RegistrationPage incorrectResponsive(){
        numberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
}
