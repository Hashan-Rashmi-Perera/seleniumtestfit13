package facebok;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.TestApp;
import utils.PropertyFileReader;

public class FBLoginPage {
    WebDriver driver = TestApp.getInstance().getDriver();
    PropertyFileReader prop = new PropertyFileReader();
    String userNameID = prop.getProperty("FBHomePage.properties", "user.name.element");
    String passwordID = prop.getProperty("FBLoginPage.properties", "password.element");
    String loginButtonID = prop.getProperty("FBLoginPage.properties", "login.button.element");

    private void loginAs(String userName, String password) {
        driver.findElement(By.id(userNameID)).sendKeys(userName);
        driver.findElement(By.id(passwordID)).sendKeys(password);
        driver.findElement(By.id(loginButtonID)).click();
    }

    public FBHomePage loginSuccess(String userName, String password) {
        loginAs(userName, password);
        return new FBHomePage();
    }

    public FBReAttemptPage loginUnSuccess(String userName, String password) {
        loginAs(userName, password);
        return new FBReAttemptPage();
    }
}
