package cz.neoris.ietestp3.pages;

import cz.neoris.ietestp3.basic.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.Assert.assertTrue;

public class ConsoleLoginPageBy extends LoadableComponent<ConsoleLoginPageBy> implements Helper {

    private final WebDriver driver;

    @FindBy(css = "[name=\"username\"]") private WebElement Username;
    @FindBy(css = "[name=\"password\"]") private WebElement Password;
    @FindBy(css = "button.primary.normal") private WebElement LoginButton;
    @FindBy(css = "h3") private WebElement HeaderMain;


    public ConsoleLoginPageBy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Override
    protected void load() {

        driver.get(CONSOLE_PROD + "/login");
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

    public void LogInCustom(String CustUSername, String CustPwd) {
        clearAndType(Username, CustUSername);
        clearAndType(Password, CustPwd);
        LoginButton.click();
    }

    public void HeaderTest() {
        String header = driver.findElement((By) HeaderMain).getText();
        assertTrue("Header is not right", header.contentEquals("Customer Portal"));
    }
}
