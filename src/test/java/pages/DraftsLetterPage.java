package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DraftsLetterPage {
    WebDriver driver;

    String sendMailXpath = "//span[@tabindex=\"570\"]";
    String lastSavedXpath = "//span[@title=\"selenium.tester@mail.ru\"][1]";
    String addresseeCheckXpath = "//span[@class=\"text--1tHKB\"]";
    String sentButtonXpath = "//a[@href=\"/sent/\"]";
    String mailSentXpath = "//span[@class=\"ll-crpt\"]";

    public DraftsLetterPage(WebDriver driver) {
        this.driver = driver;
    }

    public DraftsLetterPage openLastSaved() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(lastSavedXpath)).click();
        return this;
    }

    public String verifyAddressee() {
        String addressee = driver.findElement(By.xpath(addresseeCheckXpath)).getText();
        return addressee;
    }

    public DraftsLetterPage sendMail() {
        driver.findElement(By.xpath(sendMailXpath)).click();
        return this;
    }

    public boolean verifyMailIsSent() {
        driver.findElement(By.xpath(sentButtonXpath)).click();
        WebElement lastSent = driver.findElement(By.xpath(mailSentXpath));
        return lastSent.isDisplayed();
    }
}
