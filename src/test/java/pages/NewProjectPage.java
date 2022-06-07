package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Log4j2
@Data

public class NewProjectPage extends BasePage {

    protected final SelenideElement NEW_PROJECT_BUTTON = $("#createButton");
    protected final SelenideElement PROJECT_NAME = $("#inputTitle");
    protected final SelenideElement PROJECT_CODE = $("#inputCode");
    protected final SelenideElement PROJECT_DESCRIPTION = $("#inputDescription");
    protected final SelenideElement PUBLIC_PROJECT_TYPE = $("#public-access-type");
    protected final SelenideElement CREATE_BUTTON = $("[type=submit]");


    @Step("Entering data into the project")
    public void inputProjectInfo(String name, String code, String description) {
        log.info("Creation of project with data: {}, {}, {}", name, code, description);
        PROJECT_NAME.sendKeys(name);
        sleep(300);
        PROJECT_CODE.sendKeys(code);
        sleep(300);
        PROJECT_DESCRIPTION.sendKeys(description);
        sleep(300);
        PUBLIC_PROJECT_TYPE.click();
        CREATE_BUTTON.click();
    }
}
