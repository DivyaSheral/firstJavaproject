import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Staticdrodowns {

    WebDriver driver;
    public Staticdrodowns()
    {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test(priority = 1)
    public void staticDropdown1()
    {
        Select currencyDropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        currencyDropdown.selectByIndex(3);
        System.out.println(currencyDropdown.getFirstSelectedOption().getText());
        currencyDropdown.selectByValue("INR");
        System.out.println(currencyDropdown.getFirstSelectedOption().getText());
        currencyDropdown.selectByVisibleText("AED");
        System.out.println(currencyDropdown.getFirstSelectedOption().getText());
    }
    @Test(priority = 2)
    public void staticDropdown2()
    {
        driver.findElement(By.id("divpaxinfo")).click();
        for(int i=1;i<5;i++)
        {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        driver.findElement(By.id("btnclosepaxoption")).click();
    }
}
