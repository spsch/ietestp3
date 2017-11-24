package cz.neoris.ietestp3.basic;

import cz.neoris.ietestp3.pages.ConsoleLoginPageBy;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.w3c.dom.html.HTMLBRElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestConsoleMXLogin implements Helper {

    WebDriver driver;
    private static Logger LOG = Logger.getLogger(TestConsoleMXLogin.class);

    @BeforeClass
    public void setUpClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeTest
    public void setUp() {
        BasicConfigurator.configure();
        LOG.info("setup");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogInConsoleMX() {

        String url = driver.getCurrentUrl();
        ConsoleLoginPageBy consoleloginpage = new ConsoleLoginPageBy(driver).get();
        System.out.println("URL is " + url);
        consoleloginpage.LogInCustom(PROD_MX_USER, PROD_PWD);

        String header = driver.findElement(By.cssSelector("h3")).getText();
        assertTrue("Header is not right", header.contentEquals("Customer Portal"));

    }

    public void testMainPage() {
        assertTrue("Main header is missing", driver.findElement(By.cssSelector("div.tabbar-container > div > div:nth-of-type(1)")).getText().contentEquals("Console - Orders Requested"));
        assertTrue("Show filters button is missing", driver.findElement(By.cssSelector("button.cemex-button")).getText().contentEquals("SHOWFILTERS"));
        /**all main elements**/
        WebElement OrdersReceived = driver.findElement(By.cssSelector("div > div:nth-of-type(2) > app-tabbar-selector:nth-of-type(1) > div > button.tab-button > div.tab-button-container"));
        WebElement ActionRequired = driver.findElement(By.cssSelector("div > div:nth-of-type(2) > app-tabbar-selector:nth-of-type(2) > div > button.tab-button > div.tab-button-container"));
        WebElement InProcess = driver.findElement(By.cssSelector("div > div:nth-of-type(2) > app-tabbar-selector:nth-of-type(3) > div > button.tab-button > div.tab-button-container"));
        WebElement Completed = driver.findElement(By.cssSelector("div > div:nth-of-type(2) > app-tabbar-selector:nth-of-type(4) > div > button.tab-button > div.tab-button-container"));
        /**testing elements**/
        assertTrue("Orders is missing", OrdersReceived.isDisplayed());
        assertTrue("Action is missing", ActionRequired.isDisplayed());
        assertTrue("In process is missing", InProcess.isDisplayed());
        assertTrue("Completed is missing", Completed.isDisplayed());

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
