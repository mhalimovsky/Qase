package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class NewProjectTest extends BaseTest {

    @Test(description = "Creation of new project with parameters {project.title}")
    public void createNewProject() {
        open("login");
        loginPage.login(user, password);
        projectsPage.clickNew();
        newProjectPage.inputProjectInfo("test", "test", "test");
        newProjectPage.checkProjectStatus();
        newProjectPage.delete();
    }
}
