package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import dataModels.Address;
import dataModels.Company;
import dataModels.Geo;
import dataModels.User;
import framework.annotations.Loggable;
import lombok.extern.log4j.Log4j;
import tools.CRUD;
import tools.JacksonUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static sharedData.Constants.*;

@Log4j
public class CreateCustomer {

    private User expectedUser;

    @And("^new user with name '(.+)', username '(.+)'$")
    public void adminCreatesNewUserWithNameUsername(String name, String username) {
        expectedUser = User.builder()
                .name(name)
                .username(username)
                .build();
    }

    @And("^contacts: phone '(.+)', website '(.+)', email '(.+)'$")
    public void contactsPhoneWebsiteEmail(String phone, String website, String email) {
        expectedUser.setPhone(phone);
        expectedUser.setWebsite(website);
        expectedUser.setEmail(email);
    }

    @And("^company: name '(.+)', catch phrase '(.+)', bs '(.+)'$")
    public void companyNameCatchPhraseBs(String name, String catchPhrase, String bs) {
        Company company = Company.builder()
                .name(name)
                .catchPhrase(catchPhrase)
                .bs(bs)
                .build();

        expectedUser.setCompany(company);
    }

    @And("^address: street '(.+)', suite '(.+)', city '(.+)', zipcode '(.+)', lat '(.+)', lng '(.+)'$")
    public void addressStreetSuiteCityZipcodeLatLng(String street, String suite, String city, String zipcode, String lat, String lng) {
        Geo geo = Geo.builder()
                .lat(lat)
                .lng(lng)
                .build();

        Address address = Address.builder()
                .street(street)
                .suite(suite)
                .city(city)
                .zipcode(zipcode)
                .geo(geo)
                .build();

        expectedUser.setAddress(address);
    }

    @When("^admin tries to create new user$")
    @Loggable(message = "@When")
    public void adminTriesToCreateNewUser() {
        CRUD.httpPost(expectedUser);
    }

    @And("^if created new user should have all expected data$")
    @Loggable(message = "@And")
    public void ifCreatedNewUserShouldHaveAllExpectedData() {

        User actualUser = JacksonUtils.fromJson(RESPONSE.get().getBody().asString(), User.class);

        if (RESPONSE.get().statusCode() == 201) {
            expectedUser.setId(actualUser.getId());

            assertThat(actualUser, equalTo(expectedUser));
        }
    }

}