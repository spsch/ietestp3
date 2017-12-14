package cz.neoris.ietestp3.basic;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestMartinCase {

    WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginPageMartin() {

        final String MURL = "https://uscldyndbq01.crm.dynamics.com/";
        final String MSSRACKA = "https://login.microsoftonline.com";
        final String MUSER = "crmusany08sr@cemex.onmicrosoft.com";
        final String MPWD = "2017Pr4gu3";

        driver.get(MSSRACKA);
        PageFactory.initElements(driver, this);

        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement Username = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#i0116")));
        Username.clear();
        Username.sendKeys(MUSER);

        WebElement NextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#idSIButton9")));
        NextButton.click();

        WebElement PWdField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#i0118")));
        PWdField.sendKeys(MPWD);

        WebElement SignInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#idSIButton9")));
        SignInBtn.click();


    }
}
