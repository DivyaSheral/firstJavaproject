import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MiscellenousTopics {
    WebDriver driver;
    public MiscellenousTopics()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test(priority = 1)
    public void printLinks() {
        //all the links on the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        //links on just the footer
        System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size());
    }

    @Test(priority = 1)
    public void makingSubsetOfDriver() {
        //the driver scope is reduced to just footer instead of whole page
        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        System.out.println("footerdriver"+footerdriver.findElements(By.tagName("a")).size());

        //the footerDriver is further limited to first column links
        WebElement firstColumnlinkDriver = footerdriver.findElement(By.xpath("//div[@id='gf-BIG']//tr//td[1]/ul"));
        System.out.println("firstColumnlinkDriver"+firstColumnlinkDriver.findElements(By.tagName("a")).size());


        ////open all the links in new windows
        List<WebElement> Links = firstColumnlinkDriver.findElements(By.tagName("a"));
        for(int i=1;i< Links.size();i++)
        {
            Links.get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
        }
        Set<String> allwindows = driver.getWindowHandles();
        ///grab the title of each page
        Iterator<String> it = allwindows.iterator();
        while(it.hasNext())
        {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }


    }



}
