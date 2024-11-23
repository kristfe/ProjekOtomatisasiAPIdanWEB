package pages;

import org.openqa.selenium.By;

import static helper.Utility.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class WebPage {
    By input_username = By.id("user-name");

    By input_pwd = By.id("password");

    By btn_login = By.id("login-button");

    By icon_cart = By.xpath("//a[@class='shopping_cart_link']");

    By icon_cart_item = By.xpath("//span[@class='shopping_cart_badge']");

    By text_err_msg(String msg){
        return By.xpath("//*[contains(text(),'"+msg+"')]");
    }

    By addToCart = By.xpath("(//*[text()=\"Add to cart\"])[1]");

    By removeToCart = By.xpath("(//*[text()=\"Remove\"])[1]");
    public void openBrowser() {
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUserName(String username) {
        driver.findElement(input_username).sendKeys(username);
    }

    public void userInputPassword(String pwd) {
        driver.findElement(input_pwd).sendKeys(pwd);

    }
    public void clickbtnLogin (){
        driver.findElement(btn_login).click();
    }

    public void assertHomePage(){
        driver.findElement(icon_cart).isDisplayed();
    }

    public void assertErrMsg(String errmesg){
        driver.findElement(text_err_msg(errmesg)).isDisplayed();

    }

    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }

    public void removeAddToCart(){
        driver.findElement(removeToCart).click();
    }

    public void assertCartItem(String cartItem){
       // driver.findElement(icon_cart_item).click();
        String itemExpected = cartItem;
        String itemActual = driver.findElement(icon_cart_item).getText();

        //System.out.println(driver.findElement(icon_cart_item).getText());
        assertThat(itemActual).isEqualTo(itemExpected);
    }

}
