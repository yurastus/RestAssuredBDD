package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.annotations.Loggable;
import static sharedData.Constants.RESPONSE;
import static sharedData.Constants.VALIDATABLE_RESPONSE;

public class Common {

    @Given("admin '(.+)' is logged in")
    @Loggable(message = "@Given")
    public void adminIsLoggedIn(String admin){
    }

    @Then("response status should be '(\\d+)'")
    @Loggable(message = "@Then")
    public void responseStatusShouldBe(int statusCode){
        VALIDATABLE_RESPONSE.set(RESPONSE.get().then().statusCode(statusCode));
    }

}