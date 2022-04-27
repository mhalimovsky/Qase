package api;


import dto.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2

public class SuiteApiClient extends BaseApiClient {

    @Step("Creation of new suite in the project")
    public void createNewSuite(Suite suite, String code) {
        log.info("Creation of new suite in the projecte");
        post(gson.toJson(suite), "suite/" + code);
    }
}
