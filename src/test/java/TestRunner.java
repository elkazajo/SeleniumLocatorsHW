import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.LoginPage;
import utils.WebDriverCreator;

public class TestRunner {
    WebDriver driver;
    String userName = "selenium.tester";
    String userPassword = "PRARppro3*u3";

    @Test
    public void tests() {
        WebDriverCreator webDriverCreator = new WebDriverCreator();
        driver = webDriverCreator.setDriver();
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        driver.get("https://mail.ru/");

        loginPage.inputUserName(userName).enterPasswordButton().inputPassword(userPassword).clickLoginButton();
        mainPage.clickToComposeLetter();
    }
}
