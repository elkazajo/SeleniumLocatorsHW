package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;

    String composeLetter = "//a[@href=\"/compose/\"]";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage clickToComposeLetter() {
        try {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.xpath(composeLetter)).click();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath(composeLetter)).click();
        }
        return this;
    }

}
