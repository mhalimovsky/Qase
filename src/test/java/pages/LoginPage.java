package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
@Data
public class LoginPage extends BasePage {

    protected final SelenideElement EMAIL_INPUT = $("#inputEmail");
    protected final SelenideElement PASSWORD_INPUT = $("#inputPassword");
    protected final SelenideElement LOGIN_BUTTON = $("#btnLogin");

    @Step("Login with data from config.properties file")
    public void login(String email, String password) {
        log.info("Login with {}, {}", email, password);
        open("login");
        EMAIL_INPUT.sendKeys(email);
        PASSWORD_INPUT.sendKeys(password);
        LOGIN_BUTTON.click();
    }
}
