package steps;

import cucumber.api.java.en.When;
import framework.annotations.Loggable;
import tools.CRUD;

public class DeleteUser {

    @When("admin deletes user with id '(.+)'")
    @Loggable(message = "@When")
    public void adminDeletesUserWithId(String id){

        CRUD.httpDelete(id);
    }

}
