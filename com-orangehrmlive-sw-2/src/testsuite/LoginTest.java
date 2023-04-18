package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Find Username field and input username
        WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
        username.sendKeys("Admin");

        //Find password field and enter password
        WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
        password.sendKeys("admin123");

        //Find the Login button and click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();

        //Find the Dashboard text element and verify dashboard text
        String expectedText = "Dashboard";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text() = 'Dashboard']"));
        String actualText = actualTextElement.getText();

        //Verify test element
        Assert.assertEquals("Dashboard text element is not displayed", expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
