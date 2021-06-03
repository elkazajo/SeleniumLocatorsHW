package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DraftsLetterPage {
    WebDriver driver;

    String sendMailXpath = "//span[@tabindex=\"570\"]";

    public DraftsLetterPage(WebDriver driver) {
        this.driver = driver;
    }

    public DraftsLetterPage sendMail() {
        driver.findElement(By.xpath(sendMailXpath)).click();
        return this;
    }
}
