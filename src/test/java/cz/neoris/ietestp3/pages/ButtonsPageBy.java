package cz.neoris.ietestp3.pages;

import cz.neoris.ietestp3.basic.Helper;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsPageBy implements Helper {

    private final WebDriver driver;

    @FindBy(css = "button.button.bright-green") private WebElement ActiveNextBtn;
    @FindBy(css = "button.button.disabled") private WebElement NonActiveNextBtn;
    @FindBy(css = "button.button.button-ghost") private WebElement BackAndExitBtn;
    @FindBy(css = "div.circle-container > div:nth-of-type(1) > span:nth-of-type(2)") private WebElement Delivery;
    @FindBy(css = "div.circle-container > div:nth-of-type(3) > span:nth-of-type(2)") private WebElement Pickup;

    public ButtonsPageBy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void NextBtnClick() throws ElementNotVisibleException {

        WebDriverWait await = new WebDriverWait(driver, 60);
        WebElement clickableNext = await.until(ExpectedConditions.elementToBeClickable(ActiveNextBtn));
        ActiveNextBtn.click();
    }

    public void BackBtnClick() throws ElementNotVisibleException {

        WebDriverWait dwait = new WebDriverWait(driver, 60);
        WebElement clickableBack = dwait.until(ExpectedConditions.elementToBeClickable(BackAndExitBtn));
        BackAndExitBtn.click();
    }

    public void DeliveryClick() throws ElementNotVisibleException {
        WebDriverWait swait = new WebDriverWait(driver, 60);
        WebElement clickableDelivery = swait.until(ExpectedConditions.elementToBeClickable(Delivery));
        Delivery.click();
    }

    public void PickupClick() throws ElementNotVisibleException {
        WebDriverWait fwait = new WebDriverWait(driver, 60);
        WebElement clickablePickup = fwait.until(ExpectedConditions.elementToBeClickable(Pickup));
        Pickup.click();
    }

}
