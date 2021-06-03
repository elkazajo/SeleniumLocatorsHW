package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waiters;

import java.util.concurrent.TimeUnit;

public class Drafts {
    WebDriver driver;

    String draftsXpath = "//a[@href=\"/drafts/\"]";
    String lastSavedXapth = "//span[@title=\"selenium.tester@mail.ru\"][1]";

    public Drafts(WebDriver driver) {
        this.driver = driver;
    }

    public Drafts openDrafts() {
        driver.findElement(By.xpath(draftsXpath)).click();
        return this;
    }

    public Drafts openLastSaved() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(lastSavedXapth)).click();
        return this;
    }
}
