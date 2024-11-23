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
        apiPages.validationStatusCodeIsEqual(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPages.validationResponseBodyGetListUsers();
    }

   @Then("validation response json with JSONScema {string}")
  public void validationResponseJsonWithJSONScema(String filename) {
        apiPages.validationResponseJsonWithJSONScema(filename);
    }

   @And("hit api post create new user")
   public void hitApiPostCreateNewUser() {
       apiPages.hitApiPostCreateNewUser();
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        apiPages.validationResponseBodyCreateUser();
    }

    @And("hit api delete new")
    public void hitApiDeleteNew() {
        apiPages.hitApiDeleteUser();
    }

    @And("hit api update data")
    public void hitApiUpdateData() {
        apiPages.hitUpdateUser();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPages.validationResponseUpdateUser();
    }

    @And("hit api post create new user invalid")
    public void hitApiPostCreateNewUserInvalid() {
        apiPages.hitApiPostCreateNewWrongUser();
    }

    @And("hit api update wrong data")
    public void hitApiUpdateWrongData() {
        apiPages.hitWrongUpdateUser();
    }
}
