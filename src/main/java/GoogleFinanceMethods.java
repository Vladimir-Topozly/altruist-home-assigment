import java.util.List;

public interface GoogleFinanceMethods {

    List<String> getStockSymbolsList() throws Exception;

    String getPageTitle();
}
