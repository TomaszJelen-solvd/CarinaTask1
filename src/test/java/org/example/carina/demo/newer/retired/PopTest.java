package org.example.carina.demo.newer.retired;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.carina.demo.newer.CartPageBase;
import org.example.carina.demo.newer.InventoryPageBase;
import org.example.carina.demo.newer.LoginPageBase;
import org.example.carina.demo.newer.ProductComponent;
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

public class PopTest implements IAbstractTest {
    static final Logger logger = LoggerFactory.getLogger(PopTest.class);

    String userName = "standard_user";
    String password = "secret_sauce";

//    WebDriver driver;
//    LoginPage startingLoginPage;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
//        ChromeOptions options = new ChromeOptions();
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

//    @BeforeMethod
//    public void beforeMethod() {
//        driver.get("https://www.saucedemo.com/");
//        startingLoginPage = new LoginPage(driver);
//    }

    @Test
    public void wrongLoginSeleniumTest() throws MalformedURLException, InterruptedException {

//        WebDriver driver = driverPool.getDriver();

//        driver.get("https://www.saucedemo.com/");
//        LoginPageBase startingLoginPage = new LoginPage(getDriver());
        LoginPageBase startingLoginPage = initPage(getDriver(), LoginPageBase.class);
        startingLoginPage.open();


        InventoryPageBase inventoryPage = startingLoginPage.clickSubmit();
        Assert.assertTrue(startingLoginPage.checkErrorDisplayed(), "Failed to display error");
        Assert.assertTrue(startingLoginPage.checkRightErrorDisplayed(), "Wrong error message");

//        driver.quit();
    }

    @Test
    public void correctLoginSeleniumTest() throws MalformedURLException, InterruptedException {

        WebDriver driver = getDriver();

//        driver.get("https://www.saucedemo.com/");
        LoginPageBase startingLoginPage = initPage(getDriver(), LoginPageBase.class);
        startingLoginPage.open();



        startingLoginPage.fillLogin(userName);
        startingLoginPage.fillPassword(password);
        InventoryPageBase inventoryPage = startingLoginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Wrong url");
        Assert.assertTrue(inventoryPage.getProductComponent(0).checkTitleDisplayed(), "Wrong content title");

//        driver.quit();
    }

    //    @Test TODO
    public void cartCheckSeleniumTest() throws MalformedURLException, InterruptedException {

//        WebDriver driver = driverPool.getDriver();

//        driver.get("https://www.saucedemo.com/");
        LoginPageBase startingLoginPage = initPage(getDriver(), LoginPageBase.class);
        startingLoginPage.open();


        startingLoginPage.fillLogin(userName);
        startingLoginPage.fillPassword(password);
        InventoryPageBase inventoryPage = startingLoginPage.clickSubmit();
        int index = 0;
        inventoryPage.getProductComponent(index).clickAddButton();
        String title = inventoryPage.getProductComponent(index).getProductTitle();
        CartPageBase cartPage = inventoryPage.clickCart();
//        Assert.assertTrue(cartPage.checkProduct(index), "Wrong products");
        Assert.assertTrue(checkProductTitle(cartPage.getProductTitles(), title), "Wrong product title");

//        driver.quit();

    }

