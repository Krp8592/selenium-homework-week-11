package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Find the Username Field  element and enter the username
        WebElement userNameField = driver.findElement(By.xpath("//input[@id = 'user-name']"));
        userNameField.sendKeys("standard_user");

        //Find the password field and enter the password
        WebElement passwordField = driver.findElement(By.xpath("//input [@id = 'password']"));
        passwordField.sendKeys("secret_sauce");

        //Find the Login button and clock on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@id = 'login-button']"));
        loginButton.click();

        //Find the 'Products' text element and verify 'Product' text
        String expectedTextDisplay = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[text() = 'Products']"));
        String actualTextDisplay = actualTextElement.getText();
        Assert.assertEquals("'Products' test is displayed", expectedTextDisplay, actualTextDisplay);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //Find the Username Field  element and enter the username
        WebElement userNameField = driver.findElement(By.xpath("//input[@id = 'user-name']"));
        userNameField.sendKeys("standard_user");

        //Find the password field and enter the password
        WebElement passwordField = driver.findElement(By.xpath("//input [@id = 'password']"));
        passwordField.sendKeys("secret_sauce");

        //Find the Login button and clock on it
        WebElement loginButton = driver.findElement(By.xpath("//input[@id = 'login-button']"));
        loginButton.click();

        //Find Six products elements and verify if they are displayed or not on the screen
        int expectedProductsCount = 6;

        //Find Six web elements of products
        List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        int actualProductsCount = products.size();

        Assert.assertEquals("6 Products are not displayed",expectedProductsCount,actualProductsCount);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
