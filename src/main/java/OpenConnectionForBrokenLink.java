import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class OpenConnectionForBrokenLink {
    WebDriver driver;
    SoftAssert s;

    public OpenConnectionForBrokenLink() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        s = new SoftAssert();
    }

    @Test(priority = 1)
    public void brokenLinksCheck() throws IOException {
        String urllink;
        List<WebElement> Alllinks = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
        for(WebElement link : Alllinks)
        {
            urllink= link.getAttribute("href");
            URL url = new URL(urllink);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = (conn.getResponseCode());
            System.out.println(link.getText()+" ::"+respCode);
            //softAssert will not stop the execution if in the middle something is broken . it will throw exception after executing all the links
            s.assertTrue(respCode<400,"The Link with text "+link.getText()+"is broken with status code"+respCode);
        }
        s.assertAll();
    }
}
