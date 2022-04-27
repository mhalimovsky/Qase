package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class NewProjectTest extends BaseTest {

    @Test(description = "Creation of new project")
    public void createNewProject() {
        open("login");
        loginPage.login(user, password);
        projectsPage.clickNew();
        newProjectPage.inputProjectInfo("test", "test", "test");
    }
}
