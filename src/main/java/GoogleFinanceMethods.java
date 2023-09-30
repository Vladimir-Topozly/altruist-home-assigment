import org.openqa.selenium.WebDriver;

import java.util.List;

public interface GoogleFinanceMethods {

    List<String> getStockSymbolsList(WebDriver driver) throws Exception;

    String getPageTitle();
}
