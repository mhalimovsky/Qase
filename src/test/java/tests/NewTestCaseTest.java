package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class NewTestCaseTest extends BaseTest {

    @Test(description = "Creation of new test case")
    public void newTestCaseTest() {
        open("login");
        loginPage.login(user, password);
        projectsPage.createNewProject();
        Faker ProjectFaker = new Faker();
        String projectName = ProjectFaker.name().name();
        String projectCode = ProjectFaker.code().asin();
        String projectDescription = ProjectFaker.name().name();
        newProjectPage.inputProjectInfo(projectName, projectCode, projectDescription);
        assertEquals(projectName, repositoryPage.getProjectName(), "Project creation error");
        repositoryPage.createNewSuite();
        Faker suiteFaker = new Faker();
        String suiteName = suiteFaker.name().name();
        String suiteCode = suiteFaker.code().asin();
        String suiteDescription = suiteFaker.name().name();
        newSuitePage.inputNewSuiteInfo(suiteName, suiteCode, suiteDescription);
        assertEquals(suiteName, repositoryPage.getSuiteName(), "Suite creation error");
        repositoryPage.createNewTestCase();
        Faker testCaseFaker = new Faker();
        String testCaseTitle = testCaseFaker.name().name();
        String testCaseDescription = testCaseFaker.name().name();
        newTestCasePage.inputTestCaseInfo(testCaseTitle, testCaseDescription);
        assertEquals(testCaseTitle, repositoryPage.getTestCaseTitle(), "Test-case creation error");
        repositoryPage.deleteTestCase();
        repositoryPage.deleteSuite();
        projectsPage.deleteProject();
        boolean projectAmount = projectsPage.checkProjectExistence(projectName);
        assertEquals(projectAmount, false, "Project deletion error");
    }
}
