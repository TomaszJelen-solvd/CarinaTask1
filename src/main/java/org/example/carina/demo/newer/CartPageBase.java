package org.example.carina.demo.newer;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

public abstract class CartPageBase extends AbstractPage {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    protected List<ExtendedWebElement> productTitles;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    protected List<ExtendedWebElement> productPrices;

    public CartPageBase(WebDriver driver) {
        super(driver);
    }


    public boolean checkProductTitle(String title) {
        for (ExtendedWebElement productTitle : productTitles) {
            if (productTitle.getText().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkProductTitlePrice(String title, BigDecimal price) {
        for (ExtendedWebElement productTitle : productTitles) {
            if (productTitle.getText().equals(title)) {
                String text = productPrices.get(productTitles.indexOf(productTitle)).getText();
                BigDecimal number = new BigDecimal(Pattern.compile("\\d+(\\.\\d+|)").matcher(text).results().findFirst().get().group());
                return number.compareTo(price) == 0;
            }
        }
        return false;
    }

    public boolean checkProductTitles(List<String> titles) {
        for (String title : titles) {
            if (!this.checkProductTitle(title)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkProductTitlesPrices(List<String> titles, List<BigDecimal> prices) {
        for (int i = 0; i < titles.size(); i++) {
            if (!this.checkProductTitlePrice(titles.get(i), prices.get(i))) {
                return false;
            }
        }
        return true;
    }

    public List<String> getProductTitles() {
        return productTitles.stream().map(ExtendedWebElement::getText).toList();
    }
    public List<BigDecimal> altGetProductPrices() {
        return productPrices.stream().map(ExtendedWebElement::getText)
                .map(text -> new BigDecimal(Pattern.compile("\\d+(\\.\\d+|)")
                        .matcher(text).results().findFirst().get().group()))
                .toList();
    }

    public abstract String getDeviceModel();

}
