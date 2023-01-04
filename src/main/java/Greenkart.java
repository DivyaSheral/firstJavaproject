import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Greenkart {

    WebDriver driver;
    WebDriverWait wwait;

    public Greenkart() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wwait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void addingToCart() throws InterruptedException {
        int i=0, j=0;
        List<WebElement> productNameList = driver.findElements(By.cssSelector("h4.product-name"));
        String[] products = {"Cucumber","Beetroot","Tomato","Potato"};

        for (j = 0; j < products.length; j++)
        {
            for (i = 0; i<productNameList.size(); i++) {
                String name = productNameList.get(i).getText();
                if (name.contains(products[j].toString())) {

                    driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
                    break;
                }
            }
        }
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        //explicit wait-Webdriver wait
        wwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        wwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
    }

    @Test
    public void trainerCode()
    {
        String[] products = {"Cucumber","Beetroot","Tomato","Potato","Strawberry"};
        addCart(driver, products);

    }

    public void addCart(WebDriver driver, String[] products)

    {

        int count = 0;
        List<WebElement> productNameList = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < productNameList.size(); i++) {

            for (int j = 0; j < products.length; j++)

                if (productNameList.get(i).getText().contains(products[j].toString())) {

                    count++;

                    driver.findElements(By.cssSelector("div.product-action")).get(i).click();

                    if (count == products.length)

                        break;

                }

        }

    }

}
