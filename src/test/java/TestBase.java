import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    WebDriver driver;


    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    void openURL(String url) {
        driver.get(url);
    }


    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
