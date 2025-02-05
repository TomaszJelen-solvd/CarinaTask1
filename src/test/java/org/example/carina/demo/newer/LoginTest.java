package org.example.carina.demo.newer;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class LoginTest implements IAbstractTest {
    static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @BeforeTest
    public void beforeTest() {}

    @Test
    public void wrongLoginSeleniumTest() {
        LoginPageBase startingLoginPage = initPage(getDriver(), LoginPageBase.class);
        startingLoginPage.open();


        startingLoginPage.clickSubmit();
        Assert.assertTrue(startingLoginPage.checkErrorDisplayed(), "Failed to display error");
        Assert.assertTrue(startingLoginPage.checkRightErrorDisplayed(), "Wrong error message");
    }

//    @Test
//    public void deviceModelCheck() {
//        LoginPageBase startingLoginPage = initPage(getDriver(), LoginPageBase.class);
//        startingLoginPage.open();
//        String loginDevice = startingLoginPage.getDeviceModel();
//        startingLoginPage.fillLogin(userName);
//        startingLoginPage.fillPassword(password);
//        InventoryPageBase inventoryPage = startingLoginPage.clickSubmit();
//        String inventoryDevice = inventoryPage.getDeviceModel();
//        CartPageBase cartPage = inventoryPage.clickCart();
//        Assert.assertEquals(cartPage.getDeviceModel(), loginDevice, "Error: Mismatched devices");
//        Assert.assertEquals(cartPage.getDeviceModel(), inventoryDevice, "Error: Mismatched devices");
//    }

    @AfterTest
    public void afterTest() {}
}
