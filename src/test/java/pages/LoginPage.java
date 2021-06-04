package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;

    String loginInputForm = "//input[@name=\"login\"]";
    String loginButton = "//button[@data-testid=\"enter-password\"]";
    String passwordInputForm = "//input[@data-testid=\"password-input\"]";
    String enterButton = "//button[@data-testid=\"login-to-mail\"]";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage inputUserName(String userName) {
        driver.findElement(By.xpath(loginInputForm)).sendKeys(userName);
        return this;
    }

    public LoginPage enterPasswordButton() {
        driver.findElement(By.xpath(loginButton)).click();
        return this;
    }

    public LoginPage inputPassword(String userPassword) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(passwordInputForm)).sendKeys(userPassword);
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(By.xpath(enterButton)).click();
        return this;
    }

    public boolean verifyLoginSuccess() {
        WebElement button = driver.findElement(By.xpath(enterButton));
        return button.isDisplayed();
    }
}
