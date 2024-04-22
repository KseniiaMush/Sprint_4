package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentPage {
    private final WebDriver driver;

    public RentPage (WebDriver driver) {
        this.driver = driver;

    }

    public void postRentSettings(String date, String daysCount, String colour, String comment) {
        driver.findElement(By.xpath(".//input[@placeholder = '* Когда привезти самокат']")).click();
        driver.findElement(By.xpath(date)).click();
        driver.findElement(By.className("Dropdown-placeholder")).click();
        driver.findElement(By.xpath(daysCount)).click();
        driver.findElement(By.id(colour)).click();
        driver.findElement(By.xpath(".//input[@placeholder = 'Комментарий для курьера']")).sendKeys(comment);
    }

    public void clickOnSecondOrderButton() {
        driver.findElement(By.xpath("//button[2][text() = 'Заказать']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Хотите оформить заказ?']")));
    }
}

