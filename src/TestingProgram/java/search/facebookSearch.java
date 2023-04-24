package search;

import logIn.facebookLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class facebookSearch {

    private static final Logger logger = LoggerFactory.getLogger(facebookSearch.class);


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\testingGoogle\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        Credentials log = new Credentials();


        // Get maximize Facebook.com
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();



        //close cookies
        try {
            driver.findElement(By.cssSelector("button[data-cookiebanner=\"accept_button\"]")).click();
        } catch (Exception e) {
            logger.error("Error occurred while accepting cookies: " + e.getMessage());
        }

        // Log into facebook using credentials found in separate JSON file on computer for security
        try {
            driver.findElement(By.id("email")).sendKeys(log.email);
            driver.findElement(By.id("pass")).sendKeys(log.password);
            driver.findElement(By.name("login")).click();
        } catch (Exception e) {
            logger.error("Error occurred while logging into Facebook: " + e.getMessage());
        }


        //Clicks on the searchbar
        try {
            WebElement searchButton = driver.findElement(By.cssSelector("input[aria-label='Search Facebook']"));
            searchButton.click();
            Thread.sleep(2000);
            searchButton.sendKeys("Selenium" + Keys.ENTER);
        } catch (Exception e) {
            logger.error("Error occurred while searching on Facebook: " + e.getMessage());
        }




    }
}