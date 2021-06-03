package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;

public class LetterPage {
    WebDriver driver;

    String addresseeInputXpath = "//input[@tabindex=\"100\"]";
    String subjectXpath = "//input[@tabindex=\"400\"]";
    String bodyXpath = "//div[@tabindex=\"505\"]";
    String saveButtonXpath = "//span[@tabindex=\"580\"]";

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
}