    private static boolean checkProductTitle(List<String> productTitles, String title) {
        for (String productTitle : productTitles) {
            if (productTitle.equals(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkProductTitles(List<String> productTitles, List<String> titles) {
        for (String title : titles) {
            if (!checkProductTitle(productTitles, title)) {
                return false;
            }
        }
        return true;
    }

    //    @Test TODO
    public void cartMultipleCheckSeleniumTest() throws MalformedURLException, InterruptedException {

//        WebDriver driver = driverPool.getDriver();

//        driver.get("https://www.saucedemo.com/");
        LoginPageBase startingLoginPage = initPage(getDriver(), LoginPageBase.class);
        startingLoginPage.open();


        startingLoginPage.fillLogin(userName);
        startingLoginPage.fillPassword(password);
        InventoryPageBase inventoryPage = startingLoginPage.clickSubmit();
//        driver.manage().deleteAllCookies();
        int index = 0;
        inventoryPage.getProductComponent(index).clickAddButton();
        String title = inventoryPage.getProductComponent(index).getProductTitle();
        CartPageBase cartPage = inventoryPage.clickCart();
//        Assert.assertTrue(cartPage.checkProduct(index), "Wrong products");
        Assert.assertTrue(checkProductTitle(cartPage.getProductTitles(), title), "Wrong product title");
        Assert.assertTrue(checkProductTitles(cartPage.getProductTitles(), List.of(title)), "Wrong product title");

//        driver.quit();
    }


    @Test
    public void experimentTest() throws MalformedURLException, InterruptedException {

//        WebDriver driver = driverPool.getDriver();

//        driver.get("https://www.saucedemo.com/");
        LoginPageBase startingLoginPage = initPage(getDriver(), LoginPageBase.class);
        startingLoginPage.open();


        startingLoginPage.fillLogin(userName);
        startingLoginPage.fillPassword(password);
        InventoryPageBase inventoryPage = startingLoginPage.clickSubmit();
        int index = 1;
        logger.info(inventoryPage.getProductComponent(index).getProductTitle());
        logger.info(inventoryPage.getProductComponent(index).getProductPrice());
        Assert.assertEquals(inventoryPage.getProductComponent(index).protoGetProductPrice(), new BigDecimal("9.99"), "Wrong price");
        Assert.assertEquals(inventoryPage.getProductComponent(index).altGetProductPrice(), new BigDecimal("9.99"), "Wrong price");

//        driver.quit();
    }

//    @Test TODO
    public void addButtonSeleniumTest() throws MalformedURLException, InterruptedException {

//        WebDriver driver = driverPool.getDriver();

//        driver.get("https://www.saucedemo.com/");
        LoginPageBase startingLoginPage = initPage(getDriver(), LoginPageBase.class);
        startingLoginPage.open();


        startingLoginPage.fillLogin(userName);
        startingLoginPage.fillPassword(password);
        InventoryPageBase inventoryPage = startingLoginPage.clickSubmit();
        int index = 3;
        ProductComponent productComponent = inventoryPage.getProductComponent(index);
        String text = productComponent.getAddButtonText();
        productComponent.clickAddButton();
        Assert.assertNotEquals(productComponent.getAddButtonText(), text, "Error with switching buttons");

//        driver.quit();

//        driverPool.releaseDriver(driver);
    }

    @Test
    public void cartMultipleCheckTitlePriceTest() throws MalformedURLException, InterruptedException {

//        WebDriver driver = driverPool.getDriver();

//        driver.get("https://www.saucedemo.com/");
        LoginPageBase startingLoginPage = initPage(getDriver(), LoginPageBase.class);
        startingLoginPage.open();


        startingLoginPage.fillLogin(userName);
        startingLoginPage.fillPassword(password);
        InventoryPageBase inventoryPage = startingLoginPage.clickSubmit();
        List<String> titles = new ArrayList<>();
        List<BigDecimal> prices = new ArrayList<>();
        for (int index : List.of(0, 2, 5)) {
//        int index = 0;
            ProductComponent productComponent = inventoryPage.getProductComponent(index);
            productComponent.clickAddButton();
            titles.add(productComponent.getProductTitle());
            prices.add(productComponent.altGetProductPrice());
        }
        CartPageBase cartPage = inventoryPage.clickCart();
        Assert.assertTrue(checkProductTitlesPrices(cartPage.getProductTitles(), titles, cartPage.altGetProductPrices(), prices), "Error: Wrong products or prices");
//        Assert.assertTrue(cartPage.checkProductTitlesPrices(titles, prices), "Error: Wrong products or prices");
//        driver.quit();

//        driverPool.releaseDriver(driver);
    }

    public boolean checkProductTitlePrice(List<String> productTitles, String title, List<BigDecimal> productPrices, BigDecimal price) {
        for (String productTitle : productTitles) {
            if (productTitle.equals(title)) {
                return productPrices.get(productTitles.indexOf(productTitle)).compareTo(price) == 0;
            }
        }
        return false;
    }

    public boolean checkProductTitlesPrices(List<String> productTitles, List<String> titles, List<BigDecimal> productPrices, List<BigDecimal> prices) {
        for (int i = 0; i < titles.size(); i++) {
            if (!checkProductTitlePrice(productTitles, titles.get(i), productPrices, prices.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void deviceModelCheck() {
        LoginPageBase startingLoginPage = initPage(getDriver(), LoginPageBase.class);
        startingLoginPage.open();
        String loginDevice = startingLoginPage.getDeviceModel();
        startingLoginPage.fillLogin(userName);
        startingLoginPage.fillPassword(password);
        InventoryPageBase inventoryPage = startingLoginPage.clickSubmit();
        String inventoryDevice = inventoryPage.getDeviceModel();
        CartPageBase cartPage = inventoryPage.clickCart();
        Assert.assertEquals(cartPage.getDeviceModel(), loginDevice, "Error: Mismatched devices");
        Assert.assertEquals(cartPage.getDeviceModel(), inventoryDevice, "Error: Mismatched devices");
    }

    @AfterTest
    public void afterTest() {
//        driver.quit();
//        driverPool.close();
    }
}
