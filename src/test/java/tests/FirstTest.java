package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;

public class FirstTest {
    AutomationPracticeForm automationPracticeForm = new AutomationPracticeForm();


    @BeforeAll
    static void configure() {

        Configuration.browserSize = "400x1028";
    }

    @Test
    void hw2Test() throws InterruptedException {
        // Открытие формы и заполнение полей
        automationPracticeForm.openForm()
                .setFirstName("Влад")
                .setLastName("Дракула")
                .setuserEmail("dracula@muhahah.com")
                .genderChoose("Male")
                .setuserPhoneNumber("9666666666")
                .setBDate("01", "July", "1990")
                .setSubject("Arts")
                .setHobbies("Music")
                .uploadFile("src/test/resources/3045-saunders-gentoo_RJ.jpg")
                .currentAddress("Улица Пушкина, дом Колотушкина")
                .setStateAndCity("NCR", "Noida")
                .submitClick();

        // Проверка значения на модальном окне
        automationPracticeForm.checkResultsTableVisible()
                .checkResult("Student Name", "Влад Дракула")
                .checkResult("Student Email", "dracula@muhahah.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9666666666")
                .checkResult("Date of Birth", "01 July,1990")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "3045-saunders-gentoo_RJ.jpg")
                .checkResult("Address", "Улица Пушкина, дом Колотушкина")
                .checkResult("State and City", "NCR Noida")
                .closeModal();


    }
}