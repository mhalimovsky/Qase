package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class NewSuiteTest extends BaseTest {

    @Test(description = "Creation of new suite")
    public void newSuiteCreation() {
        open("login");
        loginPage.login(user, password);
        projectsPage.createNewProject();
        Faker projectFaker = new Faker();
        String projectName = projectFaker.name().name();
        String projectCode = projectFaker.code().asin();
        String projectDescription = projectFaker.name().name();
        newProjectPage.inputProjectInfo(projectName, projectCode, projectDescription);
        assertEquals(projectName, repositoryPage.getProjectName());
        Faker suiteFaker = new Faker();
        String suiteName = suiteFaker.name().name();
        String suiteCode = suiteFaker.code().asin();
        String suiteDescription = suiteFaker.name().name();
        repositoryPage.createNewSuite();
        newSuitePage.inputNewSuiteInfo(suiteName, suiteCode, suiteDescription);
        assertEquals(suiteName, repositoryPage.getSuiteName(), "Suite creation error");
        repositoryPage.deleteSuite();
        projectsPage.deleteProject();
        boolean projectAmount = projectsPage.checkProjectExistence(projectName);
        assertEquals(projectAmount, false, "Project deletion error");
    }
}
