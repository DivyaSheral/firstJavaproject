import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Windowactivities {
    WebDriver driver;

    public Windowactivities() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.get("https://www.google.com");

    }

    @Test
    public void windowActivity1() {
        driver.navigate().to("https://rahulshettyacademy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().back();
        driver.navigate().forward();
        driver.manage().deleteAllCookies();

    }

    @Test
    public void multipleWindowsHandling() {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.className("blinkingText")).click();
        Set<String> totalwindows = driver.getWindowHandles();
        Iterator<String> it = totalwindows.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        String uid = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split(" ")[4];
        driver.switchTo().window(parent);
        driver.findElement(By.id("username")).sendKeys(uid);
    }
}