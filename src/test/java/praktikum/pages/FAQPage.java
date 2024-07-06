package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FAQPage {
    private final WebDriver driver;

    public FAQPage(WebDriver driver) {

        this.driver = driver;
    }


    public String getActualText(String answerId) {
        String actualText = driver.findElement(By.id("accordion__panel-" + answerId)).getText();
        return actualText;
    }

    public void getAnswer(String answerId) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-" + answerId))).click();
    }

    public void clickOnQuestion(String questionId) {
        WebElement element = driver.findElement(By.id("accordion__heading-" + questionId));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-" + questionId))).click();
    }

}

