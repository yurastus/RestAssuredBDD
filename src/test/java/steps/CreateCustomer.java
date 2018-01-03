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
import tools.PropertyLoader;
import static org.hamcrest.Matchers.equalTo;
import static sharedData.Constants.VALIDATABLE_RESPONSE;

@Log4j
public class CreateCustomer {

    private User user;

    @And("^new user with name '(.+)', username '(.+)'$")
    public void adminCreatesNewUserWithNameUsername(String name, String username) {
        user = User.builder().name(name).username(username).build();
    }

    @And("^contacts: phone '(.+)', website '(.+)', email '(.+)'$")
    public void contactsPhoneWebsiteEmail(String phone, String website, String email) {
        user.setPhone(phone);
        user.setWebsite(website);
        user.setEmail(email);
    }

    @And("^company: name '(.+)', catch phrase '(.+)', bs '(.+)'$")
    public void companyNameCatchPhraseBs(String name, String catchPhrase, String bs) {
        Company company = Company.builder().name(name).catchPhrase(catchPhrase).bs(bs).build();
        user.setCompany(company);
    }

    @And("^address: street '(.+)', suite '(.+)', city '(.+)', zipcode '(.+)', lat '(.+)', lng '(.+)'$")
    public void addressStreetSuiteCityZipcodeLatLng(String street, String suite, String city, String zipcode, String lat, String lng) {
        Geo geo = Geo.builder().lat(lat).lng(lng).build();
        Address address = Address.builder().street(street).suite(suite).city(city).zipcode(zipcode).geo(geo).build();
        user.setAddress(address);
    }

    @When("^admin created new user$")
    @Loggable(message = "@When")
    public void adminCreatesNewUser() {
        String url = PropertyLoader.load("url") + "users";
        CRUD.httpPost(url, user);
    }

    @And("^new user should have name '(.+)', username '(.+)'$")
    public void newUserShouldHaveNameUsername(String name, String username) {
        VALIDATABLE_RESPONSE.get().body("name", equalTo(name));
    }


    @And("^should have contacts: phone '(.+)', website '(.+)', email '(.+)'$")
    public void shouldHaveContactsPhoneWebsiteEmail(String phone, String website, String email) {
        VALIDATABLE_RESPONSE.get().body("phone", equalTo(phone));
    }

    @And("^should have company: name '(.+)', catch phrase '(.+)', bs '(.+)'$")
    public void shouldHaveCompanyNameCatchPhraseBs(String name, String catchPhrase, String bs) {
        VALIDATABLE_RESPONSE.get().body("name", equalTo(name));
    }

    @And("^should have address: street '(.+)', suite '(.+)', city '(.+)', zipcode '(.+)', lat '(.+)', lng '(.+)'$")
    public void shouldHaveAddressStreetSuiteCityZipcodeLatLng(String street, String suite, String city, String zipcode, String lat, String lng) {
        VALIDATABLE_RESPONSE.get().body("street", equalTo(street));
    }

}