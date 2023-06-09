import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {

        baseUrl = "https://the-internet.herokuapp.com";
        browserSize = "1920x1080";
        pageLoadStrategy = "eager";
        //holdBrowserOpen = true;
    }

    @Test
    void dragAndDropTest() {
        open("/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
