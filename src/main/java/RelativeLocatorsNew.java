import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.IOException;
import java.time.Duration;



public class RelativeLocatorsNew {
    WebDriver driver;
    SoftAssert s;

    public RelativeLocatorsNew() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        s = new SoftAssert();
    }

    @Test(priority = 1)
    public void relativeLocators() throws IOException {
        //Above
        String text =driver.findElement(with(By.tagName("label")).above(By.cssSelector("[class='form-group'] [name='name']"))).getText();
        System.out.println(text);

        //Below
        driver.findElement(with(By.tagName("input")).below(By.xpath("//label[@for='dateofBirth']"))).click();

        //LeftOf
        driver.findElement(with(By.tagName("input")).toLeftOf(By.xpath("//label[text()='Check me out if you Love IceCreams!']"))).click();

        //rightOf
        String text1 =driver.findElement(with(By.tagName("label")).toRightOf(By.id("inlineRadio2"))).getText();
        System.out.println(text1);
    }

}
