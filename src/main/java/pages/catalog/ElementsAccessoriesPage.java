package pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.PageBase;

import java.util.List;

public class ElementsAccessoriesPage extends PageBase {
    public ElementsAccessoriesPage(WebDriver driver) {
        super(driver);
    }

    private static final String website = "https://onliner.by/";
    private final By catalog = By.className("b-main-navigation__text");
    private final By computerAndNetworks = By.cssSelector(".catalog-navigation>ul>li:nth-child(4)");
    private final By accessories = By.xpath("//div[@class='catalog-navigation-list__aside-title'] [contains(text(),'Комплектующие')]");
    private final By categories = By.xpath("//div[@class='catalog-navigation-list__aside-title' and text()='Комплектующие']/following-sibling::div[@class='catalog-navigation-list__dropdown']");
    private final By titles = By.cssSelector(".catalog-navigation-list__dropdown-title");
    private final By descriptions = By.cssSelector(".catalog-navigation-list__dropdown-description");

    public void open() {
        driver.get(website);
        driver.findElement(catalog).click();
        driver.findElement(computerAndNetworks).click();
        driver.findElement(accessories).click();
    }
    public void scrollPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
    }

    public List<WebElement> getCategories() {
        List<WebElement> list = driver.findElements(categories);

        return list;
    }
    public By getTitles() {
        driver.findElement(titles);
        return titles;
    }
    public By getDescriptions() {
        driver.findElement(descriptions);
        return descriptions;
    }

}

