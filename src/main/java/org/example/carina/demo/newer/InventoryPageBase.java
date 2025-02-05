package org.example.carina.demo.newer;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class InventoryPageBase extends AbstractPage {
    @FindBy(xpath = "//div[text()='Swag Labs']")
    protected ExtendedWebElement title;
    @FindBy(css = "a[class='shopping_cart_link']")
    protected ExtendedWebElement cart;


    @FindBy(css = "div[class='inventory_item']")
    protected List<ProductComponent> products;
    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    protected List<ExtendedWebElement> productTitles;
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    protected List<ExtendedWebElement> productPrices;
    @FindBy(xpath = "//div[@class='inventory_item_price']/following-sibling::button")
    protected List<ExtendedWebElement> productAddButtons;


    public InventoryPageBase(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<ProductComponent> getProductComponents() {
        return products;
    }

    public ProductComponent getProductComponent(int index) {
        return products.get(index);
    }

    public abstract CartPageBase clickCart();

    public abstract String getDeviceModel();


}
