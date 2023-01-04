import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Endtoendflightbooking {

    WebDriver driver;
    public Endtoendflightbooking()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test(priority = 1)
    public void flightBooking()
    {
        driver.findElement(By.xpath("//input[@value='OneWay']")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("(//a[@value='DEL'])[1]")).click();
        driver.findElement(By.xpath("(//a[@value='JSA'])[2]")).click();
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).isSelected());
        driver.findElement(By.id("divpaxinfo")).click();
        for(int i=1;i<5;i++)
        {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        driver.findElement(By.id("btnclosepaxoption")).click();
        Select currencyDropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        currencyDropdown.selectByIndex(3);
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();

    }
}
