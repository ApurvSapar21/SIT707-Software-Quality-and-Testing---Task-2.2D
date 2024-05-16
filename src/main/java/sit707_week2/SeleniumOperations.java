package sit707_week2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.File;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        // Set GeckoDriver executable path
        System.setProperty("webdriver.gecko.driver", "D:\\firefoxdriver\\geckodriver.exe");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up FireFox browser.");
        WebDriver driver = new FirefoxDriver();

        System.out.println("Driver info: " + driver);

        // Load a webpage in chromium browser.
        driver.get(url);
       // System.out.println("Opened URL: " + url);

        try {
            // Find and fill the first name input field using relative locator (below)
            WebElement firstNameElement = driver.findElement(RelativeLocator.withTagName("input").above(By.id("lastname")));
            firstNameElement.sendKeys("Apurv");

            // Find and fill the last name input field using relative locator (below)
            WebElement lastNameElement = driver.findElement(RelativeLocator.withTagName("input").below(firstNameElement));
            lastNameElement.sendKeys("Sapar");

            // Find and fill the phone number input field using relative locator (below)
            WebElement phoneNumberElement = driver.findElement(RelativeLocator.withTagName("input").below(lastNameElement));
            phoneNumberElement.sendKeys("0123456789");

            // Find and fill the email input field using relative locator (below)
            WebElement emailElement = driver.findElement(RelativeLocator.withTagName("input").below(phoneNumberElement));
            emailElement.sendKeys("abz@gmail.com");

            // Find and fill the password input field using relative locator (below)
            WebElement passwordElement = driver.findElement(RelativeLocator.withTagName("input").below(emailElement));
            passwordElement.sendKeys("pass"); // Invalid password

            // Find the "Create account" button and click it
            WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(), 'Create account')]"));
            createAccountButton.click();
            System.out.println("Clicked on Create Account button.");

            String expectedTitle = "Officeworks Identity Application";
            String actualTitle = driver.getTitle();

            // Checkpoint
            if (expectedTitle.equals(actualTitle)) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed");
            }

            // Take screenshot using Selenium API
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("officeworks_registration_page_screenshot.png"));
            System.out.println("Screenshot captured and saved.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Sleep a while before closing the browser
            sleep(2);

            // Close chrome driver
            driver.quit();
            System.out.println("Browser closed.");
        }
    }

}
