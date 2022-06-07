package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Log4j2
@Data

public class NewSuitePage {
    protected final SelenideElement SUITE_NAME_INPUT = $("#name");
    protected final SelenideElement SUITE_DESCRIPTION_INPUT = $("#description");
    protected final SelenideElement SUITE_PRECONDITION_INPUT = $("#preconditions");
    protected final SelenideElement CREATE_SUITE_BUTTON = $("#save-suite-button");


    @Step("Creation of new suite")
    public void inputNewSuiteInfo(String name, String description, String preconditions) {
        log.info("Creation of new suite with data: {} {} {}", name, description, preconditions);
        SUITE_NAME_INPUT.sendKeys(name);
        sleep(500);
        SUITE_DESCRIPTION_INPUT.sendKeys(description);
        sleep(500);
        SUITE_PRECONDITION_INPUT.sendKeys(preconditions);
        sleep(500);
        CREATE_SUITE_BUTTON.click();
    }
}
