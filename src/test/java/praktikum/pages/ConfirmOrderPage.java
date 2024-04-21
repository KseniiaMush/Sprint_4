package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmOrderPage {
    private final WebDriver driver;

    public ConfirmOrderPage (WebDriver driver) {
        this.driver = driver;

    }

    public void confirmOrder() {
        driver.findElement(By.xpath("//button[2][text() = 'Да']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Заказ оформлен']")));
    }
}
