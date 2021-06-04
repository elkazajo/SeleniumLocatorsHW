import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.WebDriverCreator;

public class TestRunner {
    String userName = "selenium.tester";
    String userPassword = "PRARppro3*u3";
    String addressee = "selenium.tester@mail.ru";
    String subject = "Hello";
    String bodyText = "Hello World!";

    WebDriverCreator webDriverCreator;
    WebDriver driver;
    SoftAssert softAssert;
    LoginPage loginPage;
    MainPage mainPage;
    LetterPage letterPage;
    DraftsPage draftsPage;
    DraftsLetterPage draftsLetterPage;
    Logout logout;

    @BeforeClass
    public void instanceCreator() {
        webDriverCreator = new WebDriverCreator();
        driver = webDriverCreator.setDriver();
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        letterPage = new LetterPage(driver);
        draftsPage = new DraftsPage(driver);
        draftsLetterPage = new DraftsLetterPage(driver);
        logout = new Logout(driver);
    }

    @Test(priority = 1)
    public void loginSuccessAssert() {
        driver.get("https://mail.ru/");
        driver.manage().window().fullscreen();

        loginPage.inputUserName(userName)
                .enterPasswordButton()
                .inputPassword(userPassword)
                .clickLoginButton();
        softAssert.assertFalse(loginPage.verifyLoginSuccess());
    }

    @Test (priority = 2)
    public void composeLetterButtonAssert() {
        mainPage.clickToComposeLetter();
        softAssert.assertTrue(mainPage.letterIsOpen());
    }

    @Test (priority = 3)
    public void mailCreationAssert() {
        letterPage.enterAddressee(addressee)
                .enterSubject(subject)
                .enterBodyText(bodyText)
                .saveToDrafts()
                .closeLetterPage();
        softAssert.assertFalse(letterPage.isStillOpen());
    }

    @Test (priority = 4)
    public void mailInDraftsAssert() {
        draftsPage.openDrafts();
        softAssert.assertTrue(draftsPage.isInDrafts());
    }

    @Test (priority = 5)
    public void mailSentAssert() {
        draftsLetterPage.openLastSaved();
        softAssert.assertEquals(draftsLetterPage.verifyAddressee(), addressee);

        draftsLetterPage.sendMail();
        draftsLetterPage.verifyMailIsSent();
    }

    @Test (priority = 6)
    public void logoutSuccessAssert() {
        logout.pressDropdown().pressLogout();
        softAssert.assertTrue(logout.isLogout());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
