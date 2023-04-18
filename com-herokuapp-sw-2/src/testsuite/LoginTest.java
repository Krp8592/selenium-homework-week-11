package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Find Username field element and enter username
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'username']"));
        userName.sendKeys("tomsmith");

        //Find password field element and enter password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
        password.sendKeys("SuperSecretPassword!");

        //Find Login button element and click on login
        WebElement loginButton = driver.findElement(By.xpath("//i[text() = ' Login']"));
        loginButton.click();

        //Find 'Secure area' text element and Verify the displayed text
        String expectedText = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[text() = ' Secure Area']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Secure area message not displayed", expectedText, actualText);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        //Find Username field element and enter username
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'username']"));
        userName.sendKeys("tomsmith1");

        //Find password field element and enter password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
        password.sendKeys("SuperSecretPassword!");

        //Find Login button element and click on login
        WebElement loginButton = driver.findElement(By.xpath("//i[text() = ' Login']"));
        loginButton.click();

        //Find username error text field and get the error message
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class = 'flash error']"));
        String errorMessage = actualTextElement.getText();
        String [] arrString = errorMessage.split("×");
        String actualStringText = arrString[0];


        //Find 'Your username is invalid!' text element and verify the text
        String expectText = "Your username is invalid!\n";
        Assert.assertEquals("'Your username is invalid!' message not displayed", expectText, actualStringText);

    }

    @Test
    public void verifyThePasswordErrorMessage() {

        //Find Username field element and enter username
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'username']"));
        userName.sendKeys("tomsmith");

        //Find password field element and enter password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
        password.sendKeys("SuperSecretPassword");

        //Find Login button element and click on login
        WebElement loginButton = driver.findElement(By.xpath("//i[text() = ' Login']"));
        loginButton.click();

        //Find username error text field and get the error message
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class = 'flash error']"));
        String errorMessage = actualTextElement.getText();
        String [] arrString = errorMessage.split("×");
        String actualStringText = arrString[0];

        //Find 'Your password is invalid!' text element and verify the text
        String expectText = "Your password is invalid!\n";
        Assert.assertEquals("'Your username is invalid!' message not displayed", expectText, actualStringText);



    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
