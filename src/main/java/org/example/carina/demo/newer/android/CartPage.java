package org.example.carina.demo.newer.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.example.carina.demo.newer.CartPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getDeviceModel() {
        return "Android phone";
    }
}
