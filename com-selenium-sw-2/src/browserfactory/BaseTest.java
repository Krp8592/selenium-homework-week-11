package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {

        driver = new ChromeDriver();

        //Open the URL
        driver.get(baseUrl);

        //Maximize Window
        driver.manage().window().maximize();

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        //Close the browser
        driver.quit();
    }
}
