import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://courses.rahulshettyacademy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//*[@class='theme-btn']")).click();
        driver.findElement(By.id("email")).sendKeys("DivyaSheral@gmail.com");
        //driver.findElement(By.id("password")).sendKeys("DivyaSheral");
        driver.findElement(By.className("password")).sendKeys("Divya");
        driver.findElement(By.xpath("//*[contains(@class,'btn-primary')]")).click();
        System.out.println(driver.findElement(By.cssSelector("span.text-with-icon")).getText());
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("input#email")).sendKeys("Divya@gmail.com");
        driver.findElement(By.cssSelector("input[value='Next']")).click();
        //    //div[@class='cart']/following-sibling::a[3]
        //    //a[@class='cart']/parent::div[@class='search']
        //
       // driver.close();
    }
}
