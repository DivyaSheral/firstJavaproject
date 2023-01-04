import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ActionsClass {
    WebDriver driver;
    Actions action;
    public ActionsClass()
    {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(priority = 1)
    public void mouseActions() {
        action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-accountList")))
                .moveToElement(driver.findElement(By.xpath("//span[text()='Kindle Unlimited']")))
                .build().perform();

    }
    @Test(priority = 2)
    public void KeyboardActions() {
        action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
                .click().keyDown(Keys.SHIFT).sendKeys("time")
                .moveToElement(driver.findElement(By.linkText("Epic Deals"))).contextClick()
                .build().perform();



        /*List<WebElement> options = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']//div[@class='s-suggestion-container']//div"));
        for(WebElement myselection :options)
        {
            System.out.println(myselection.getText());
            if(myselection.getText().equalsIgnoreCase("timex"))
            {
                myselection.click();
                break;
            }
        }*/


       /* for(int i=0;i< options.size();i++)
        {
            String name =options.get(i).getText();
            if(name.equalsIgnoreCase("timex"))
            {
                options.get(i).click();
                break;
            }
        }*/
    }
}
