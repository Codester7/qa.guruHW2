package test.vlad;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class FirstTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "400x1028";
    }


    @Test
    void hw2Test() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Влад");
        $("#lastName").setValue("Дракула");
        $("#userEmail").setValue("dracula@muhahah.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("9666666666");
        $("#dateOfBirthInput").click();
        $("[Class=react-datepicker__year-select]").selectOption("1990");
        $("[Class=react-datepicker__month-select]").selectOption("July");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/3045-saunders-gentoo_RJ.jpg"));
        $("#currentAddress").setValue("Улица Пушкина, дом Колотушкина");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Влад Дракула"));
        $(".modal-body").shouldHave(text("dracula@muhahah.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9666666666"));
        $(".modal-body").shouldHave(text("01 July,1990"));
        $(".modal-body").shouldHave(text("Arts"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("3045-saunders-gentoo_RJ.jpg"));
        $(".modal-body").shouldHave(text("Улица Пушкина, дом Колотушкина"));
        $(".modal-body").shouldHave(text("NCR Noida"));

        $("#closeLargeModal").click();


    }
}