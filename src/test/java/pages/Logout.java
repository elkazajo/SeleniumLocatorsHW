package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {
    WebDriver driver;

    String dropdown = "//div[@aria-label=\"selenium.tester@mail.ru\"]";
    String logoutButton = "//a[@href=\"//auth.mail.ru/cgi-bin/logout?next=1&lang=ru_RU&page=https%3A%2F%2Fmail.ru%2F%3Ffrom%3Dlogout\"]";
    String loginInputForm = "//input[@name=\"login\"]";

    public Logout(WebDriver driver) {
        this.driver = driver;
    }

    public Logout pressDropdown() {
        driver.findElement(By.xpath(dropdown)).click();
        return this;
    }

    public Logout pressLogout() {
        driver.findElement(By.xpath(logoutButton)).click();
        return this;
    }

    public boolean isLogout() {
        WebElement loginForm = driver.findElement(By.xpath(loginInputForm));
        return loginForm.isDisplayed();
    }


}
