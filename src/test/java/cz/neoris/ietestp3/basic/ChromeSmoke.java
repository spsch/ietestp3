package cz.neoris.ietestp3.basic;

import cz.neoris.ietestp3.pages.DashBoardBy;
import cz.neoris.ietestp3.pages.LoginPageBy;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

public class ChromeSmoke implements Helper {

    WebDriver driver;

    private static final Logger LOG = Logger.getLogger(ChromeSmoke.class);

    @BeforeClass
    public void setUpClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeTest
    public void setUp() {
        LOG.debug("setup");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void testLoginMX() {
        LOG.debug("load page");
        LoginPageBy page = new LoginPageBy(driver).get();
        page.LogInCustom(Helper.USERNAME_MX);

        LOG.debug("load dashboard page");
        DashBoardBy dashboardpage = new DashBoardBy(driver);
        dashboardpage.WaitForOPCButton();
        dashboardpage.CheckOPFrameUS();
        dashboardpage.CheckOPCButton();
        dashboardpage.CheckLeftFrame();
        dashboardpage.ClickOPCUS();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
