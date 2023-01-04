import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment {
    WebDriver driver;
    public Assignment()
    {
        //System.setProperty("webdriver.chrome.driver","");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }
    @Test
    public void AssignmentLogic()
    {
        //1)check box is selected
        driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
        //2)Label saved in variable
        String text = driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).getAttribute("name").split("x")[1];
        //3)dropdown option selected based on the text from the label
        driver.findElement(By.id("dropdown-class-example")).click();
        Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
        s.selectByVisibleText(text);
        //4)same label is enetered in the textbox
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();
        //5)got the text from the alertbox
        String alertText = driver.switchTo().alert().getText();
        //6)checked if the alert text contains the label value
        Assert.assertTrue(alertText.contains(text));

    }
}
