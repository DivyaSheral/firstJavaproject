import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //System.setProperty("webdriver.chrome.driver","C:/Users/divya/Divya'sJavaWorkspace/Drivers/chromedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.udemy.com");
        System.out.println("URL:" +driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.close();

    }
}