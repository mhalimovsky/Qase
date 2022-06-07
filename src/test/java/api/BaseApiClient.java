package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class BaseApiClient {
    RequestSpecification requestSpecification;
    String baseUrl;
    Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public BaseApiClient() {
        requestSpecification =
                given().
                        header("token", PropertyReader.getProperty("token")).
                        header("Content-type", "application/json").
                        log().all();
        baseUrl = PropertyReader.getProperty("url");
    }

    public void post(String body, String uri) {
        requestSpecification.
                body(body).
                when().
                post(baseUrl + uri).
                then().
                log().all().
                statusCode(200);
    }

    public Response get(String uri) {
        return
                requestSpecification.
                        when().
                        get(baseUrl + uri).
                        then().
                        log().all().
                        statusCode(200).
                        extract().response();
    }

    public Response delete(String uri) {
        return
                requestSpecification.
                        when().
                        delete(baseUrl + uri).
                        then().
                        log().all().
                        statusCode(200).
                        extract().response();
    }
}

