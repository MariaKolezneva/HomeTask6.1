package testdesktop;

import org.junit.Assert;
import org.junit.Test;
import testbase.BaseTest;

public class VerticalMenuComputerAndNetworksTest extends BaseTest {
    @Test
    public void testIfDisplayedMenuComputerAndNetworks() {
        verticalMenuComputerAndNetworks.open();
        Assert.assertTrue(verticalMenuComputerAndNetworks.ifDisplayedMenuComputerAndNetworks());
    }
}
