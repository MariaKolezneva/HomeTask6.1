import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestSelenium {
    private final String chromeDriverPath = "C:/chromeDriver/chromedriver.exe";
    private static ChromeOptions chromeOptions = new ChromeOptions();
    private final String website = "https://onliner.by";


    @Test
    public void testChooseHairDryer() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(website);
        driver.findElement(By.xpath("//span[text()='Фены']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 350)");
        driver.findElement(By.xpath("//input[@value='babyliss']/following-sibling::span")).click();
        if (driver.findElement(By.xpath("//input[@value='babyliss']")).isSelected()) {
            System.out.println("Still selected");
        }
        List<WebElement> products = driver.findElements(By.className("js-schema-results schema-grid__center-column"));
        if (products.size() > 0 && products.get(0).isDisplayed()) {
            System.out.println("At least one product is displayed");
        } else {
            System.out.println("No products are displayed");
        }
        driver.quit();
    }

    @Test
    public void testChooseHairDryers() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(website);
        driver.findElement(By.xpath("//span[text()='Фены']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400)");
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

    @Test
    public void testSectionWithMobileEmulator() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        Map<String, String> props = new HashMap<>();
        props.put("deviceName", "Pixel 5");
        options.setExperimentalOption("mobileEmulation",props);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://catalog.onliner.by/");
        List<WebElement> categories = driver.findElements(By.cssSelector(".catalog-navigation>ul>li:nth-child(3), .catalog-navigation>ul>li:nth-child(4), .catalog-navigation>ul>li:nth-child(5), .catalog-navigation>ul>li:nth-child(7), .catalog-navigation>ul>li:nth-child(9), .catalog-navigation>ul>li:nth-child(10), .catalog-navigation>ul>li:nth-child(11)"));
        for (WebElement category : categories) {
            Assertions.assertTrue(category.isDisplayed(), "Section not showing on page");
        }
        driver.quit();
    }

    @Test
    public void testVerticalMenu() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(website);
        driver.findElement(By.className("b-main-navigation__text")).click();
        driver.findElement(By.cssSelector(".catalog-navigation>ul>li:nth-child(4)")).click();
        String[] linksXpath = {"/html/body/div[1]/div/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div/div[1]/div[1]",
                "/html/body/div[1]/div/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div/div[2]/div[1]",
                "/html/body/div[1]/div/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div/div[6]/div[1]",
                "/html/body/div[1]/div/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div/div[8]/div[1]"};
        for (String xpath : linksXpath) {
            WebElement link = driver.findElement(By.xpath(xpath));
            Assertions.assertTrue(link.isDisplayed(), "Menu item not showing: " + xpath);
        }
        driver.quit();
    }

    @Test
    public void testDescriptionOfComponents() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(website);
        driver.findElement(By.className("b-main-navigation__text")).click();
        driver.findElement(By.cssSelector(".catalog-navigation>ul>li:nth-child(4)")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
        WebElement componentsLink = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div/div[2]"));
        componentsLink.click();
        List<WebElement> categories = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div/div[2]/div[2]/div/a"));
        for (WebElement category : categories) {
            WebElement title = category.findElement(By.cssSelector(".catalog-navigation-list__dropdown-title"));
            WebElement description = category.findElement(By.cssSelector(".catalog-navigation-list__dropdown-description"));
            Assertions.assertAll(
                    () -> Assertions.assertNotNull(title, "Item name not showing " + category),
                    () -> Assertions.assertNotNull(description, "The number of products and the minimum price is not displayed " + category),
                   () -> Assertions.assertTrue(description.getText().contains("товар")&& description.getText().contains("от"), "Description does not contain 'товар' and 'от' " + category)
           );
        }
        driver.quit();
    }
}



