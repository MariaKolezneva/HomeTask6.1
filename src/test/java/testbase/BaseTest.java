package testbase;

import common.CommonActions;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import pages.base.PageBase;
import pages.catalog.CatalogSectionPage;
import pages.catalog.ElementsAccessoriesPage;
import pages.catalog.HairDryerPage;
import pages.catalog.ComputerAndNetworksPage;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected PageBase pageBase = new PageBase(driver);
    protected HairDryerPage hairDryerPage = new HairDryerPage(driver);
    protected ComputerAndNetworksPage verticalMenuComputerAndNetworks = new ComputerAndNetworksPage(driver);
    protected ElementsAccessoriesPage elementsAccessoriesPage = new ElementsAccessoriesPage(driver);
    protected CatalogSectionPage catalogSectionPage = new CatalogSectionPage(driver);
    @After
    public void close(){
        driver.quit();
    }
}
