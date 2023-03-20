package pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.PageBase;

import java.util.List;

public class CatalogSectionPage extends PageBase {

    public CatalogSectionPage(WebDriver driver) {
        super(driver);
    }
    private static final String website = "https://catalog.onliner.by/";

    private final By categoriesLocator = By.cssSelector(".catalog-navigation>ul>li:nth-child(3), .catalog-navigation>ul>li:nth-child(4), .catalog-navigation>ul>li:nth-child(5), .catalog-navigation>ul>li:nth-child(7), .catalog-navigation>ul>li:nth-child(9), .catalog-navigation>ul>li:nth-child(10), .catalog-navigation>ul>li:nth-child(11)");

    public void open() {
        driver.get(website);
    }

    public boolean ifDisplayedCategories() {
        boolean isDisplayed = false;
        List<WebElement> categories = driver.findElements(categoriesLocator);
        for (WebElement category : categories) {
            if (category.isDisplayed()){
                System.out.println("Section is showing on page: " + category.getText());
                isDisplayed = true;
            } else {
                System.out.println("Section not showing on page: " + category.getText());
            }
        }
        return isDisplayed;
    }


}
