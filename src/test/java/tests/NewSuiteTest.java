package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class NewSuiteTest extends BaseTest {

    @Test(description = "Creation of new suite")
    public void newSuiteCreation() {
        open("login");
        loginPage.login(user, password);
        projectsPage.clickNew();
        newProjectPage.inputProjectInfo("test", "test", "test");
        newRepositoryPage.create("test", "test", "test");
        newProjectPage.delete();
    }
}
