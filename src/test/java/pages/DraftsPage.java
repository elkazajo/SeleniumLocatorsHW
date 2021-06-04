package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DraftsPage {
    WebDriver driver;

    String draftsXpath = "//a[@href=\"/drafts/\"]";
    String lastSavedXpath = "//span[@title=\"selenium.tester@mail.ru\"][1]";

    public DraftsPage(WebDriver driver) {
        this.driver = driver;
    }

    public DraftsPage openDrafts() {
        driver.findElement(By.xpath(draftsXpath)).click();
        return this;
    }

    public boolean isInDrafts() {
        WebElement mailInDrafts = driver.findElement(By.xpath(lastSavedXpath));
        return mailInDrafts.isDisplayed();
    }
}
