package pages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.PageBase;

public class ComputerAndNetworksPage extends PageBase {
    public ComputerAndNetworksPage(WebDriver driver) {
        super(driver);
    }

    private static final String website = "https://onliner.by/";
    private final By catalog = By.className("b-main-navigation__text");
    private final By computerAndNetworks = By.cssSelector(".catalog-navigation>ul>li:nth-child(4)");
    private final String[] menuComputerAndNetworks = {"//div[@class='catalog-navigation-list__aside-title'] [contains(text(),'Ноутбуки, компьютеры, мониторы')]",
            "//div[@class='catalog-navigation-list__aside-title'] [contains(text(),'Комплектующие')]",
            "//div[@class='catalog-navigation-list__aside-title'] [contains(text(),'Хранение данных')]",
            "//div[@class='catalog-navigation-list__aside-title'] [contains(text(),'Сетевое оборудование')]"};

    public void open() {
        driver.get(website);
        driver.findElement(catalog).click();
        driver.findElement(computerAndNetworks).click();
    }
    public boolean ifDisplayedMenuComputerAndNetworks() {
        boolean isDisplayed = false;
        for (String xpath : menuComputerAndNetworks) {
            WebElement menu = driver.findElement(By.xpath(xpath));
            if (menu.isDisplayed()){
                System.out.println("Menu section is showing");
                isDisplayed = true;
            } else {
                System.out.println("Menu section not showing");
            }
        }
        return isDisplayed;

        }
    }
