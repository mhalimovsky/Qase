package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
@Data

public class NewSuitePage {
    protected final SelenideElement SUITE_NAME_INPUT = $("#name");
    protected final SelenideElement SUITE_DESCRIPTION_INPUT = $("#description");
    protected final SelenideElement SUITE_PRECONDITION_INPUT = $("#preconditions");
    protected final SelenideElement CREATE_SUITE_BUTTON = $("#save-suite-button");


    @Step("Creation of new suite")
    public void inputNewSuiteInfo(String name, String Description, String Preconditions) {
        log.info("Creation of new suite with data: {} {} {}", name, Description, Preconditions);
        SUITE_NAME_INPUT.sendKeys(name);
        SUITE_DESCRIPTION_INPUT.sendKeys(Description);
        SUITE_PRECONDITION_INPUT.sendKeys(Preconditions);
        CREATE_SUITE_BUTTON.click();
    }
}
