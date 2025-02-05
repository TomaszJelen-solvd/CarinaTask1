package org.example.carina.demo.newer.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.example.carina.demo.newer.CartPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getDeviceModel() {
        return "Desktop";
    }
}
