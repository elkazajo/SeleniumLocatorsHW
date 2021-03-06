package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Waiters;

import java.util.concurrent.TimeUnit;

public class LetterPage {
    WebDriver driver;

    String addresseeInputXpath = "//input[@tabindex=\"100\"]";
    String subjectXpath = "//input[@tabindex=\"400\"]";
    String bodyXpath = "//div[@tabindex=\"505\"]";
    String saveButtonXpath = "//span[@tabindex=\"580\"]";
    String closeButtonXpath = "//button[@tabindex=\"700\"]";
    String lastSavedXpath = "//span[@title=\"selenium.tester@mail.ru\"][1]";

    public LetterPage(WebDriver driver) {
        this.driver = driver;
    }

    public LetterPage enterAddressee(String addressee) {
        WebElement email = new Waiters().waiterFor(driver, addresseeInputXpath);
        email.sendKeys(addressee);
        return this;
    }

    public LetterPage enterSubject(String subject) {
        driver.findElement(By.xpath(subjectXpath)).sendKeys(subject);
        return this;
    }

    public LetterPage enterBodyText(String bodyText) {
        driver.findElement(By.xpath(bodyXpath)).sendKeys(bodyText);
        return this;
    }

    public LetterPage saveToDrafts() {
        driver.findElement(By.xpath(saveButtonXpath)).click();
        return this;
    }

    public LetterPage closeLetterPage() {
        driver.findElement(By.xpath(closeButtonXpath)).click();
        return this;
    }

    public boolean isStillOpen() {
        WebElement closeButton = driver.findElement(By.xpath(closeButtonXpath));
        return closeButton.isDisplayed();
    }
}
