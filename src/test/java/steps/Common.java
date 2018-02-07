package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataModels.Address;
import dataModels.Company;
import dataModels.Geo;
import dataModels.User;
import logging.annotations.Loggable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import tools.PropertyLoader;
import static io.restassured.RestAssured.given;
import static sharedData.Constants.*;
import static tools.RandomGenerator.generateIfRandom;

@Slf4j
public class Common {

    private User expectedUser;

    @Given("admin '(.+)' is logged in")
    @Loggable(message = "@Given")
    public void adminIsLoggedIn(String admin){

        RestAssured.baseURI = PropertyLoader.load("url") + "users";
        REQUEST_SPECIFICATION.set(given().accept(ContentType.JSON).contentType(ContentType.JSON));
    }


    @And("user with name '(.+)', username '(.+)'")
    public void userWithNameAndUsername(String name, String username) {

        expectedUser = User.builder()
                .name(generateIfRandom(name))
                .username(generateIfRandom(username))
                .build();
    }

    @And("contacts: phone '(.+)', website '(.+)', email '(.+)'")
    public void contactsPhoneWebsiteEmail(String phone, String website, String email) {

        expectedUser.setPhone(generateIfRandom(phone));
        expectedUser.setWebsite(generateIfRandom(website));
        expectedUser.setEmail(generateIfRandom(email));
    }

    @And("company: name '(.+)', catch phrase '(.+)', bs '(.+)'")
    public void companyNameCatchPhraseBs(String name, String catchPhrase, String bs) {

        Company company = Company.builder()
                .name(generateIfRandom(name))
                .catchPhrase(generateIfRandom(catchPhrase))
                .bs(generateIfRandom(bs))
                .build();

        expectedUser.setCompany(company);
    }

    @And("address: street '(.+)', suite '(.+)', city '(.+)', zipcode '(.+)', lat '(.+)', lng '(.+)'")
    public void addressStreetSuiteCityZipcodeLatLng(String street, String suite, String city, String zipcode, String lat, String lng) {

        Geo geo = Geo.builder()
                .lat(generateIfRandom(lat))
                .lng(generateIfRandom(lng))
                .build();

        Address address = Address.builder()
                .street(generateIfRandom(street))
                .suite(generateIfRandom(suite))
                .city(generateIfRandom(city))
                .zipcode(generateIfRandom(zipcode))
                .geo(geo)
                .build();

        expectedUser.setAddress(address);
        EXPECTED_USER.set(expectedUser);
    }


    @Then("response status should be '(\\d+)'")
    @Loggable(message = "@Then")
    public void responseStatusShouldBe(int statusCode){

        VALIDATABLE_RESPONSE.set(RESPONSE.get().then().statusCode(statusCode));
    }

}