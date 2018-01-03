package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import dataModels.User;
import framework.annotations.Loggable;
import tools.CRUD;
import tools.JacksonUtils;
import tools.PropertyLoader;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static sharedData.Constants.*;

public class SearchCustomer {

    @When("admin searches for all users")
    @Loggable(message = "@When")
    public void adminSearchesForAllUsers(){
        String url = PropertyLoader.load("url") + "users";
        CRUD.httpGet(url);
    }

    @When("admin searches for user with id '(\\d+)'")
    @Loggable(message = "@When")
    public void adminSearchesForUserWithId(int userId){
        String url = PropertyLoader.load("url") + "users/" + userId;
        CRUD.httpGet(url);
    }

    @And("found user should have id '(\\d+)'")
    @Loggable(message = "@And")
    public void foundUserShouldHaveId(int idInResponse){
        VALIDATABLE_RESPONSE.get().body("id", equalTo(idInResponse));
    }

    @And("total users amount should be '(\\d+)'")
    @Loggable(message = "@And")
    public void totalUsersAmountShouldBe(int customersAmount){

        String responseAsString = RESPONSE.get().getBody().asString();
        User[] user1s = JacksonUtils.fromJson(responseAsString, User[].class);

        assertThat(customersAmount, is(user1s.length));
    }


}