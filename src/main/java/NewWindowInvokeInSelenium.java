import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class NewWindowInvokeInSelenium {
    WebDriver driver;
    SoftAssert s;

    public NewWindowInvokeInSelenium() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        s = new SoftAssert();
    }

    @Test(priority = 1)
    public void newWindowInvokationPartialScreenshot() throws IOException {
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String[] winHandles = new String[10];

        for(int i=0;i< handles.size();i++)
        {
            if(it.hasNext())
            winHandles[i]=it.next();
            System.out.println(i+"::" +winHandles[i]);
        }
        driver.switchTo().window(winHandles[1]);
        driver.get("https://rahulshettyacademy.com/");
        List<WebElement> c = driver.findElements(By.xpath("//div[@id='courses-block']//h2/a[contains(@href,'https://courses.rahulshettyacademy.com/p')]"));
        System.out.println("Count :: "+c.size());
        String courseName= c.get(0).getText();
        driver.switchTo().window(winHandles[0]);
        WebElement name = driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']"));
        name.sendKeys(courseName);

        //component screenshot
        File src = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\divya\\name.png"));

        //getting weight and weight of a component
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        }

}
