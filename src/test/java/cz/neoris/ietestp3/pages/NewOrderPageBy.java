package cz.neoris.ietestp3.pages;

import cz.neoris.ietestp3.basic.Helper;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewOrderPageBy implements Helper {

    private final WebDriver driver;

    @FindBy(css = "div.d-flex.flex-wrap.products > div:nth-of-type(1)") private WebElement RMX;
    @FindBy(xpath = "//div[@class='product']") private WebElement RMXUSA;
    @FindBy(css = "div.d-flex.flex-wrap.products > div:nth-of-type(2)") private WebElement CEMBULK;
    @FindBy (css = "div.d-flex.flex-wrap.products > div:nth-of-type(3)") private WebElement MULTIP;

    public NewOrderPageBy (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void WaitForButtons() throws ElementNotVisibleException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement ExpectedRMX = wait.until(ExpectedConditions.elementToBeClickable(RMX));
        WebElement ExpectedCEMBULK = wait.until(ExpectedConditions.elementToBeClickable(CEMBULK));
        WebElement ExpectedMP = wait.until(ExpectedConditions.elementToBeClickable(MULTIP));
    }

    public void WaitForButtonUS() throws ElementNotVisibleException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement ExpectedRMX = wait.until(ExpectedConditions.elementToBeClickable(RMXUSA));
    }

    public void RMXClick() throws ElementNotVisibleException {
        RMX.click();
    }

    public void USRMXClick() throws ElementNotVisibleException {
        RMXUSA.click();
    }

    public void CementClick() throws ElementNotVisibleException {
        CEMBULK.click();
    }

    public void MPClick() throws ElementNotVisibleException {
        MULTIP.click();
    }

}
