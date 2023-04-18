package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //Find the Sign-In link and click on it
        WebElement loginButton = driver.findElement(By.xpath("//li[@class = " +
                "'header__nav-item header__nav-sign-in']"));
        loginButton.click();

        //Find the 'Welcome Back!' text element and verify 'Welcome Back!' text
        String expectedTextDisplay = "Welcome Back!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class = 'page__heading']"));
        String actualTextDisplay = actualTextElement.getText();
        Assert.assertEquals("'Welcome Back!' test is displayed", expectedTextDisplay, actualTextDisplay);


    }

    @Test
    public void verifyTheErrorMessage() {

        //Find the Sign-In link and click on it
        WebElement loginButton = driver.findElement(By.xpath("//li[@class = " +
                "'header__nav-item header__nav-sign-in']"));
        loginButton.click();

        //Find Email field element and enter Email
        WebElement emailField = driver.findElement(By.xpath("//input[@id = 'user[email]']"));
        emailField.sendKeys("abc123@gmail.com");

        //Find password field element and enter password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id = 'user[password]']"));
        passwordField.sendKeys("Rxyz1234");

        //Find 'Sign-in' text element  and click on 'Sign-in' text
        WebElement signInField = driver.findElement(By.xpath("//button[@type = 'submit']"));
        signInField.click();

        //Find 'Invalid email or password.' text element and Verify displayed text
        String expectedTextDisplay = "Invalid email or password.";
        WebElement actualTextElement = driver.findElement(By.xpath("//li[contains(text(), " +
                "'Invalid email or password')]"));

        String actualTextDisplay = actualTextElement.getText();
        Assert.assertEquals("'Invalid email or password.' test is displayed", expectedTextDisplay, actualTextDisplay);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
