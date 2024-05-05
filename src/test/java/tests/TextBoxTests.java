package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
public class TextBoxTests extends TestsBase {

    RegistrationPage registrationPage = new RegistrationPage();

        @Test
        void fillFormTest() {
            registrationPage.openPage()
            .setFirstName("Dmitry")
            .setLastName("Karpuk")
            .setEmailName("karpdima@mail.com")
            .setGender("Male")
            .setNumber("8033321517")
            .setDateOfBirth("4","June","1991")
            .setSubjects("math")
            .choiceHobbiesSports()
            .choiceHobbiesReading()
            .uploadFrom("jpg/cats.jpg")
            .setAddress("Belarus")
            .setState("Haryana")
            .setCity("Panipat")
            .pressSubmit()

            .tableResponsive("Student Name","Dmitry Karpuk")
            .tableResponsive("Student Email","karpdima@mail.com")
            .tableResponsive("Gender","Male")
            .tableResponsive("Mobile","8033321517")
            .tableResponsive("Date of Birth","04 June,1991")
            .tableResponsive("Subjects","Maths")
            .tableResponsive("Hobbies","Sports, Reading")
            .tableResponsive("Picture","cats.jpg")
            .tableResponsive("Address","Belarus")
            .tableResponsive("State and City","Haryana Panipat");

        }
    @Test
    void partialRegistrationTest(){
        registrationPage.openPage()
        .setFirstName("Olga")
        .setLastName("Davudik")
        .setGender("Female")
        .setNumber("8033321517")
        .setDateOfBirth("10","August","1993")
        .pressSubmit()

        .tableResponsive("Student Name","Olga Davudik")
        .tableResponsive("Gender","Female")
        .tableResponsive("Mobile","8033321517")
        .tableResponsive("Date of Birth","10 August,1993");

    }
    @Test
    void invalidRegistrationTest(){
        registrationPage.openPage()
        .setFirstName("Olga")
        .setLastName("Karp")
        .setGender("Female")
        .setNumber("")
        .setDateOfBirth("1","August","1993")
        .pressSubmit()
        .incorrectResponsive("border-color","rgb(220, 53, 69)");
    }
}
