package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import dataModels.User;
import framework.annotations.Loggable;
import tools.CRUD;
import tools.JacksonUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static sharedData.Constants.EXPECTED_USER;
import static sharedData.Constants.RESPONSE;

public class UpdateUser {

    @When("admin tries to update user with id '(.+)'")
    @Loggable(message = "@When")
    public void adminTriesToCreateNewUser(String userId) {

        CRUD.httpPut(userId, EXPECTED_USER.get());
    }

    @And("if updated, user should have all expected data")
    @Loggable(message = "@And")
    public void ifUpdatedUserShouldHaveAllExpectedData() {

        User actualUser = JacksonUtils.fromJson(RESPONSE.get().getBody().asString(), User.class);

        if (RESPONSE.get().statusCode() == 200) {
            EXPECTED_USER.get().setId(actualUser.getId());

            assertThat(actualUser, equalTo(EXPECTED_USER.get()));
        }
    }

}
