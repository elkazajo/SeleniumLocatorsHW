import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LetterPage;
import pages.MainPage;
import pages.LoginPage;
import utils.WebDriverCreator;

public class TestRunner {
    WebDriver driver;
    String userName = "selenium.tester";
    String userPassword = "PRARppro3*u3";
    String addressee = "selenium.tester@mail.ru";
    String subject = "Hello";
    String bodyText = "Hello World!";

    @Test
    public void tests() {
        WebDriverCreator webDriverCreator = new WebDriverCreator();
        driver = webDriverCreator.setDriver();
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        LetterPage letterPage = new LetterPage(driver);

        driver.get("https://mail.ru/");

        loginPage.inputUserName(userName).enterPasswordButton().inputPassword(userPassword).clickLoginButton();
        mainPage.clickToComposeLetter();
        letterPage.enterAddressee(addressee).enterSubject(subject).enterBodyText(bodyText).saveToDrafts();
    }
}
