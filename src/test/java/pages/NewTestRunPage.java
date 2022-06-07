package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Log4j2


public class NewTestRunPage extends BasePage {

    protected final SelenideElement START_TEST_RUN_BUTTON = $("#start-new-test-run-button");
    protected final SelenideElement ADD_TEST_CASE_BUTTON = $("#edit-run-add-cases-button");
    protected final SelenideElement SELECT_TEST_CASE = $("span.custom-control-indicator");
    protected final SelenideElement CONFIRM_BUTTON = $("#select-cases-done-button");
    protected final SelenideElement START_RUN_BUTTON = $("#save-run-button");
    protected final SelenideElement TEST_RUN_LINK = $("#run-1-title");
    protected final SelenideElement COMPLETE_TEST_RUN_BUTTON = $("i.fa.fa-check");
    protected final SelenideElement SUBMIT_BUTTON = $("#run-complete-modal-submit-button");
    protected final SelenideElement REPORT_BUTTON = $("#share-report-button");
    protected final SelenideElement EXIT_BUTTON = $("i.submenu-toggle.fas.fa-arrow-left");
    protected final SelenideElement TEST_RUN_MENU = $("a.btn.btn-dropdown");
    protected final SelenideElement DELETE_TEST_RUN_BUTTON = $("a.text-danger");
    protected final SelenideElement CONFIRM_DELETE_BUTTON = $("button.btn.btn-cancel");
    protected final SelenideElement SETTINGS_LINK = $("[title=Settings]");
    protected final SelenideElement REPOSITORY_LINK = $("svg.svg-inline--fa.fa-list-tree.fa-fw.ZP37cN");

    @Step("Starting new test run")
    public void startNewTestRun() {
        log.info("Starting new test run,that was created by faker on NewTestRunPage");
        START_TEST_RUN_BUTTON.click();
        sleep(300);
        ADD_TEST_CASE_BUTTON.click();
        sleep(300);
        SELECT_TEST_CASE.click();
        sleep(300);
        CONFIRM_BUTTON.click();
        sleep(300);
        START_RUN_BUTTON.click();
    }

    @Step("Test run status verification")
    public String checkTestRunStatus() {
        log.info("Getting from NewTestRanPage information about test run successfully started");
        TEST_RUN_LINK.click();
        sleep(300);
        COMPLETE_TEST_RUN_BUTTON.click();
        sleep(300);
        SUBMIT_BUTTON.click();
        sleep(300);
        REPORT_BUTTON.shouldBe(Condition.visible);
        String testRunExistStatus = REPORT_BUTTON.getText();
        return testRunExistStatus;
    }

    @Step("Test run removal")
    public void deleteTestRun() {
        log.info("Delete test run, that was created by faker on NewTestRunPage");
        EXIT_BUTTON.click();
        TEST_RUN_MENU.click();
        DELETE_TEST_RUN_BUTTON.click();
        sleep(300);
        CONFIRM_DELETE_BUTTON.click();
        sleep(300);
        REPOSITORY_LINK.click();
        sleep(500);

    }
}
