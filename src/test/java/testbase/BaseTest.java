package testbase;

import common.CommonActions;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import pages.base.PageBase;
import pages.catalog.HairDryerPage;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected PageBase pageBase = new PageBase(driver);
    protected HairDryerPage hairDryerPage = new HairDryerPage(driver);
    @After
    public void close(){
        driver.quit();
    }
}
