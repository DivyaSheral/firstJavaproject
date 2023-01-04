import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ScrollingWithJavascriptEditor {

    WebDriver driver;

    public ScrollingWithJavascriptEditor() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void windowAndComponentScrolling() {
      // scrolling the window can be done using Actions but scrolling the component cannot be done
        /* Actions action = new Actions(driver);
        action.scrollByAmount(0,600).build().perform();*/
        JavascriptExecutor js =  (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=2000");
        int sum=0;
        List<WebElement> amounts = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
        for(int i=0;i< amounts.size();i++)
        {
            sum = sum + Integer.parseInt(amounts.get(i).getText());
        }
        System.out.println("Sum ="+sum);
        int ActualSum = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(" ")[3].trim());
        Assert.assertEquals(ActualSum,sum);
    }

    @Test(priority = 1)
    public void tableValueSumAssignment() {
        Actions action = new Actions(driver);
        action.scrollToElement(driver.findElement(By.id("product"))).build().perform();
        //System.out.println(driver.findElement(By.id("product")).getAttribute("name"));
        int sum=0;
        List<WebElement> firstcol = driver.findElements(By.xpath("//table[@id='product']//td[1]"));
        for(int i=0;i<firstcol.size();i++)
        {
            if(firstcol.get(i).getText().contains("Rahul Shetty"))
            {
                sum= sum + Integer.parseInt(driver.findElements(By.xpath("//table[@id='product']//td[3]")).get(i).getText());
            }
        }
        System.out.println("Sum :" +sum);

    }
}