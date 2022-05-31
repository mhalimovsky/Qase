package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
@Data
public class NewRepositoryPage extends BasePage {

    protected final SelenideElement SUITE_BUTTON = $("#create-suite-button");
    protected final SelenideElement SUITE_NAME = $("#name");
    protected final SelenideElement SUITE_DESCRIPTION = $("#description");
    protected final SelenideElement SUITE_PRECONDITION = $("#preconditions");
    protected final SelenideElement CREATE_SUITE_BUTTON = $("#save-suite-button");

    @Step("Creation of new repository")
    public void create(String name, String Description, String Preconditions) {
        log.info("Creation of new repository in 'test' project with name, description and preconditions");
        SUITE_BUTTON.click();
        SUITE_NAME.sendKeys(name);
        SUITE_DESCRIPTION.sendKeys(Description);
        SUITE_PRECONDITION.sendKeys(Preconditions);
        CREATE_SUITE_BUTTON.click();
    }
}
