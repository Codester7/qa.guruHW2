package pages;

import com.codeborne.selenide.SelenideElement;
import components.BirthdayComponent;
import components.ResultTableComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeForm {
    // components
    BirthdayComponent birthdayComponent = new BirthdayComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    // InputElements
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement userPhoneNumberInput = $("#userNumber");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement submitButton = $("#submit");
    SelenideElement inputuploadPicture = $("input#uploadPicture");
    SelenideElement stateInput = $("#react-select-3-input");
    SelenideElement cityInput = $("#react-select-4-input");
    SelenideElement closeModalButton = $("#closeLargeModal");


    public AutomationPracticeForm openForm() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public AutomationPracticeForm setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public AutomationPracticeForm setLastName(String lastname) {
        lastNameInput.setValue(lastname);
        return this;
    }

    public AutomationPracticeForm setuserEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public AutomationPracticeForm setuserPhoneNumber(String phone) {
        userPhoneNumberInput.setValue(phone);
        return this;
    }

    public AutomationPracticeForm currentAddress(String adress) {
        currentAddressInput.setValue(adress);
        return this;
    }

    public AutomationPracticeForm submitClick() {
        $(submitButton).scrollTo().click();
        return this;
    }

    public AutomationPracticeForm genderChoose(String value) {
        $$("#genterWrapper .col-md-9.col-sm-12 .custom-radio").find(text(value)).click();
        return this;
    }

    public AutomationPracticeForm setBDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        birthdayComponent.setDate(day, month, year);
        return this;
    }

    public AutomationPracticeForm setSubject(String subject) {
        $(subjectsInput).setValue(subject).pressEnter();
        return this;
    }

    public AutomationPracticeForm uploadFile(String path) {
        $(inputuploadPicture).uploadFile(new File(path));
        return this;
    }

    public AutomationPracticeForm setStateAndCity(String state, String city) {
        $(stateInput).setValue(state).pressEnter();
        $(cityInput).setValue(city).pressEnter();
        return this;
    }

    public AutomationPracticeForm setHobbies(String hobbie) {
        $$(".col-md-9.col-sm-12 .custom-checkbox").findBy(text(hobbie)).click();
        return this;
    }
    public AutomationPracticeForm closeModal() {
        $(closeModalButton).scrollTo().click();
        return this;
    }
    public AutomationPracticeForm checkResult (String key, String value){
        resultTableComponent.checkResult(key, value);

        return this;
    }
    public AutomationPracticeForm checkResultsTableVisible () {
        resultTableComponent.checkVisible();

        return this;
    }
}