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




        // Close cookies
        driver.findElement(By.cssSelector("button[data-cookiebanner=\"accept_button\"]")).click();

        // Log into facebook using credentials found in separate JSON file on computer for security
        driver.findElement(By.id("email")).sendKeys(log.email);
        driver.findElement(By.id("pass")).sendKeys(log.password);
        driver.findElement(By.name("login")).click();

        //Clicks on the searchbar

        WebElement searchButton = driver.findElement(By.cssSelector("input[aria-label='Search Facebook']"));
        searchButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Types in selenium and presses enter
        searchButton.sendKeys("Selenium" + Keys.ENTER);



    }
}