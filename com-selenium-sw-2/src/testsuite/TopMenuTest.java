package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    public String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {

        //Find Computers text element and click on computers text element
        WebElement computerPage = driver.findElement(By.xpath("(//a[contains(text()," +
                "'Computers ')])[1]"));
        computerPage.click();

        //Verify computers text element displayed or not
        String expectedText = "Computers";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Computers']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("The text does not match.", expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //Find Electronics text element and click on Electronics text element
        WebElement electronicsPage = driver.findElement(By.xpath("(//a[contains(text()," +
                "'Electronics ')])[1]"));
        electronicsPage.click();

        //Verify Electronics text element displayed or not
        String expectedText = "Electronics";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text()," +
                "'Electronics')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("The text does not match.", expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        //Find Apparel text element and click on Apparel text element
        WebElement apparelPage = driver.findElement(By.xpath("(//a[contains(text()," +
                "'Apparel ')])[1]"));
        apparelPage.click();

        //Verify Apparel text element displayed or not
        String expectedText = "Apparel";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Apparel')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("The text does not match.", expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //Find Digital downloads text element and click on Digital downloads text element
        WebElement digitalDownloadsPage = driver.findElement(By.xpath("(//a[contains(text()," +
                "'Digital downloads ')])[1]"));
        digitalDownloadsPage.click();

        //Verify Digital downloads text element displayed or not
        String expectedText = "Digital downloads";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text()," +
                "'Digital downloads')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("The text does not match.", expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        //Find Books text element and click on Books text element
        WebElement booksPage = driver.findElement(By.xpath("(//a[contains(text()," +
                "'Books ')])[1]"));
        booksPage.click();

        //Verify Books text element displayed or not
        String expectedText = "Books";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Books')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("The text does not match.", expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        //Find Jewelry text element and click on Jewelry text element
        WebElement jewelryPage = driver.findElement(By.xpath("(//a[contains(text()," +
                "'Jewelry ')])[1]"));
        jewelryPage.click();

        //Verify Jewelry text element displayed or not
        String expectedText = "Jewelry";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("The text does not match.", expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        //Find Gift Cards text element and click on Gift Cards text element
        WebElement gistCardPage = driver.findElement(By.xpath("(//a[contains(text()," +
                "'Gift Cards ')])[1]"));
        gistCardPage.click();

        //Verify Gift Cards text element displayed or not
        String expectedText = "Gift Cards";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text()," +
                "'Gift Cards')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("The text does not match.", expectedText, actualText);

    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
