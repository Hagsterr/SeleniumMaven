package post;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class facebookPost {

private static final Logger logger = LoggerFactory.getLogger(facebookPost.class);



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


        WebElement postBar = driver.findElement(By.cssSelector("#mount_0_0_Wq > div > div:nth-child(1) > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div > div.x78zum5.xdt5ytf.x10cihs4.x1t2pt76.x1n2onr6.x1ja2u2z > div.x9f619.x1n2onr6.x1ja2u2z.x78zum5.x2lah0s.xl56j7k.x1qjc9v5.xozqiw3.x1q0g3np.x1t2pt76.x17upfok > div > div.x9f619.x1n2onr6.x1ja2u2z.x78zum5.x1iyjqo2.xs83m0k.xeuugli.xl56j7k.x1qjc9v5.xozqiw3.x1q0g3np.x1iplk16.x1xfsgkm.xqmdsaz.x1mtsufr.x1w9j1nh > div > div > div > div.x78zum5.x1q0g3np.xl56j7k > div > div.x1yztbdb > div > div > div > div.x1cy8zhl.x78zum5.x1iyjqo2.xs83m0k.xh8yej3 > div"));


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            postBar.sendKeys("Idag äter vi Sill och Potatis!" + Keys.ENTER);
        } catch (Exception e){
            logger.error("Cannot post");
        }





    }
}
