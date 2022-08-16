package tests;

import org.junit.jupiter.api.Test;

public class FirstTest extends BaseTest {


    @Test
    void hw2Test() throws InterruptedException {
        // Открытие формы и заполнение полей
        automationPracticeForm.openForm()
                .setFirstName(firstName)
                .setLastName(LastName)
                .setuserEmail(userEmail)
                .genderChoose(gender)
                .setuserPhoneNumber(phoneNumber)
                .setBDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbie)
                .uploadFile(filePath + fileName)
                .currentAddress(curentAdress)
                .setStateAndCity(state, city)
                .submitClick();

        // Проверка значения на модальном окне
        automationPracticeForm.checkResultsTableVisible()
                .checkResult("Student Name", fullName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", DateofBirthFull)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbie)
                .checkResult("Picture", fileName)
                .checkResult("Address", curentAdress)
                .checkResult("State and City", stateAndCityFull)
                .closeModal();


    }
}