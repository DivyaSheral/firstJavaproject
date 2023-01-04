import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChromeptionsSettings {
    WebDriver driver;
    @Test
    public void handlingHTTPCertificates()
    {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com");
        Assert.assertEquals(driver.getTitle(),"expired.badssl.com");
    }
    public void proxySettings() {
        ChromeOptions options = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipadress:726537");
        options.setCapability("Proxy", proxy);

    }

}
