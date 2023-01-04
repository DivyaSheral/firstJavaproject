import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Alerts {

    WebDriver driver;
    WebDriverWait wait;
    public Alerts()
    {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

    }
    @Test(priority = 1)
    public void alert1()
    {

        driver.findElement(By.id("name")).sendKeys("Divya");
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText().split(",")[0].split(" ")[1]);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys("Dasari");
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();


       Alert alert = wait.until(ExpectedConditions.alertIsPresent());
       alert.sendKeys("Divya");

    }



}
