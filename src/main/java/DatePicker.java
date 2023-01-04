import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DatePicker {
    WebDriver driver;
    WebDriverWait wait;
    public DatePicker()
    {
        driver = new ChromeDriver();
        driver.get("https://www.travelocity.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @Test(priority = 1)
    public void dynamicDatePickerFunction() {
        driver.findElement(By.xpath("//button[@id='d1-btn']")).click();
        List<WebElement> monthNames = driver.findElements(By.xpath("//h2[@class='uitk-date-picker-month-name uitk-type-medium']"));
        List<WebElement> allDates =null;
        String monthToBeSelected="May" ,dateTobeSelected="15";
        String name = "Jan";
        while (!name.contains(monthToBeSelected)) {
            if (driver.findElements(By.xpath("//h2[@class='uitk-date-picker-month-name uitk-type-medium']")).get(0).getText().contains(monthToBeSelected) || driver.findElements(By.xpath("//h2[@class='uitk-date-picker-month-name uitk-type-medium']")).get(1).getText().contains(monthToBeSelected)) {
                if (driver.findElements(By.xpath("//h2[@class='uitk-date-picker-month-name uitk-type-medium']")).get(0).getText().contains(monthToBeSelected)) {
                    allDates = driver.findElements(By.xpath("//div[@class='uitk-date-picker-month'][1]//button[@class='uitk-date-picker-day']"));
                    name = monthToBeSelected;
                } else if (driver.findElements(By.xpath("//h2[@class='uitk-date-picker-month-name uitk-type-medium']")).get(1).getText().contains(monthToBeSelected)) {
                    allDates = driver.findElements(By.xpath("//div[@class='uitk-date-picker-month'][2]//button[@class='uitk-date-picker-day']"));
                    name = monthToBeSelected;
                }
            } else {
                driver.findElement(By.xpath("//div[@class='uitk-calendar']//button[2]")).click();
            }
        }
        for(WebElement mydate:allDates)
        {
            if(mydate.getAttribute("data-day").contains(dateTobeSelected))
            {
                mydate.click();
                driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).click();
            }
        }
    }

}
