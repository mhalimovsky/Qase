package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
@Data

public class NewProjectPage extends BasePage {

    protected final SelenideElement NEW_PROJECT_BUTTON = $("#createButton");
    protected final SelenideElement PROJECT_NAME = $("#inputTitle");
    protected final SelenideElement PROJECT_CODE = $("#inputCode");
    protected final SelenideElement PROJECT_DESCRIPTION = $("#inputDescription");
    protected final SelenideElement PUBLIC_PROJECT_TYPE = $("#public-access-type");
    protected final SelenideElement PRIVATE_PROJECT_TYPE = $("#private-access-type");
    protected final SelenideElement PROJECT_SETTINGS = $x("//span[text()='Settings']");
    protected final SelenideElement DELETE_BUTTON = $(".btn-cancel");
    protected final SelenideElement CREATE_BUTTON = $("[type=submit]");

    @Step("Entering data into the project")
    public void inputProjectInfo(String name, String code, String Description) {
        log.info("Entering data into the project");
        PROJECT_NAME.sendKeys(name);
        PROJECT_CODE.sendKeys(code);
        PROJECT_DESCRIPTION.sendKeys(Description);
        PUBLIC_PROJECT_TYPE.click();
        CREATE_BUTTON.click();
    }

    @Step("Removing the project")
    public void delete() {
        PROJECT_SETTINGS.click();
        DELETE_BUTTON.click();
        DELETE_BUTTON.click();
    }
}
