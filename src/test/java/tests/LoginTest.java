package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test(description = "Login test")
    public void login() {
        open("login");
        loginPage.login(user, password);
    }
}
