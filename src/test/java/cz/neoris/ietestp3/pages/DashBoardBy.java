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

    @FindBy(xpath = "/html/body/app/home/div/dashboard/div/div[2]/div[2]/div[1]/div[5]/a/div/h2")
        private WebElement OrderAndProductUS;

    @FindBy(css = "ul.sidebar-ul > li:nth-of-type(6) > a > span.as-label")
        private WebElement OrderAndProductFrameMX;

    @FindBy(css = "ul.sidebar-ul > li:nth-of-type(5) > a > span.as-label")
        private WebElement OrderAndProductFrameUS;

    @FindBy (css = "div.collapse.logo-container-gt-sm") private WebElement LeftFrameName;

    public DashBoardBy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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

    public void CheckOPFrameMX() throws ElementNotVisibleException {
        String TextOfOPFrame = OrderAndProductFrameMX.getText();
        assertTrue("No order element in left frame", TextOfOPFrame != "Order and Product Catalog");
    }

    public void CheckOPFrameUS() throws ElementNotVisibleException {
        String TextOfOPFrame = OrderAndProductFrameUS.getText();
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

    public void ClickOPCMX() throws ElementNotVisibleException {
        OrderAndProduct.click();
    }

    public void ClickOPCUS() throws ElementNotVisibleException {
        OrderAndProductUS.click();
    }


}
