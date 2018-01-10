package cz.neoris.ietestp3.basic;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.misc.BASE64Decoder;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static javax.swing.text.html.CSS.getAttribute;

public class TestGetResolution implements Helper {

    WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeTest
    public void setUp() {

        /**for linux systems uncomment**/
        /**System.setProperty("webdriver.chrome.driver", "/home/test/scripts/chromedriver/chromedriver");**/

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

    @Test
    public void testGetAllElemenets() {
        driver.get(BASEPRODURL);
        List<WebElement> allElems = driver.findElements(By.xpath("//*[contains(@id, '')]"));
        Iterator<WebElement> iterator = allElems.iterator();

        while (iterator.hasNext()) {
            /**System.out.println(iterator.next().getAttribute("ngcontent-c4"));**/
            /**String values = iterator.next().getText();**/

            /**if(!values.equals("null"))
            {
                System.out.println(values);
            }**/
            WebElement ele = iterator.next();
            if (ele.isDisplayed() && ele.isEnabled()) {
                System.out.println("EL: " + ele.getText() + ele.getCssValue("value"));
            }
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
