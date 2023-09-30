import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GoogleFinancePage implements GoogleFinanceMethods {

    private WebDriver driver;

    GoogleFinancePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By stocksListContainerLocator = By.cssSelector("[aria-labelledby='smart-watchlist-title']");
    private final By stockSymbolLocator = By.cssSelector("a > div > div > div > div > div > .COaKTb");


    @Override
    public String getPageTitle() {
        return driver.getTitle().split(" -")[0]; // Split to get the actual visible title text only
    }

    @Override
    public List<String> getStockSymbolsList(WebDriver driver) throws Exception {
        ArrayList<String> stockSymbols = new ArrayList<String>();

        List<WebElement> stockElements =
                Utilities.getHTMLListRows(driver.findElement(stocksListContainerLocator));

        for (WebElement element : stockElements) {

            stockSymbols.add(element.findElement(stockSymbolLocator).getText());
        }
        return stockSymbols;
    }
}
