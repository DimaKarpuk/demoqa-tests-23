package tests;
import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;


public class TextBoxTests extends TesteBase {

    RegistrationPage registrationPage = new RegistrationPage();

        @Test
        void fillFormTest() {
            registrationPage.openPage()
            .setFirstName("Dmitry")
            .setLastName("Karpuk")
            .setEmailName("karpdima@mail.com")
            .setGender("male")
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
}

