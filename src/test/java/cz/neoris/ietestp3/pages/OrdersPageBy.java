package cz.neoris.ietestp3.pages;

import cz.neoris.ietestp3.basic.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class OrdersPageBy implements Helper {

    private final WebDriver driver;

    @FindBy(css = "a.button-ghost") private WebElement RequestOrderButton;
    @FindBy(css = "h1") private WebElement AllOrdersHeader;
    @FindBy(css = "ul.sidebar-ul > li:nth-of-type(6) > a > span.as-label") private WebElement LeftFrameOPC;
    @FindBy(css = "div.float-sm-right > button:nth-of-type(1)") private WebElement UploadButton;

    public OrdersPageBy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void WaitForRequestButton() throws ElementNotVisibleException {

        WebDriverWait wait = new WebDriverWait(driver, 60);

        WebElement AwaitedButton = wait.until(ExpectedConditions
                .presenceOfElementLocated(By
                        .xpath("//*[@id=\"layout\"]/page-orders/div[3]/div/div[2]/div")));
        WebElement AwaitedButtonClickable = wait.until(ExpectedConditions
                .elementToBeClickable(By
                        .xpath("//*[@id=\"layout\"]/page-orders/div[3]/div/div[2]/div")));
    }

    public void CheckHeaderAndButton() throws ElementNotVisibleException {
        String header = AllOrdersHeader.toString();
        String BtnText = RequestOrderButton.getText();
        assertTrue("Missing orders header" + header, header != "All orders");
        assertTrue("Button not found" + BtnText, BtnText != "Request order");
    }

    public void CheckPage() {
        String url = driver.getCurrentUrl();
        assertTrue("Not on orders page" + url, url.endsWith("/orders"));
    }

    public void ClickRequest() throws ElementNotVisibleException {

        RequestOrderButton.click();

        driver.get(BASEURL + "/ordersnproduct/app/new");
    }

    public void UploadFile() throws ElementNotVisibleException {
        UploadButton.click();
        driver.findElement(By.cssSelector("label.upload-schedule-label")).click();
        driver.switchTo().activeElement().sendKeys("C:\\Users\\jan.svehlak\\scripts\\files_upload\\4MB.csv");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }



}
