package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class TextBoxTests extends TestsBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

        @Test
        void fillFormTest() {

            registrationPage.openPage()
            .setFirstName(randomUtils.randomFirstName)
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
            .pressSubmit()

            .tableResponsive("Student Name",randomUtils.randomFirstName + " " + randomUtils.randomLastName )
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
        }
    @Test
    void partialRegistrationTest(){
        registrationPage.openPage()
        .setFirstName(randomUtils.randomFirstName)
        .setLastName(randomUtils.randomLastName)
        .setGender(randomUtils.randomGender)
        .setNumber(randomUtils.randomPhoneNumb)
        .setDateOfBirth(randomUtils.randomDay,randomUtils.randomMoth,randomUtils.randomYear)
        .pressSubmit()

        .tableResponsive("Student Name",randomUtils.randomFirstName + " " + randomUtils.randomLastName )
        .tableResponsive("Gender",randomUtils.randomGender)
        .tableResponsive("Mobile",randomUtils.randomPhoneNumb)
        .tableResponsive("Date of Birth",randomUtils.randomDay + " " + randomUtils.randomMoth
                + "," + randomUtils.randomYear);
    }
    @Test
    void invalidRegistrationTest(){
        registrationPage.openPage()
        .setFirstName(randomUtils.randomFirstName)
        .setLastName(randomUtils.randomLastName)
        .setGender(randomUtils.randomGender)
        .setDateOfBirth(randomUtils.randomDay,randomUtils.randomMoth,randomUtils.randomYear)
        .pressSubmit()
        .incorrectResponsive();
    }
}
