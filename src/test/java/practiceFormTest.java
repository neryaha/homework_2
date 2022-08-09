import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class practiceFormTest {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void formTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("test@test.test");

        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("8800123459");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1986");
        $(".react-datepicker__day--001").click();

        $("#subjectsInput").setValue("Math").pressEnter();

        $("[for='hobbies-checkbox-3']").click();

        $("#uploadPicture").uploadFromClasspath("tst.jpg");

        $("#currentAddress").setValue("Test Location 129");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $(".modal-content").shouldHave(text("Ivan"),
                text("Ivanov"),
                text("test@test.test"),
                text("Male"),
                text("8800123456"),
                text("01 January,1987"),
                text("Maths"),
                text("Music"),
                text("tst.jpg"),
                text("Test Location 123"),
                text("NCR Delhi"));

    }
}