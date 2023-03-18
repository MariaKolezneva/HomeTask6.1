package pages.base;

import org.openqa.selenium.WebDriver;

public class PageBase {
    protected WebDriver driver;
    public PageBase (WebDriver driver){
        this.driver= driver;
    }
    public void open (String url){
        driver.get(url);
    }
}
