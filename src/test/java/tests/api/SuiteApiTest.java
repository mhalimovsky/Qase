package tests.api;

import dto.Suite;
import org.testng.annotations.Test;

public class SuiteApiTest extends BaseApiTest {

    @Test(description = "CreationOfNewSuiteByAPI")
    public void createNewProjectTest() {
        Suite suite = Suite.
                builder().
                name("APITEST").
                description("SOMEDESCRIPT").
                preconditions("Some").
                build();
        suiteApiClient.createNewSuite(suite, project.getCode());
    }
}

