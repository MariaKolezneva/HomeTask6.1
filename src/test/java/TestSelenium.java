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
    public void testChooseHairDryer() {
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
    public void testChooseHairDryers() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://onliner.by");
        driver.findElement(By.xpath("//span[text()='Фены']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300)");
        driver.findElement(By.xpath("//input[@value='rowenta']/following-sibling::span")).click();
        driver.findElement(By.xpath("//input[@value='philips']/following-sibling::span")).click();
        driver.findElement(By.xpath("//input[@value='babylisspro']/following-sibling::span")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/div[1]/div[4]/div[3]/div[4]")));
        if (driver.findElement(By.xpath("//input[@value='rowenta']")).isSelected() &&
                driver.findElement(By.xpath("//input[@value='philips']")) .isSelected() &&
                driver.findElement(By.xpath("//input[@value='babylisspro']")) .isSelected()) {
            System.out.println("All items are selected");
        } else {
            System.out.println("Not all three items are selected");
        }

        driver.quit();
    }
    
}

