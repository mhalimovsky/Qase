package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NewTestRunTest extends BaseTest {

    @Test(description = "Creation of new test run")
    public void newTestCaseTest() {
        loginPage.login(user, password);
        projectsPage.createNewProject();
        Faker projectFaker = new Faker();
        String projectName = projectFaker.name().name();
        String projectCode = projectFaker.code().asin();
        String projectDescription = projectFaker.name().name();
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
        repositoryPage.createNewTestRun();
        newTestRunPage.startNewTestRun();
        assertEquals(newTestRunPage.checkTestRunStatus(), "Share report", "Test-run creation error");
        newTestRunPage.deleteTestRun();
        repositoryPage.deleteTestCase();
        repositoryPage.deleteSuite();
        projectsPage.deleteProject();
        String projectAmount = projectsPage.checkProjectExistence();
        assertEquals(projectAmount, "Looks like you don’t have any projects yet.", "Project deletion error");
    }
}
