import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterprizeTest {
    
    String confirmPage = "Build like the best";

    @BeforeAll

    static void beforeAll() {

        pageLoadStrategy = "eager";
        browserSize = "1920x1080";
        //holdBrowserOpen = true;
    }

    @Test

    void solutionsTest() {


        open("https://github.com/");

        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(byText("Enterprise")).click();

        $(".enterprise-hero").shouldHave(text(confirmPage));
    }

}
