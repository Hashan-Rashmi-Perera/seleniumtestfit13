package facebok;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.TestApp;
import utils.PropertyFileReader;

public class FBHomePage {
    WebDriver driver = TestApp.getInstance().getDriver();
    PropertyFileReader prop = new PropertyFileReader();
    String navigationMenuID = prop.getProperty("FBHomePage.properties",
            "navigation.menu.element");
    String logoutButtonID = prop.getProperty("FBHomePage.properties",
            "logout.button.element");

    public FBLoginPage logout() {
        driver.findElement(By.id(navigationMenuID)).click();
        waitUntilElementAppears(logoutButtonID);
        driver.findElement(By.linkText(logoutButtonID)).click();
        return new FBLoginPage();
    }

    private void waitUntilElementAppears(String elementName) {
        WebDriverWait wait = new WebDriverWait(TestApp.getInstance().getDriver(), 20);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(elementName)));
    }
}
