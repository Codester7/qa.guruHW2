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

    public AutomationPracticeForm checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }

    public AutomationPracticeForm checkResultsTableVisible() {
        resultTableComponent.checkVisible();

        return this;
    }
// Метод для рандомного выбора месяца
    public String getMonth(String month) {
        if (month.equals("01") || month.equals("1") || month.equals("January")) {
            return "January";
        } else if (month.equals("02") || month.equals("2") || month.equals("February")) {
            return "February";
        } else if (month.equals("03") || month.equals("3") || month.equals("March")) {
            return "March";
        } else if (month.equals("04") || month.equals("4") || month.equals("April")) {
            return "April";
        } else if (month.equals("05") || month.equals("5") || month.equals("May")) {
            return "May";
        } else if (month.equals("06") || month.equals("6") || month.equals("June")) {
            return "June";
        } else if (month.equals("07") || month.equals("7") || month.equals("July")) {
            return "July";
        } else if (month.equals("08") || month.equals("8") || month.equals("August")) {
            return "August";
        } else if (month.equals("09") || month.equals("9") || month.equals("September")) {
            return "August";
        } else if (month.equals("010") || month.equals("10") || month.equals("October")) {
            return "August";
        } else if (month.equals("011") || month.equals("11") || month.equals("November")) {
            return "August";
        } else if (month.equals("012") || month.equals("12") || month.equals("December")) {
            return "August";
        }
        return month;
    }
// Метод для рандомного выбора дня месяца
    public String getDay(int day) {
        if (day > 0 && day <= 9) {
            return "0" + day;
        }
        return day + "";
    }
    // Метод для рандомного выбора гендорной принадлежности
    public String getGender(String gender) {
        if (gender.equals("1")) {
            return "Male";
        } else if (gender.equals("2")) {
            return "Female";
        } else {
            return "Other";
        }

    }
// Метод для рандомного выбора хобби
    public String getHobbie(String hobbie) {
        if (hobbie.equals("1")) {
            return "Music";
        } else if (hobbie.equals("2")) {
            return "Reading";
        } else {
            return "Sports";
        }

    }


}