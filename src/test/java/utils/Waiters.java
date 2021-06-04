package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    public WebElement waiterFor(WebDriver driver, String xpath) {
        return new WebDriverWait(driver, 20).pollingEvery(Duration.ofSeconds(500)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }
}
