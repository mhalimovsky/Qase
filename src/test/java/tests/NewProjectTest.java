package tests;

import api.ProjectApiClient;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class NewProjectTest extends BaseTest {

    @Test(description = "Creation of new project")
    public void createNewProject() {
        open("login");
        loginPage.login(user, password);
        projectsPage.createNewProject();
        Faker projectFaker = new Faker();
        String projectName = projectFaker.code().ean8();
        String projectCode = projectFaker.code().ean8();
        String projectDescription = projectFaker.name().name();
        newProjectPage.inputProjectInfo(projectName, projectCode, projectDescription);
        assertEquals(projectName, repositoryPage.getProjectName(), "Project creation error");
        projectApiClient.deleteProjectByCode(projectCode);
        boolean projectAmount = projectsPage.checkProjectExistence(projectName);
        assertEquals(projectAmount, false, "Project deletion error");
    }
}
