package cz.neoris.ietestp3.basic;

import cz.neoris.ietestp3.pages.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.bcel.generic.NEW;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

public class TestWalkthroughMX implements Helper {

    WebDriver driver;
    private static Logger LOG = Logger.getLogger(TestWalkthroughMX.class);


    @BeforeClass
    public void setUpClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeTest
    public void setUp() {
        LOG.debug("setup");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test

    public void testMX() {
        LOG.info("Starting test ...");

        ButtonsPageBy btns = new ButtonsPageBy(driver);

        LoginPageBy loginpage = new LoginPageBy(driver).get();
        loginpage.LogInMX();

        DashBoardBy dashboardpage = new DashBoardBy(driver);
        dashboardpage.WaitForOPCButton();
        dashboardpage.ClickOPC();

        OrdersPageBy orderspage = new OrdersPageBy(driver);
        orderspage.WaitForRequestButton();
        orderspage.CheckHeaderAndButton();
        LOG.info("Click request");
        orderspage.ClickRequest();

        NewOrderPageBy neworderpage = new NewOrderPageBy(driver);
        neworderpage.WaitForButtons();
        neworderpage.MPClick();
        btns.NextBtnClick();
        btns.DeliveryClick();

        LocationPageBy locationpage = new LocationPageBy(driver);
        locationpage.FillJobsite();



    }

    /**@AfterTest
    public void tearDown() {
        driver.quit();
    }**/
}
