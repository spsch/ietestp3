package cz.neoris.ietestp3.basic;

import cz.neoris.ietestp3.pages.LoginPage;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestEdge implements Helper {
    WebDriver driver;
    LoginPage objLoginPage;

    @BeforeClass

    public void setUpClass() {
        EdgeDriverManager.getInstance().setup();
    }

    @BeforeTest

    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
    }

    @org.testng.annotations.Test
    public void testA_Login_MX() {
        objLoginPage = new LoginPage(driver);
        objLoginPage.LoginToP3(Helper.USERNAME_MX, Helper.PWD);
    }

    @Test
    public void testB_login_US() {
        objLoginPage = new LoginPage(driver);
        objLoginPage.LoginToP3(Helper.USERNAME_USA, Helper.PWD);
    }

    @AfterTest
    public void tearDownTest() {
        this.driver.close();
    }

    @AfterSuite
    public void tearDown() {
        this.driver.quit();
    }
}
