package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPages;


public class ApiStep {

    ApiPages apiPages;


    public ApiStep() {
        this.apiPages = new ApiPages();
    }

    //  @Given("prepare url valid for get list data")
    //   public void prepareUrlValidForGetListData() {
    //      System.out.println("hello step");
    //      apiPages.prepareURL();
    //  }

    @Given("prepare url valid for {string}")
    public void prepareUrlValidFor(String url) {
        // System.out.println("Step 1");
        apiPages.prepareUrlValidFor(url);
    }

    @And("hit api get list users")
    public void hitApiGetListUsers() {
        // System.out.println("Step 2");
        apiPages.hitApiGetListUsers();
    }

    @Then("validation status code is equal {int}")
    public void validationStatusCodeIsEqual(int status_code) {
        //System.out.println("Step 3");
        apiPages.validationStatusCodeIsEqual(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        //  System.out.println("Step 4");
        apiPages.validationResponseBodyGetListUsers();
    }

   @Then("validation response json with JSONScema {string}")
    public void validationResponseJsonWithJSONScema(String filename) {
        // System.out.println("Step 5");
        apiPages.validationResponseJsonWithJSONScema(filename);
    }

  //  @And("hit api post create new user")
 //   public void hitApiPostCreateNewUser() {
 //   apiPages.hitApiPostCreateNewUser();

    //}
}
