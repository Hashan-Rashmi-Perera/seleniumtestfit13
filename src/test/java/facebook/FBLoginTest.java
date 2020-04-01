package facebook;
import facebok.FBHomePage;
import facebok.FBLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.TestApp;


public class FBLoginTest {
    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();

        TestApp.getInstance().navigateToURL("https://www.facebook.com/");
    }
    @Test
    public void fbLoginTest() {
        FBLoginPage login = new FBLoginPage();
        FBHomePage homePage = login.loginSuccess("example@gmail.com", "password");
        //homePage.logout();
    }
    @AfterMethod
    public void cleanUp() {
       TestApp.getInstance().closeBrowser();
    }

}
