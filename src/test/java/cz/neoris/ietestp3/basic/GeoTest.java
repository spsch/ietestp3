package cz.neoris.ietestp3.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.util.Strings;

import java.util.HashMap;
import java.util.Map;

public class GeoTest {

    public static void main(String[] args) {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://uscldyndbq01.crm.dynamics.com/");
    }
}
