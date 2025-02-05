package org.example.carina.demo.newer.retired;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.carina.demo.newer.InventoryPageBase;
import org.example.carina.demo.newer.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MobileTest implements IAbstractTest {
    String userName = "standard_user";
    String password = "secret_sauce";
    @Test
    public void correctLoginSeleniumTest() throws MalformedURLException, InterruptedException {

        WebDriver driver = getDriver();

        LoginPageBase startingLoginPage = initPage(getDriver(), LoginPageBase.class);
        startingLoginPage.open();

        startingLoginPage.fillLogin(userName);
        startingLoginPage.fillPassword(password);
        InventoryPageBase inventoryPage = startingLoginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Wrong url");
        Assert.assertTrue(inventoryPage.getProductComponent(0).checkTitleDisplayed(), "Wrong content title");
    }

    @Test
    public void testMobile() {
        getDriver().get("https://www.demoblaze.com");
    }
}
