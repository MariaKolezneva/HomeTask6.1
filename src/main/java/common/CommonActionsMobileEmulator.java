package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class CommonActionsMobileEmulator {
    private static final String chromeDriverPath = "C:/chromeDriver/chromedriver.exe";
    public static WebDriver createDriverMobileEmulator() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        Map<String, String> props = new HashMap<>();
        props.put("deviceName", "Pixel 5");
        options.setExperimentalOption("mobileEmulation", props);
        return new ChromeDriver(options);
    }
}
