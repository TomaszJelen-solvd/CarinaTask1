package org.example.carina.demo.newer;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.carina.demo.gui.pages.common.AllBrandsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class LoginPageBase extends AbstractPage {

    @FindBy(css = "input[id='user-name']")
    protected ExtendedWebElement login;

    @FindBy(css = "input[id='password']")
    protected ExtendedWebElement password;

    @FindBy(css = "input[id='login-button']")
    protected ExtendedWebElement submit;

    @FindBy(css = "div[class='error-message-container error']")
    protected ExtendedWebElement error;

    @FindBy(css = "h3[data-test='error']")
    protected ExtendedWebElement errorText;

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public void fillLogin(String fill) {
        login.type(fill);
    }

    public void fillPassword(String fill) {
        password.type(fill);
    }

    public abstract InventoryPageBase clickSubmit();

    public boolean checkErrorDisplayed() {
        return error.isPresent();
    }

    public boolean checkRightErrorDisplayed() {
        return errorText.getText().equals("Epic sadface: Username is required");
    }

    public abstract String getDeviceModel();
}
