import org.junit.Assert;
import org.junit.Test;
import testbase.BaseTest;

public class HairDryerPage extends BaseTest {

    @Test
    public void testChooseOneHairDryer() {
        hairDryerPage.open();
        hairDryerPage.chooseOneHairDryer();
        Assert.assertTrue(hairDryerPage.ifSelectedOneHairDryer());
        Assert.assertTrue(hairDryerPage.isProductsDisplayed());


    }
    @Test
    public void testChooseHairDryers(){
        hairDryerPage.open();
        hairDryerPage.chooseHairDryers();
        Assert.assertTrue(hairDryerPage.ifSelectedThreeHairDryer());
        Assert.assertTrue(hairDryerPage.isProductsDisplayed());


    }

}
