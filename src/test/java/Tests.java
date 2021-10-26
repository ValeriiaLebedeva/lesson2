import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Tests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Some name");
        $("#userEmail").setValue("aaa@aa.aa");
        $("#currentAddress").setValue("Some address");
        $("#permanentAddress").setValue("Another address");
        $("#submit").click();

        $("#output #name").shouldHave(text("Some name"));
        $("#output").$("#email").shouldHave(text("aaa@aa.aa"));
        $("#output").$("#currentAddress").shouldHave(text("Some address"));
        $("#output").$("#permanentAddress").shouldHave(text("Another address"));

//        $("#output").shouldHave(text("Some name"), text("aaa@aa.aa"),
//                text("Some address"), text("Another address"));
    }
}
