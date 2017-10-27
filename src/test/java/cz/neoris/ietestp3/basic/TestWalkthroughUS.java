package cz.neoris.ietestp3.basic;

import cz.neoris.ietestp3.pages.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

public class TestWalkthroughUS implements Helper {

    WebDriver driver;
    private static Logger LOG = Logger.getLogger(TestWalkthroughUS.class);


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

    public void testUS() {
        LOG.info("Starting test ...");

        ButtonsPageBy btns = new ButtonsPageBy(driver);

        LoginPageBy loginpage = new LoginPageBy(driver).get();
        loginpage.LogInUS();

        DashBoardBy dashboardpage = new DashBoardBy(driver);
        dashboardpage.WaitForOPCButton();
        dashboardpage.ClickOPCUS();

        OrdersPageBy orderspage = new OrdersPageBy(driver);
        orderspage.WaitForRequestButton();
        orderspage.CheckHeaderAndButton();
        LOG.info("Click request");
        orderspage.ClickRequest();

        NewOrderPageBy neworderpage = new NewOrderPageBy(driver);
        neworderpage.WaitForButtonUS();
        neworderpage.USRMXClick();
        btns.NextBtnClick();
    }

}
