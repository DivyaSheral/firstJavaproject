import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class ExplicitWait {

    WebDriver driver;
    WebDriverWait wwait;
    Wait fwait;

    public ExplicitWait() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        wwait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void webDriverWait() {
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        wwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4[text()='Hello World!']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='finish']//h4[text()='Hello World!']")).isDisplayed());
    }

    @Test
    public void fluentWait() {
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        fwait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.xpath("//div[@id='finish']//h4[text()='Hello World!']")).isDisplayed()) {
                    return driver.findElement(By.xpath("//div[@id='finish']//h4[text()='Hello World!']"));
                } else
                    return null;
            }
        });


    }
}
