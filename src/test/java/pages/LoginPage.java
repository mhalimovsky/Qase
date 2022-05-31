package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
@Data
public class LoginPage extends BasePage {

    protected final SelenideElement EMAIL_INPUT = $("#inputEmail");
    protected final SelenideElement PASSWORD_INPUT = $("#inputPassword");
    protected final SelenideElement LOGIN_BUTTON = $("#btnLogin");
    protected final SelenideElement USER_MENU = $("#user-menu");

    @Step("Login with {user}, {password}")
    public void login(String email, String password) {
        log.info("Login with {user}, {password} from config.properties file");
        EMAIL_INPUT.sendKeys(email);
        PASSWORD_INPUT.sendKeys(password);
        LOGIN_BUTTON.click();
        USER_MENU.shouldBe(Condition.visible);
    }
}
