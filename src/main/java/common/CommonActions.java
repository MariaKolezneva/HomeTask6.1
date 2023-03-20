package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CommonActions {
    public static final String chromeDriverPath = "C:/chromeDriver/chromedriver.exe";
    private static ChromeOptions chromeOptions = new ChromeOptions();
    public static WebDriver createDriver(){
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        return new ChromeDriver(chromeOptions);
    }
}
