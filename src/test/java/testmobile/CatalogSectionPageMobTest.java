package testmobile;

import org.junit.Assert;
import org.junit.Test;
import testbase.BaseMobileEmulatorTest;


public class CatalogSectionPageMobTest extends BaseMobileEmulatorTest {
    @Test
    public void testIfDisplayedCategories() {
        catalogSectionPage.open();
        Assert.assertTrue(catalogSectionPage.ifDisplayedCategories());

    }
}
