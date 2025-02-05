package org.example.carina.demo.newer.desktop;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.example.carina.demo.newer.InventoryPageBase;
import org.example.carina.demo.newer.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
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
        return "Desktop";
    }

}
