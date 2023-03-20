package testbase;

import common.CommonActionsMobileEmulator;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import pages.base.PageBase;
import pages.catalog.CatalogSectionPage;
import pages.catalog.HairDryerPage;

public class BaseMobileEmulatorTest {
        protected WebDriver driver = CommonActionsMobileEmulator.createDriverMobileEmulator();
        protected PageBase pageBase = new PageBase(driver);
        protected CatalogSectionPage catalogSectionPage = new CatalogSectionPage(driver);

        @After
        public void close(){
            driver.quit();
        }
    }

