package cz.neoris.ietestp3.basic;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestGetResolution {

    WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Window height: " + driver.manage().window().getSize().getHeight());
        System.out.println("Window width: " + driver.manage().window().getSize().getWidth());
    }

    @Test
    public void test() {
        System.out.println("Window height: " + driver.manage().window().getSize().getHeight());
        System.out.println("Window width: " + driver.manage().window().getSize().getWidth());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
