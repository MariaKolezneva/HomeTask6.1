package testdesktop;

import org.junit.Assert;
import org.junit.Test;
import testbase.BaseTest;

public class CatalogSectionPageTest extends BaseTest {
    @Test
    public void testIfDisplayedCategories() {
        catalogSectionPage.open();
        Assert.assertTrue(catalogSectionPage.ifDisplayedCategories());

    }
}
