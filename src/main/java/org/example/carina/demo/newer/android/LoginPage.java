package org.example.carina.demo.newer.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.example.carina.demo.newer.InventoryPageBase;
import org.example.carina.demo.newer.LoginPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public InventoryPageBase clickSubmit() {
        submit.click();
        return initPage(driver, InventoryPageBase.class);
    }

    @Override
    public String getDeviceModel() {
        return "Android phone";
    }

}
