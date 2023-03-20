package testdesktop;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import testbase.BaseTest;

import java.util.List;

public class ElementsAccessoriesPageTest extends BaseTest {
    @Test
    public void testDescriptionOfComponents() {
        elementsAccessoriesPage.open();
        elementsAccessoriesPage.scrollPage();
        List<WebElement> categories = elementsAccessoriesPage.getCategories();
        for (WebElement category : categories) {
            WebElement title = (WebElement) elementsAccessoriesPage.getTitles();
            WebElement description = (WebElement) elementsAccessoriesPage.getDescriptions();
            Assertions.assertAll(
                    () -> Assertions.assertNotNull(title, "Item name not showing " + category),
                    () -> Assertions.assertNotNull(description, "The number of products and the minimum price is not displayed " + category),
                    () -> Assertions.assertTrue(description.getText().contains("товар") && description.getText().contains("от"), "Description does not contain 'товар' and 'от' " + category)
            );

        }

    }
}


