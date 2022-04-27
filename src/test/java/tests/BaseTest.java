package tests;

import com.codeborne.selenide.Configuration;
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
    protected NewRepositoryPage newRepositoryPage;


    @BeforeMethod(description = "Opening browser")
    public void setUp() {
        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));

        Configuration.baseUrl = "https://app.qase.io/";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;

        basePage = new BasePage();
        loginPage = new LoginPage();
        newProjectPage = new NewProjectPage();
        projectsPage = new ProjectsPage();
        newRepositoryPage = new NewRepositoryPage();
    }
}