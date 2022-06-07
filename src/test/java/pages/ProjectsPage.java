package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
@Data
public class ProjectsPage {

    protected final SelenideElement CREATE_BUTTON = $("#createButton");
    protected final SelenideElement CREATE_PROJECT_BUTTON = $("[type=submit]");
    protected final SelenideElement PROJECTS_SORTING_BUTTON = $(By.className("sortable"));
    protected final SelenideElement PROJECT_SETTING_BUTTON = $("a.btn.btn-dropdown");
    protected final SelenideElement DELETE_BUTTON = $("a.text-danger");
    protected final SelenideElement SUBMIT_BUTTON = $("button.btn.btn-cancel");
    protected final SelenideElement SEARCH_PROJECT = $("input.form-control.search-input");


    @Step("Creation of new project")
    public void createNewProject() {
        log.info("Click on 'new-project' button");
        CREATE_BUTTON.click();
        sleep(500);
        CREATE_PROJECT_BUTTON.shouldBe(Condition.visible);
    }

    @Step("Removing the project")
    public void deleteProject() {
        log.info("Removing the project");
        open("projects");
        PROJECTS_SORTING_BUTTON.click();
        PROJECT_SETTING_BUTTON.click();
        DELETE_BUTTON.click();
        SUBMIT_BUTTON.click();
    }

    @Step("Project existence verification by name")
    public boolean checkProjectExistence(String name) {
        log.info("Does project" + name + "exists");
        open("projects");
        SEARCH_PROJECT.sendKeys(name);
        return $$(byText(name)).size() > 0;
    }
}

