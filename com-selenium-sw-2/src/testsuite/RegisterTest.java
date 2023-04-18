package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest {

    public String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //Find the register link and click on register link
        WebElement registerLink = driver.findElement(By.xpath("//a[text() = 'Register']"));
        registerLink.click();
        String expectedMessage = "Register";

        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()= 'Register']"));
        String actualMessage = actualTextElement.getText();

        Assert.assertEquals("Not Redirected to login page", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {

        //Find the register link and click on register link
        WebElement registerLink = driver.findElement(By.xpath("//a[text() = 'Register']"));
        registerLink.click();
        String expectedMessage = "Your registration completed";

        //Select Gender Radio Button
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-male']"));
        radioButton.click();

        //Find the firstname field and enter first name
        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'FirstName']"));
        firstName.sendKeys("Benjamin");

        //Find the lastname field and enter last name
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'LastName']"));
        lastName.sendKeys("Sanders");

        //Find the day, month and year field to select date of birth
        //Select Day
        Select day = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']")));
        day.selectByIndex(7);

        //Select month
        Select month = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']")));
        month.selectByIndex(7);

        //Select year
        Select year = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthYear']")));
        year.selectByValue("1997");

        //Find the email field and Enter email address
        WebElement emailField = driver.findElement(By.xpath("//input[@id = 'Email']"));
        emailField.sendKeys("ben13@gmail.com");

        //Find the password field and enter the password
        WebElement password = driver.findElement(By.xpath("//input[@name = 'Password']"));
        password.sendKeys("Asdf1234");

        //Find the Confirm Password field and enter the same password again
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id = 'ConfirmPassword']"));
        confirmPassword.sendKeys("Asdf1234");

        //Find the register button and click on register button
        WebElement register = driver.findElement(By.xpath("//button[@id ='register-button']"));
        register.click();

        //Find the "Your registration completed"
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class = 'result']"));
        String actualMessage = actualTextElement.getText();

        //Verify user is get registered
        Assert.assertEquals("Registration is not successful", expectedMessage, actualMessage);
    }

    @After
    //Close the browser
    public void tearDown() {
        closeBrowser();
    }
}
