package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import pages.AutomationPracticeForm;

import java.util.Locale;

import static java.lang.String.format;

public class BaseTest {

    // Экземпляры классов описаных страниц:
    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();
    Faker faker = new Faker(new Locale("ru"));
    Faker emailFaker = new Faker(new Locale("en"));


    // Переменные:
    String firstName = faker.name().firstName(),
            LastName = faker.name().lastName(),
            fullName = format("%s %s", firstName, LastName),
            userEmail = emailFaker.internet().emailAddress(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10) + "",
            curentAdress = faker.address().fullAddress(),
            year = faker.number().numberBetween(1900, 2100) + "",
            month = automationPracticeForm.getMonth(faker.number().numberBetween(1, 12) + ""),
            day = automationPracticeForm.getDay(faker.number().numberBetween(1, 30)),
            DateofBirthFull = format("%s %s,%s", day, month, year),
            gender = automationPracticeForm.getGender(faker.number().numberBetween(1, 3) + ""),
            hobbie = automationPracticeForm.getHobbie(faker.number().numberBetween(1, 3) + ""),
            fileName = "3045-saunders-gentoo_RJ.jpg",
            filePath = "src/test/resources/",
            subject = "Arts",
            state = "NCR",
            city = "Noida",
            stateAndCityFull = format("%s %s", state, city);


    @BeforeAll
    static void configure() {
        Configuration.browserSize = "400x1028";
    }
}