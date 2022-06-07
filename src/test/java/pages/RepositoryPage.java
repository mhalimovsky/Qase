package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Log4j2
@Data
public class RepositoryPage extends BasePage {
    protected final SelenideElement CREATE_SUITE_BUTTON = $("#create-suite-button");
    protected final SelenideElement CREATE_TEST_CASE_BUTTON = $("#create-case-button");
    protected final SelenideElement DELETE_SUITE_BUTTON = $("i.fa-trash");
    protected final SelenideElement SELECT_TEST_CASE_BUTTON = $("[type=checkbox]");
    protected final SelenideElement CONFIRM_BUTTON = $("button.LzLtDS.R1y8iB.MBIQEc");
    protected final SelenideElement DELETE_ICON_INPUT = $("[name=confirm]");
    protected final SelenideElement DELETE_TEST_CASE_BUTTON = $("i.fa.fa-trash");
    protected final SelenideElement PROJECT_NAME = $("div.sqabXr");
    protected final SelenideElement SUITE_NAME = $("a.Vap5jx");
    protected final SelenideElement TEST_CASE_TITLE = $("div.jp0OXJ.nzJYNg");
    protected final SelenideElement TEST_RUN_PAGE_LINK = $("svg.svg-inline--fa.fa-play.fa-fw.ZP37cN");
    protected final SelenideElement REPOSITORY_LINK = $("svg.svg-inline--fa.fa-list-tree.fa-fw.ZP37cN");


    @Step("Creation of new repository")
    public void createNewSuite() {
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
        DELETE_SUITE_BUTTON.click();
        sleep(300);

    }

    @Step("Removing the test case")
    public void deleteTestCase() {
        log.info("Removing suite, that was created by faker'");
        REPOSITORY_LINK.click();
        SELECT_TEST_CASE_BUTTON.click();
        DELETE_TEST_CASE_BUTTON.click();
        DELETE_ICON_INPUT.shouldBe(Condition.visible);
        DELETE_ICON_INPUT.click();
        DELETE_ICON_INPUT.sendKeys("CONFIRM");
        CONFIRM_BUTTON.click();
        sleep(300);
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