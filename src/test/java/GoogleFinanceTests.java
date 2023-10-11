import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

public class GoogleFinanceTests extends TestBase {
    private String baseUrl = "https://www.google.com/finance";
    private GoogleFinancePage googleFinancePage;

    private List<String> expectedStockSymbols = Arrays.asList("NFLX", "MSFT", "TSLA");


    @BeforeClass
    public void start() {
        googleFinancePage = new GoogleFinancePage(driver);
    }

    @Test(priority = 1)
    public void openGoogleFinancePage() {
        // 1. Opens a web page www.google.com/finance on a chrome browser
        openURL(baseUrl);


        // 2. Verifies the page is loaded by asserting the page title
        Assert.assertEquals(googleFinancePage.getPageTitle(), "Google Finance");
    }

    @Test(priority = 3)
    public void compareStockSymbols() throws Exception { // Comparing stock symbols by asserting two lists
        Assert.assertEquals(googleFinancePage.getStockSymbolsList().toString(), expectedStockSymbols.toString());
    }

    // In the below part implemented 3, 4, 5 and 6 steps of the assignment
    @Test(priority = 4)
    public void printAllStocksThatAreInActualButNotInExpected() throws Exception {
        Utilities.printListElements("Stock symbols in (3) but not in expectedStockSymbols: ",
                Utilities.compareLists(googleFinancePage.getStockSymbolsList(), expectedStockSymbols)); //
    }

    @Test(priority = 5)
    public void printAllStocksThatAreInExpectedButNotInActual() throws Exception {
        Utilities.printListElements("Stock symbols in expectedStockSymbols but not in (3): ",
                Utilities.compareLists(expectedStockSymbols, googleFinancePage.getStockSymbolsList()));
    }
}
