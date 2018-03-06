package cz.neoris.ietestp3.basic;

import cz.neoris.ietestp3.pages.LoginPageBy;
import cz.neoris.ietestp3.pages.OrdersPageBy;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

public class TestUploadDemandSchedule implements Helper {

    WebDriver driver;
    private static Logger LOG = Logger.getLogger(TestUploadDemandSchedule.class);


    @BeforeClass
    public void setUpClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeTest
    public void setUp() {
        LOG.debug("setup");
        driver = (WebDriver) new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void UploadFileLogin() {
        LOG.info("Starting test..");
        LoginPageBy loginpage = new LoginPageBy(driver).get();
        loginpage.LogInMX();
    }

    @Test
    public void UploadFile() {
        LOG.info("Start upload");
        OrdersPageBy ordersPageBy = new OrdersPageBy(driver).get();
        ordersPageBy.UploadFile();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
