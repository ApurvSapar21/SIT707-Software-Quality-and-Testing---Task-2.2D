package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void bunnings_login_page(String url) {
        // Set ChromeDriver executable path
        System.setProperty("webdriver.chrome.driver", 
        		"C:/chromedriver-win64/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Implicit wait for elements
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // Navigate to the Bunnings login page
            driver.get(url);

            // Locate email input and enter username
            WebElement usernameElement = driver.findElement(By.xpath("//*[@id='okta-signin-username']"));
            usernameElement.sendKeys("ahsan@xyz.com");

            // Locate password input and enter password
            WebElement passwordElement = driver.findElement(By.xpath("//*[@id='okta-signin-password']"));
            passwordElement.sendKeys("Ahsan_pass1");

            // Locate sign-in button and click
            WebElement signInButton = driver.findElement(By.xpath("//*[@id='okta-signin-submit']"));
            signInButton.click();

            // Sleep for a while to observe the result (not recommended for actual tests)
            sleep(5);

            // Get the current URL after sign-in
            String currentUrl = driver.getCurrentUrl();

            // Check if login was successful based on URL
            if (currentUrl.contains("dashboard")) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
