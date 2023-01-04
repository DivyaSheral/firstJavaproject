import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Dynamicdropdowns {
    WebDriver driver;
    public Dynamicdropdowns()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test(priority = 1)
    public void dynamicDropdownWithIndex()
    {
       driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
       driver.findElement(By.xpath("(//a[@value='DEL'])[1]")).click();
       driver.findElement(By.xpath("(//a[@value='JSA'])[2]")).click();
    }

    @Test(priority = 1)
    public void dynamicDropdownWithParentChildRelationship()
    {
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='JSA']")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CCU']")).click();
    }
    @Test
    public void autoSuggestiveDropdowns()
    {
        driver.findElement(By.id("autosuggest")).sendKeys("us");
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for(WebElement option:options)
        {
            if(option.getText().equalsIgnoreCase("cyprus"))
            {
                option.click();
                break;
            }
        }

    }



}
