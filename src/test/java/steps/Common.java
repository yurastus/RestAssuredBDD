package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.annotations.Loggable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import tools.PropertyLoader;
import static sharedData.Constants.REQUEST_SPECIFICATION;
import static sharedData.Constants.RESPONSE;
import static sharedData.Constants.VALIDATABLE_RESPONSE;
import static io.restassured.RestAssured.given;

public class Common {

    @Given("admin '(.+)' is logged in")
    @Loggable(message = "@Given")
    public void adminIsLoggedIn(String admin){
        RestAssured.baseURI = PropertyLoader.load("url") + "users";
        REQUEST_SPECIFICATION.set(given().accept(ContentType.JSON).contentType(ContentType.JSON));
    }

    @Then("response status should be '(\\d+)'")
    @Loggable(message = "@Then")
    public void responseStatusShouldBe(int statusCode){
        VALIDATABLE_RESPONSE.set(RESPONSE.get().then().statusCode(statusCode));
    }

}