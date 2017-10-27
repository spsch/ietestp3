package cz.neoris.ietestp3.pages;

import cz.neoris.ietestp3.basic.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class DashBoardBy implements Helper {

    private final WebDriver driver;

    @FindBy(css = "div.container-fluid > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(6) > a.card-container > div.box")
        private WebElement OrderAndProduct;
    @FindBy(css = "ul.sidebar-ul > li:nth-of-type(6) > a > span.as-label")
        private WebElement OrderAndProductFrame;
    @FindBy (css = "div.collapse.logo-container-gt-sm") private WebElement LeftFrameName;

    public DashBoardBy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**@Override
    protected void load() {
        driver.get(BASEURL + "/home/dashboard");
        WaitForOPCButton();
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertTrue("Not on dashboard page: " + url, url.endsWith("/dashboard"));
    }**/

    public void WaitForOPCButton() throws ElementNotVisibleException {
        WebDriverWait mwait = new WebDriverWait(driver, 60);
        WebElement LongAwaitedButton = mwait
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("div.container-fluid > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(6) > a.card-container > div.box")));
    }


    public void CheckOPCButton() throws ElementNotInteractableException, ElementNotSelectableException, ElementNotVisibleException {
        String TextOfOPC = OrderAndProduct.getText();
        assertTrue("No order element", TextOfOPC != "Order and Product Catalog");
    }

    public void CheckOPFrame() throws ElementNotVisibleException {
        String TextOfOPFrame = OrderAndProductFrame.getText();
        assertTrue("No order element in left frame", TextOfOPFrame != "Order and Product Catalog");
    }

    public void CheckLeftFrame() throws ElementNotVisibleException {
        String TextOfLeftFrame = LeftFrameName.getText();
        assertTrue("Bad name of customer in left frame", TextOfLeftFrame != "home depot mexico, s. de r.l. de c.");
    }

    public void PageCheck() throws MalformedURLException {
        String mpage = driver.getCurrentUrl();
        assertTrue("No dashboard page" + mpage, mpage.endsWith("/dashboard"));
    }

    public void ClickOPC() throws ElementNotVisibleException {
        OrderAndProduct.click();
    }


}
