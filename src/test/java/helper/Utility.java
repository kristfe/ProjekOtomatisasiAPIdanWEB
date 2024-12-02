package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class Utility {

    public static WebDriver driver;

    public static File getJSONSchemaFile(String JSONFile){
        return new File("src/test/java/helper/JSONSchemaData/"+JSONFile);
}

public static String generateRandomEmail(){
       String allowedChars ="abcdefghijklmnopqrstuvwxyz" + "1234567890"+"_-.";
        String email ="";
        String temp = RandomStringUtils.randomAlphabetic(10);// panjang email 10 karakter
    email = temp+"@testdata.com";
   return email;
}

public static void startDriver(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--remote-allow-origins=*");

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

}

public static void quitDriver(){
 //       driver.quit();
}

}
