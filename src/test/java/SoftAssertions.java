

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {

    @BeforeAll
    static void init() {
        holdBrowserOpen = true;
        pageLoadStrategy = "eager";
        baseUrl = "https://github.com";
    }

    @Test
    void shouldHaveJUnit5CodeExamples() {

        open("/selenide/selenide");
        
      
        $("ul.UnderlineNav-body").$("#wiki-tab").click();
       
        SelenideElement rightBar = $(".wiki-rightbar");
        rightBar.$(byText("Show 2 more pages…")).click();
        rightBar.$(byText("SoftAssertions")).click();
        
        $("#wiki-content .markdown-body")
                .$$("div pre")
                .findBy(text("@ExtendWith({SoftAssertsExtension.class})"))
                .shouldHave(text("class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
    }
}