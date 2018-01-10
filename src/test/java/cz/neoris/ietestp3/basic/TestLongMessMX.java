package cz.neoris.ietestp3.basic;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

public class TestLongMessMX implements Helper {

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
    public void testOneLongStep() {

        driver.get("https://uscldyndbq01.crm.dynamics.com/");
        /**login**/
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(1) > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(1) > input.form-control")).sendKeys(USERNAME_MX);
        /**password**/
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(3) > input.form-control")).clear();
        driver.findElement(By.cssSelector("div.form > div:nth-of-type(3) > input.form-control")).sendKeys(PWD);
        driver.findElement(By.cssSelector("button.button")).click();
        /**clicking on orders**/
        driver.findElement(By.cssSelector("div.row > div:nth-of-type(6) > a.card-container > div.box")).click();







    }

}
