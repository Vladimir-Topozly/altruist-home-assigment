import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

public class GoogleFinanceTests {
    private WebDriver driver;
    String baseUrl = "https://www.google.com/finance";
    private GoogleFinancePage googleFinancePage;

    private List<String> expectedStockSymbols = Arrays.asList("NFLX", "MSFT", "TSLA");

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        googleFinancePage = new GoogleFinancePage(driver);
    }

    @Test(priority = 1)
    public void openGoogleFinancePage() {
        // 1. Opens a webpage www.google.com/finance on a chrome browser
        driver.get(baseUrl);

        // 2. Verifies the page is loaded by asserting the page title
        Assert.assertEquals(googleFinancePage.getPageTitle(), "Google Finance");
    }

    @Test(priority = 3)
    public void compareStockSymbols() throws Exception { // Comparing stock symbols by asserting two lists
        Assert.assertEquals(expectedStockSymbols.toString(), googleFinancePage.getStockSymbolsList(driver).toString());
    }

    // In the below part implemented 3, 4, 5 and 6 steps of the assignment
    @Test(priority = 4)
    public void printAllStocksThatAreInActualButNotInExpected() throws Exception {
        Utilities.printListElements("Stock symbols in (3) but not in expectedStockSymbols: ",
                Utilities.compareLists(googleFinancePage.getStockSymbolsList(driver), expectedStockSymbols)); //
    }

    @Test(priority = 5)
    public void printAllStocksThatAreInExpectedButNotInActual() throws Exception {
        Utilities.printListElements("Stock symbols in expectedStockSymbols but not in (3): ",
                Utilities.compareLists(expectedStockSymbols, googleFinancePage.getStockSymbolsList(driver)));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
