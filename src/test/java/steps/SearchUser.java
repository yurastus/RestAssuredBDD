package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import dataModels.User;
import framework.annotations.Loggable;
import lombok.extern.slf4j.Slf4j;
import tools.CRUD;
import tools.JacksonUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static sharedData.Constants.*;

@Slf4j
public class SearchUser {

    @When("admin searches for all users")
    @Loggable(message = "@When")
    public void adminSearchesForAllUsers(){

        CRUD.httpGet();
    }

    @When("admin searches for user with id '(\\d+)'")
    @Loggable(message = "@When")
    public void adminSearchesForUserWithId(int userId){

        CRUD.httpGet(userId);
    }

    @And("found user should have id '(\\d+)'")
    @Loggable(message = "@And")
    public void foundUserShouldHaveId(int idInResponse){

        if (RESPONSE.get().statusCode() == 201)
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