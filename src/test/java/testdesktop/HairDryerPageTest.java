package testdesktop;

import org.junit.Assert;
import org.junit.Test;
import testbase.BaseTest;

public class HairDryerPageTest extends BaseTest {

    @Test
    public void testChooseOneHairDryer() {
        hairDryerPage.open();
        hairDryerPage.scrollPage();
        hairDryerPage.chooseOneHairDryer();
        Assert.assertTrue(hairDryerPage.ifSelectedOneHairDryer());
        Assert.assertTrue(hairDryerPage.isProductsDisplayed());


    }
    @Test
    public void testChooseHairDryers(){
        hairDryerPage.open();
        hairDryerPage.scrollPage();
        hairDryerPage.chooseHairDryers();
        Assert.assertTrue(hairDryerPage.ifSelectedThreeHairDryers());
        Assert.assertTrue(hairDryerPage.isProductsDisplayed());


    }

}
