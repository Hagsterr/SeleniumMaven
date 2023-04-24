package logIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class facebookLogin {
    // private static final Logger logger = Logger.getLogger(facebookLogin.class.getName());
    private static final Logger logger = LoggerFactory.getLogger(facebookLogin.class);


    public static void main(String[] args) {



            System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\testingGoogle\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            WebDriver driver = new ChromeDriver(options);
            Credentials log = new Credentials();



        // Get maximize Facebook.com
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();


        try {
            // Close cookies
            driver.findElement(By.cssSelector("button[data-cookiebanner=\"accept_btton\"]")).click();
        } catch (Exception e){
            logger.error("Error while closing cookies");
        }

        try {
            // Log into facebook using credentials found in separate JSON file on computer for security
            driver.findElement(By.id("email")).sendKeys(log.email);
            driver.findElement(By.id("pass")).sendKeys(log.password);
        } catch (Exception e){
            logger.error("Error while logging in");
        }

        // Find startpage as new accounts dont go there automatically
        try {
            driver.findElement(By.name("login")).click();
            driver.findElement(By.linkText("Startsida")).click();
        } catch (Exception e){
            logger.error("Cannot find starting page");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

}
