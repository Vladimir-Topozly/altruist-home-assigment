import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

class Utilities {
    /**
     * Returns HTML list as List of WebElements
     *
     * @param parentElement WebElement of the HTML list container
     */
    static List<WebElement> getHTMLListRows(WebElement parentElement) throws Exception {
        try {
            return parentElement.findElements(By.cssSelector("ul > li"));
        } catch (Exception e) {
            throw new Exception("[ERROR] Couldn't get table rows: " + e);
        }
    }

    /**
     * Compares two Lists of String finding missing elements and returning them as a List of Strings
     *
     * @param list1 List to compare
     * @param list2 list to compare
     */
    static List<String> compareLists(List<String> list1, List<String> list2) {
        List<String> missingSymbols = new ArrayList<String>(list1);
        missingSymbols.removeAll(list2);
        return missingSymbols;
    }

    /**
     * Print list items with preceding descriptive message
     *
     * @param message  List description message
     * @param elements list elements to be printed
     */
    static void printListElements(String message, List<String> elements) {
        System.out.println(message);
        for (String symbol : elements) {
            System.out.println(symbol + "\n");
        }
    }
}
