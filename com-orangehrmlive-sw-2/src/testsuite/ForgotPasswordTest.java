package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){

        //Find 'Forgot your password' element and click on it
        WebElement forgotPassword = driver.findElement(By.xpath("//p[text() = 'Forgot your password? ']"));
        forgotPassword.click();

        //Find the 'Reset password' text element and verify 'Reset password' text
        String expectedText = "Reset Password";
        WebElement resetPassButtonText = driver.findElement(By.xpath("//h6[text() = 'Reset Password']"));
        String actualResetPassButtonText = resetPassButtonText.getText();
        Assert.assertEquals("Reset Password is not displayed", expectedText,actualResetPassButtonText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
