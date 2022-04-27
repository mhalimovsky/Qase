package tests.api;

import dto.Counts;
import dto.Project;
import dto.Suite;
import org.testng.annotations.Test;

public class ProjectApiTest extends BaseApiTest {


    @Test(description = "Creation of New project and suite by API")
    public void createNewProjectTest() {
        Project project = Project.
                builder().
                code("APITEST").
                name("APITEST").
                description("SOMEDESCRIPT").
                counts(new Counts(123)).
                build();
        projectApiClient.createNewProject(project);
        projectApiClient.getProjectByCode(project.getCode());
        Suite suite = Suite.
                builder().
                name("APITEST").
                description("SOMEDESCRIPTION").
                Preconditions("Some").
                build();
        suiteApiClient.createNewSuite(suite, project.getCode());
        projectApiClient.deleteProjectByCode(project.getCode());
    }
}
