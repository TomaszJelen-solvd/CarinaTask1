package org.example.carina.demo.newer.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.example.carina.demo.newer.CartPageBase;
import org.example.carina.demo.newer.InventoryPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = InventoryPageBase.class)
public class InventoryPage extends InventoryPageBase {
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase clickCart() {
        cart.click();
        return initPage(driver, CartPageBase.class);
//        return new CartPage(driver);
    }

    @Override
    public String getDeviceModel() {
        return "Desktop";
    }
}
