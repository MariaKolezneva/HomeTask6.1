import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

public class TestSelenium {
    private final String chromeDriverPath = "C:/chromeDriver/chromedriver.exe";
    private static ChromeOptions chromeOptions = new ChromeOptions();

    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://onliner.by");
        driver.findElement(By.xpath("//span[text()='Фены']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 280)");
        driver.findElement(By.xpath("//input[@value='babyliss']/following-sibling::span")).click();

        if (driver.findElement(By.xpath("//input[@value='babyliss']")).isSelected()) {
            System.out.println("Still selected");
        }
        driver.quit();
    }

    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://onliner.by");
        driver.findElement(By.xpath("//span[text()='Фены']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
        List<WebElement> elements = driver.findElements(By.xpath("//input[(@value='Rowenta', @value='Dyson', @value='Philips')]/following-sibling::span"));
        for (WebElement element : elements) {
            element.click();
        }
        for (WebElement element : elements) {
            if (!element.isSelected()) {
                System.out.println("Element not selected: " + element.getText());
            }
        }
        driver.quit();
    }
}

