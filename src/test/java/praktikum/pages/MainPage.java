package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;

    }

    public void openMainPage () {
        driver.get("https://qa-scooter.praktikum-services.ru");

        driver.findElement(By.className("App_CookieButton__3cvqF")).click();

    }
    public void clickOnOrderButton(String orderButtonLocator) {
        driver.findElement(By.xpath(orderButtonLocator)).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
    }
}

