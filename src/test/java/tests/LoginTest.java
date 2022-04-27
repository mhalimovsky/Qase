package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test(description = "Login with {user}, {password}")
    public void login() {
        open("login");
        loginPage.login(user, password);
    }
}
