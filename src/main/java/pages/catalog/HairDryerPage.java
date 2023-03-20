package pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.PageBase;
import java.util.List;

public class HairDryerPage extends PageBase {

    public HairDryerPage(WebDriver driver) {
        super(driver);
    }

    private static final String website = "https://onliner.by/";
    private final By hairDryer = By.xpath("//span[text()='Фены']");
    private final By babylissCheckbox = By.xpath("//input[@value='babyliss']/following-sibling::span");
    private final By babyliss = By.xpath("//input[@value='babyliss']");
    private final By rowentaCheckbox = By.xpath("//input[@value='rowenta']/following-sibling::span");
    private final By philipsCheckbox = By.xpath("//input[@value='philips']/following-sibling::span");
    private final By babylissProCheckbox = By.xpath("//input[@value='babylisspro']/following-sibling::span");
    private final By productsContainer = By.xpath("//div[contains(@class, 'js-schema-results schema-grid__center-column')]");


    public void open() {
        driver.get(website);
        driver.findElement(hairDryer).click();
    }
    public void scrollPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400)");
    }

    public HairDryerPage chooseOneHairDryer() {
        driver.findElement(babylissCheckbox).click();
        return this;
    }

    public boolean ifSelectedOneHairDryer() {
        if (driver.findElement(babyliss).isSelected()) {
            System.out.println("Still selected");
            return true;
        }else {
            System.out.println("Not selected");
            return false;
        }
    }

    public boolean isProductsDisplayed() {
        List<WebElement> products = driver.findElements(productsContainer);
        if (products.size() > 0 && products.get(0).isDisplayed()) {
            System.out.println("At least one product is displayed");
            return true;
        } else {
            System.out.println("No products are displayed");
            return false;
        }
    }

    public HairDryerPage chooseHairDryers(){
        driver.findElement(rowentaCheckbox).click();
        driver.findElement(philipsCheckbox).click();
        driver.findElement(babylissProCheckbox).click();
        return this;
    }
    public boolean ifSelectedThreeHairDryers() {
        if (driver.findElement(By.xpath("//input[@value='rowenta']")).isSelected() &&
                driver.findElement(By.xpath("//input[@value='philips']")) .isSelected() &&
                driver.findElement(By.xpath("//input[@value='babylisspro']")) .isSelected()) {
            System.out.println("All items are selected");
            return true;
        }else {
            System.out.println("No products selected");
            return false;
        }
    }
}

