package cz.neoris.ietestp3.pages;

import cz.neoris.ietestp3.basic.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPageBy implements Helper {

    WebDriver  driver;

    /**@FindBy(css = "div.first-container > div:nth-of-type(1) > div:nth-of-type(2) > ss-multiselect-dropdown > div.dropdown.location-dropdown > button.dropdown-toggle.btn.btn-default.btn-block > span.arrow.cmx-icon-straight-arrow-down") private WebElement Jobsite;
    @FindBy(css = "div.input-group.input-group-sm > input.form-control") private WebElement FindJobsite;**/

    public LocationPageBy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickShit() {
        driver.findElement(By.xpath("//button[contains(.,'Select from existing jobsite')]"));
    }

}
