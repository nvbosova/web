import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class DebitCardApplicationTest {

    private WebDriver driver;

    @BeforeAll
    static void setDriverPath() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\web\\driver\\chromedriver.exe");
    }


    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
       SelenideElement form = $("[method=post]");
     form.$("[data-test-id=name] input").setValue("Василий");
     form.$("[data-test-id=phone] input").setValue("+79270000000");
     form.$("[data-test-id=agreement]").click();
     form.$("[role=button]").click();
     $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldSendRequestIfNameHyphen() {
        open("http://localhost:9999");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=name] input").setValue("Василий-Василий");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldSendRequestIfNameSpace() {
        open("http://localhost:9999");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=name] input").setValue("Василий Василий");
        form.$("[data-test-id=phone] input").setValue("+79270000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }


    }
