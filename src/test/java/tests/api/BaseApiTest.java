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
        projectApiClient = new ProjectApiClient();
        suiteApiClient = new SuiteApiClient();
    }
}
