package org.example.carina.demo.newer;

import com.zebrunner.carina.core.IAbstractTest;

import java.math.BigDecimal;
import java.util.List;

public abstract class TestBase implements IAbstractTest {
    boolean checkProductTitle(List<String> productTitles, String title) {
        for (String productTitle : productTitles) {
            if (productTitle.equals(title)) {
                return true;
            }
        }
        return false;
    }

    boolean checkProductTitles(List<String> productTitles, List<String> titles) {
        for (String title : titles) {
            if (!checkProductTitle(productTitles, title)) {
                return false;
            }
        }
        return true;
    }

    boolean checkProductTitlePrice(List<String> productTitles, String title, List<BigDecimal> productPrices, BigDecimal price) {
        for (String productTitle : productTitles) {
            if (productTitle.equals(title)) {
                return productPrices.get(productTitles.indexOf(productTitle)).compareTo(price) == 0;
            }
        }
        return false;
    }

    boolean checkProductTitlesPrices(List<String> productTitles, List<String> titles, List<BigDecimal> productPrices, List<BigDecimal> prices) {
        for (int i = 0; i < titles.size(); i++) {
            if (!checkProductTitlePrice(productTitles, titles.get(i), productPrices, prices.get(i))) {
                return false;
            }
        }
        return true;
    }
}
