package tests.api;

import api.ProjectApiClient;
import api.SuiteApiClient;
import com.codeborne.selenide.Configuration;
import dto.Project;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    protected ProjectApiClient projectApiClient;
    protected SuiteApiClient suiteApiClient;
    protected Project project;

    @BeforeMethod(description = "Start API tests")
    public void setUp() {
        Configuration.baseUrl = "https://app.qase.io/";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;

        projectApiClient = new ProjectApiClient();
        suiteApiClient = new SuiteApiClient();
    }
}
