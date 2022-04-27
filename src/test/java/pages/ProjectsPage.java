package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
@Data
public class ProjectsPage {

    protected final SelenideElement CREATE_BUTTON = $("#createButton");
    protected final SelenideElement CREATE_PROJECT_BUTTON = $("[type=submit]");

    @Step("Click on 'new-project' button")
    public void clickNew() {
        log.info("Click on 'new-project' button");
        CREATE_BUTTON.click();
        CREATE_PROJECT_BUTTON.shouldBe(Condition.visible);
    }
}

