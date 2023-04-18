package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find the login link and click on login link
        WebElement loginLink = driver.findElement(By.xpath("//a[text() = 'Log in']"));
        loginLink.click();
        String expectedMessage = "Welcome, Please Sign In!";

        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text() = 'Welcome, Please Sign In!']"));
        String actualMessage = actualTextElement.getText();

        Assert.assertEquals("Not Redirected to login page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredential() {
        //Find login link and click on login link
        WebElement loginLink = driver.findElement(By.xpath("//a[text() = 'Log in']"));
        loginLink.click();

        //Find the Email field element and enter the email address
        WebElement emailField = driver.findElement(By.xpath("//input[@id = 'Email']"));
        emailField.sendKeys("ben123@gmail.com");

        //Find the password field and enter the password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id = 'Password']"));
        passwordField.sendKeys("Asdf1234");

        //Find the Login button and clock on it
        WebElement loginButton = driver.findElement(By.xpath("//button[text() = 'Log in']"));
        loginButton.click();

        //Find the Log-out element and verify
        String expectedTextDisplay = "Log out";
        WebElement actualTextElement = driver.findElement(By.xpath("//a[@class = 'ico-logout']"));
        String actualTextDisplay = actualTextElement.getText();
        Assert.assertEquals("Log out test is displayed", expectedTextDisplay, actualTextDisplay);


    }

    @Test
    public void verifyTheErrorMessage() {
        //Find login link and click on login link
        WebElement loginLink = driver.findElement(By.xpath("//a[text() = 'Log in']"));
        loginLink.click();

        //Find the Email field element and enter the email address
        WebElement emailField = driver.findElement(By.xpath("//input[@id = 'Email']"));
        emailField.sendKeys("ben1@gmail.com");

        //Find the password field and enter the password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id = 'Password']"));
        passwordField.sendKeys("Asd1234");

        //Find the Login button and clock on it
        WebElement loginButton = driver.findElement(By.xpath("//button[text() = 'Log in']"));
        loginButton.click();

        //Verify Message displayed when entered email and password are incorrect
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement actualErrorMessageElement = driver.findElement(By.xpath("//div[@class = 'message-error " +
                "validation-summary-errors']"));
        String actualErrorMessage = actualErrorMessageElement.getText();

        Assert.assertEquals("The error message is not displayed", expectedErrorMessage,actualErrorMessage);
    }

    @After
    //Close the browser
    public void tearDown() {
        closeBrowser();
    }
}
