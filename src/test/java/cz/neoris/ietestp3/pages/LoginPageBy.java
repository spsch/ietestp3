package cz.neoris.ietestp3.pages;

import cz.neoris.ietestp3.basic.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.junit.Assert.assertTrue;

public class LoginPageBy extends LoadableComponent<LoginPageBy> implements Helper {

    private final WebDriver driver;

    @FindBy(css = "div.form > div:nth-of-type(1) > input.form-control") private WebElement Username;
    @FindBy(css = "div.form > div:nth-of-type(3) > input.form-control") private WebElement Password;
    @FindBy(css = "button.button") private WebElement LoginButton;


    public LoginPageBy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Override
    protected void load() {

        driver.get(BASEURL + "/login");
    }
    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertTrue("Not on login page: " + url, url.endsWith("/login"));
    }

    private void clearAndType(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }

    public void LogInCustom(String CustUSername) {
        clearAndType(Username, CustUSername);
        clearAndType(Password, PWD);
        LoginButton.click();
    }

    public void LogInMX() {
        clearAndType(Username, USERNAME_MX);
        clearAndType(Password, PWD);
        LoginButton.click();
    }

    public void LogInUS() {
        clearAndType(Username, USERNAME_USA);
        clearAndType(Password, PWD);
        LoginButton.click();
    }
}
