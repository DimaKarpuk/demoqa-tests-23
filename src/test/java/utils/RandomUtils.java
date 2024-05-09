package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    Faker faker = new Faker(new Locale("en-GB"));
    String[] hobbies = {"Sports","Reading","Music"};
    String[] subjects = {"Physics","Chemistry","Computer Science","Commerce",
            "Accounting","Economics","Social Studies","Civics"};
    String[] genders = {"Male", "Female", "Other"};
    String[] month = {"January","February","March","April","May","June",
            "July","August","September","October","November","December"};
    String[] randomLoad = {"cats.jpg", "dog.jpg", "pig.jpg"};

    public String

        randomFirstName = faker.name().firstName(),
        randomLastName = faker.name().lastName(),
        randomEmail = faker.internet().emailAddress(),
        randomGender = faker.options().option(genders),
        randomPhoneNumb = faker.phoneNumber().subscriberNumber(10),
        randomMoth = faker.options().option(month),
        randomYear = String.valueOf(faker.number().numberBetween(1980, 2020)),
        randomDay = String.valueOf(faker.number().numberBetween(1, 28)),
        randomSubjects = faker.options().option(subjects),
        randomHobbies = faker.options().option(hobbies),
        randomFileJpg = faker.options().option(randomLoad),
        randomAddress = (faker.address().country()),
        randomState = getRandomState(),
        randomCity = getRandomCity(randomState);




    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public  String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }
    public String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana","Rajasthan"};
        return getRandomItemFromArray(state);
    }
    public String getRandomCity(String randomState) {
        if (randomState.equals("NCR")) {
            String[] city = {"Delhi", "Gurgaon", "Noida"};
            return getRandomItemFromArray(city);
        } else if (randomState.equals("Uttar Pradesh")) {
            String[] city = {"Agra", "Lucknow", "Merrut"};
            return getRandomItemFromArray(city);
        } else if (randomState.equals("Haryana")) {
            String[] city = {"Karnal", "Panipat"};
            return getRandomItemFromArray(city);
        }
        String[] city = {"Jaipur", "Jaiselmer"};
        return getRandomItemFromArray(city);
    }
}