package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.PropertyReader;

public class BaseTest {

    public String user;
    public String password;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected NewProjectPage newProjectPage;
    protected ProjectsPage projectsPage;
    protected RepositoryPage repositoryPage;
    protected NewSuitePage newSuitePage;
    protected NewTestCasePage newTestCasePage;
    protected NewTestRunPage newTestRunPage;

    @BeforeMethod(description = "Opening browser")
    public void setUp() {
        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));

        Configuration.baseUrl = "https://app.qase.io/";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.timeout = 20000;

        basePage = new BasePage();
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        repositoryPage = new RepositoryPage();
        newProjectPage = new NewProjectPage();
        newSuitePage = new NewSuitePage();
        newTestCasePage = new NewTestCasePage();
        newTestRunPage = new NewTestRunPage();
    }

    @AfterMethod(alwaysRun = true, description = "Closing Browser")
    public void close() {
        Selenide.closeWebDriver();
    }
}
