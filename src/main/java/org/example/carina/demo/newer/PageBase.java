package org.example.carina.demo.newer;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PageBase extends AbstractPage {
    protected PageBase(WebDriver driver) {
        super(driver);
    }
}
