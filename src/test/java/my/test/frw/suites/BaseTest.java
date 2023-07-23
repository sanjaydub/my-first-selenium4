package my.test.frw.suites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void openApplication(){
        System.out.println(System.getProperty("user.dir") + File.separator+"chromedriver");
//        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + File.separator+ "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
         driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://amberstudent.com/");
    }

    @AfterMethod
    public void closeApplication(){
        driver.quit();
    }
}
