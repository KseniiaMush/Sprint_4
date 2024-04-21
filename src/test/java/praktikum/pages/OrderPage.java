package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;

    }

    public void postOrderSettings(String name, String surname, String address, String metro, String phone) {
        driver.findElement(By.xpath(".//input[@placeholder = '* Имя']")).sendKeys(name);
        driver.findElement(By.xpath(".//input[@placeholder = '* Фамилия']")).sendKeys(surname);
        driver.findElement(By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']")).sendKeys(address);
        driver.findElement(By.className("select-search__value")).click();
        driver.findElement(By.xpath(metro)).click();
        driver.findElement(By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']")).sendKeys(phone);
    }

    public void clickOnNextButton() {
        driver.findElement(By.xpath("//button[text() = 'Далее']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
    }
}
