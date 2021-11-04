import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Tests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Name");

        $("[id=lastName]").setValue("Surname");

        $("#userEmail").setValue("aaa@aa.aa");

        $("#genterWrapper").$(byText("Male")).click();

        $("[id=userNumber]").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(byClassName("react-datepicker__month-select")).click();
        $(byText("April")).click();
        $(byClassName("react-datepicker__year-select")).selectOptionByValue("1996");
        $$(".react-datepicker__day").find(Condition.text("15")).click();

        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("a");
        $(byText("Maths")).click();

        $(byText("Sports")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#currentAddress").setValue("Some address");

        $("[id=state]").scrollTo().click();
        $(byText("NCR")).click();

        $("[id=city]").click();
        $(byText("Delhi")).click();

        $("#submit").click();


        $(byClassName("modal-content")).shouldBe(enabled);
        $(byClassName("modal-content")).shouldHave(text("Name"));
        $(byClassName("modal-content")).shouldHave(text("Surname"));
        $(byClassName("modal-content")).shouldHave(text("aaa@aa.aa"));
        $(byClassName("modal-content")).shouldHave(text("Male"));
        $(byClassName("modal-content")).shouldHave(text("Maths"));
        $(byClassName("modal-content")).shouldHave(text("Sports"));
        $(byClassName("modal-content")).shouldHave(text("1234567890"));
        $(byClassName("modal-content")).shouldHave(text("Some address"));
        $(byClassName("modal-content")).shouldHave(text("15 April,1996"));
        $(byClassName("modal-content")).shouldHave(text("NCR"));
        $(byClassName("modal-content")).shouldHave(text("Delhi"));

    }
}
