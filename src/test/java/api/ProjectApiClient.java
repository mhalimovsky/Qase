package api;

import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2

public class ProjectApiClient extends BaseApiClient {

    @Step("Creation of new project")
    public void createNewProject(Project project) {
        post(gson.toJson(project), "project");

    }

    @Step("Removing of project by code")
    public void deleteProjectByCode(String code) {
        log.info("Removing of new project by code");
        gson.fromJson(delete("project/" + code).asString(), Project.class);
    }

    @Step("Getting project info by code")
    public Project getProjectByCode(String code) {
        log.info("Getting project info by code");
        return gson.fromJson(get("project/" + code).path("result").toString(), Project.class);
    }
}
