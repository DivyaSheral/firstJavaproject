import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Checkboxes {
    WebDriver driver;
    public Checkboxes()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test(priority = 1)
    public void checkbox1()
    {
        int totalcheckboxes = driver.findElements(By.xpath(" //input[@type='checkbox']")).size();
        List<WebElement> names =driver.findElements(By.xpath(" //input[@type='checkbox']"));
        
        System.out.println(totalcheckboxes);

        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());

		/*
		 * driver.findElement(By.id("one")).sendKeys(Keys.chord(Keys.ALT,Keys.SHIFT,"s")
		 * ); Actions a = new Actions(driver);
		 * a.keyDown(Keys.ALT).keyDown(Keys.SHIFT).sendKeys("s").keyUp(Keys.SHIFT).keyUp
		 * (Keys.ALT).build();
		 */
        /*for(int i=1;i<totalcheckboxes;i++)
        {
            System.out.println(names.get(i).getText());
            if(names.get(i).getText().equalsIgnoreCase("Senior Citizen"))
            {
                names.get(i).click();
                Assert.assertTrue(names.get(i).isSelected());
                break;

            }
           break;
        }*/
    }

    @Test
    public void calenderDropdown()
    {
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']")).click();
    }

    @Test
    public void radioButton()
    {
        driver.findElement(By.xpath("//input[@value='RoundTrip']")).click();
       // Assert.assertTrue(driver.findElement(By.xpath("//input[@value='RoundTrip']")).isSelected());
       // Assert.assertFalse(driver.findElement(By.xpath("//input[@value='OneWay']")).isSelected());
        if(driver.findElement(By.xpath("//input[@value='RoundTrip']")).isSelected())
        {
            Assert.assertFalse(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).isSelected());
        }

    }
}
