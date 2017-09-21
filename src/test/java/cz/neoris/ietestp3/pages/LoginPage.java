package cz.neoris.ietestp3.pages;

import cz.neoris.ietestp3.basic.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage implements Helper {

    WebDriver driver;
    By Username = By.name("username");
    By Pwd = By.name("password");
    By LoginBtn = By.xpath("//*[@id=\"app-content\"]/app-login/div/div/div[2]/button/span");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void InputLogin (String LoginName) {
        driver.findElement(Username).clear();
        driver.findElement(Username).sendKeys(LoginName);
    }

    public void InputPwd (String PassWord) {
        driver.findElement(Pwd).clear();
        driver.findElement(Pwd).sendKeys(PassWord);
    }

    public void ClickBtn() {
        driver.findElement(LoginBtn).click();
    }

    public void LoginToP3(String LoginName, String PassWord) {

        this.InputLogin(LoginName);
        this.InputPwd(PassWord);
        this.ClickBtn();

    }
}
