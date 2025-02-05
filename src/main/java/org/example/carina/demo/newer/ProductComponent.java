package org.example.carina.demo.newer;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

public class ProductComponent extends AbstractUIObject {
    @FindBy(css = "div[class='inventory_item_name ']")
    ExtendedWebElement  title;

    @FindBy(css = "div[class='inventory_item_price']")
    ExtendedWebElement price;

    @FindBy(xpath = ".//div[@class='inventory_item_price']/following-sibling::button")
    ExtendedWebElement  addButton;

    public ProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean checkTitleDisplayed() {
        return title.isPresent();
    }

    public String getProductTitle() {
        return title.getText();
    }

    public String getProductPrice() {
        return price.getText();
    }

    public BigDecimal protoGetProductPrice() {
        return new BigDecimal(price.getText().substring(1));
    }

    public BigDecimal altGetProductPrice() {
        String text = price.getText();
        return new BigDecimal(Pattern.compile("\\d+(\\.\\d+|)").matcher(text).results().findFirst().get().group());
    }

    public void clickAddButton() {
        addButton.click();
    }

    public String getAddButtonText() {
        return addButton.getText();
    }
}
