package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import dataModels.User;
import framework.annotations.Loggable;
import tools.CRUD;
import tools.JacksonUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static sharedData.Constants.*;

public class CreateUser {

    @When("admin tries to create new user")
    @Loggable(message = "@When")
    public void adminTriesToCreateNewUser() {

        CRUD.httpPost(EXPECTED_USER.get());
    }

    @And("if created, new user should have all expected data")
    @Loggable(message = "@And")
    public void ifCreatedNewUserShouldHaveAllExpectedData() {

        User actualUser = JacksonUtils.fromJson(RESPONSE.get().getBody().asString(), User.class);

        if (RESPONSE.get().statusCode() == 201) {
            EXPECTED_USER.get().setId(actualUser.getId());

            assertThat(actualUser, equalTo(EXPECTED_USER.get()));
        }
    }

}