package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
@Data
public class RepositoryPage extends BasePage {
    protected final SelenideElement CREATE_SUITE_BUTTON = $("#create-suite-button");
    protected final SelenideElement CREATE_TEST_CASE_BUTTON = $("#create-case-button");
    protected final SelenideElement DELETE_SUITE_BUTTON = $("i.fa-trash");
    protected final SelenideElement SELECT_TEST_CASE_BUTTON = $("[type=checkbox]");
    protected final SelenideElement CONFIRM_BUTTON = $("button.btn.btn-danger");
    protected final SelenideElement DELETE_ICON_INPUT = $("[name=confirm]");
    protected final SelenideElement DELETE_TEST_CASE_BUTTON = $("i.fa.fa-trash");
    protected final SelenideElement PROJECT_NAME = $("p.header");
    protected final SelenideElement SUITE_NAME = $("span.style_titleText-2sGhc");
    protected final SelenideElement TEST_CASE_TITLE = $("div.style_itemCell-3gHZi.style_title-3pZF1");
    protected final SelenideElement TEST_RUN_PAGE_LINK = $("#menu-link-test-runs");

    @Step("Creation of new repository")
    public void createNewSuite() {
        log.info("Creation of new repository in 'test' project with name, description and preconditions");
        CREATE_SUITE_BUTTON.click();
    }
    @Step("Creation a new test case")
    public void createNewTestCase() {
        CREATE_TEST_CASE_BUTTON.click();

    }
    @Step("Creation a new test run")
    public void createNewTestRun() {
        TEST_RUN_PAGE_LINK.click();
    }

    @Step("Removing the suite")
    public void deleteSuite() {
        log.info("Removing suite with name 'test'");
        DELETE_SUITE_BUTTON.click();
    }
    @Step("Removing the test case")
    public void deleteTestCase() {
        log.info("Removing suite with name 'test'");
        SELECT_TEST_CASE_BUTTON.click();
        DELETE_TEST_CASE_BUTTON.click();
        DELETE_ICON_INPUT.shouldBe(Condition.visible);
        DELETE_ICON_INPUT.click();
        DELETE_ICON_INPUT.sendKeys("CONFIRM");
        CONFIRM_BUTTON.click();
    }

    @Step("Checking for successful creation of new project by name")
    public String getProjectName() {
        String projectName = PROJECT_NAME.getText();
        return projectName;
    }

    @Step("Getting suit name")
    public String getSuiteName() {
        String suiteName = SUITE_NAME.getText();
        return suiteName;
    }
    @Step("Getting testcase title")
    public String getTestCaseTitle() {
        String testCaseTitle = TEST_CASE_TITLE.getText();
        return testCaseTitle;
    }
}