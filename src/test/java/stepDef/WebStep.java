package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.WebPage;

public class WebStep {

    WebPage webPage;

    public WebStep(){
        this.webPage = new WebPage();
    }

    @Given("open web login page")
    public void openWebLoginPage() {
    webPage.openBrowser();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        webPage.inputUserName(username);
    }

    @And("user input password {string}")
   public void userInputPassword(String pwd) {
      webPage.userInputPassword(pwd);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        webPage.clickbtnLogin();
    }

    @And("user will see icon from cart in homepage")
    public void userWillSeeIconFromCartInHomepage() {
        webPage.assertHomePage();
    }

    @And("user will see error message {string}")
    public void userWillSeeErrorMessage(String errmesg) {
        webPage.assertErrMsg(errmesg);
    }

    @And("user add item to cart")
    public void userAddItemToCart() {
        webPage.clickAddToCart();
    }

    @Then("verify cart is match {string}")
    public void verifyCartIsMatch(String cartItem) {
        webPage.assertCartItem( cartItem );
    }

    @And("user remove item to cart")
    public void userRemoveItemToCart() {
        webPage.removeAddToCart();
    }
}
