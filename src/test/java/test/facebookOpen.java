package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class facebookOpen {

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
        driver.findElement(By.linkText("Startsida")).click();





    }
}
