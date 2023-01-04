import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {

    WebDriver driver;
    Actions action;

    public Frames() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(" https://jqueryui.com/droppable/");

    }

    @Test
    public void framehandling() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        //we can use frame index as wwell
        //driver.switchTo().frame(0);
        int framecount = driver.findElements(By.tagName("iframe")).size();
        System.out.println("framecount:"+framecount);
        action = new Actions(driver);
        action.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable")))
                .build().perform();

        driver.switchTo().window(driver.getWindowHandle());

    }

}
