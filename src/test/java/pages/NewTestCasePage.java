package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
@Data

public class NewTestCasePage extends BasePage {
    protected final SelenideElement TEST_CASE_TITLE = $("#title");
    protected final SelenideElement TEST_CASE_DESCRIPTION = $("#save-case");
    protected final SelenideElement SAVE_BUTTON = $("p.empty-node");
    @Step("Entering data into the test-case")
    public void inputTestCaseInfo(String title, String description) {
        log.info("Entering data into the test-case created by faker");
        TEST_CASE_TITLE.sendKeys(title);
        TEST_CASE_DESCRIPTION.sendKeys(description);
        SAVE_BUTTON.click();
    }
}
