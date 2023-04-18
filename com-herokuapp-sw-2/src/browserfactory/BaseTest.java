package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public void openBrowser(String baseUrl) {

        driver = new ChromeDriver();

        //Open the Url
        driver.get(baseUrl);

        //Maximize window
        driver.manage().window().maximize();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser() {
        //Close the browser
        driver.quit();
    }

}
