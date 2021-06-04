package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;

public class MainPage {
    WebDriver driver;

    String composeLetter = "//a[@href=\"/compose/\"]";
    String addresseeInputXpath = "//input[@tabindex=\"100\"]";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage clickToComposeLetter() {
        try {
            new Waiters().waiterFor(driver, composeLetter);
            driver.findElement(By.xpath(composeLetter)).click();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            new Waiters().waiterFor(driver, composeLetter);
            driver.findElement(By.xpath(composeLetter)).click();
        }
        return this;
    }

    public boolean letterIsOpen() {
        WebElement addresseeInput;
        addresseeInput = driver.findElement(By.xpath(addresseeInputXpath));
        return addresseeInput.isDisplayed();
    }
}
