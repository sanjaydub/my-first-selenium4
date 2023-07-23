package my.test.frw.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CompleteBookingPage {
    WebDriver driver;
    By byLastNameText = By.id("last_3");
    By byDOBText = By.id("lite_mode_4");
    By byGenderMaleRad = By.xpath("//input[@type='radio'][@value='Male']");
    By byGenderFemaleRad = By.xpath("//input[@type='radio'][@value='Female']");
    By byGenderOtherRad = By.xpath("//input[@type='radio'][@value='Other']");
    By byNationalityTxt = By.name("q22_nationality");
    By byHomeAdd1Txt = By.id("input_24_addr_line1");
    By byCityTxt = By.id("input_24_city");
    By byStateTxt = By.id("input_24_state");
    By byZipTxt = By.id("input_24_postal");
    By byEnrollStatusDD = By.name("q23_enrolmentStatus");
    By byNextBtn = By.id("form-pagebreak-next_70");

    public CompleteBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        System.out.println("Filling form for : " + driver.getTitle() );
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Form']")));
        driver.findElement(byLastNameText).sendKeys("last");
        driver.findElement(byDOBText).sendKeys("11062001");
        driver.findElement(byLastNameText).click();
        Actions act=new Actions(driver);
        //act.scrollToElement(driver.findElement(byGenderMaleRad)).build().perform();
        WebElement rad = driver.findElement(byGenderMaleRad);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementById('label_input_5_1').click();", rad);
        driver.findElement(byNationalityTxt).sendKeys("Mars");
        driver.findElement(byHomeAdd1Txt).sendKeys("abc xyz");
        driver.findElement(byCityTxt).sendKeys("city");
        driver.findElement(byStateTxt).sendKeys("state");
        driver.findElement(byZipTxt).sendKeys("75038");

        //act.scrollToElement(driver.findElement(byEnrollStatusDD)).build().perform();
        driver.findElement(byEnrollStatusDD).click();
        driver.findElement(By.xpath("//option[@value='Other']")).click();
        driver.findElement(byNextBtn).click();
    }

    public void fillEmergencyContact(){
        driver.findElement(By.id("input_27")).sendKeys("Emer Name");
        driver.findElement(By.id("input_28")).sendKeys("0987654321");
        driver.findElement(By.id("input_29")).sendKeys("xyz@abc.com");
        driver.findElement(By.id("input_49")).sendKeys("friend");
        driver.findElement(By.id("lite_mode_64")).sendKeys("10102001");
        driver.findElement(By.id("input_27")).click();

        driver.findElement(By.id("label_input_84_0")).click();
        driver.findElement(By.id("form-pagebreak-next_71")).click();

        driver.findElement(By.id("label_input_56_0")).click();
        driver.findElement(By.id("form-pagebreak-next_72")).click();

        driver.findElement(By.id("label_input_45_1")).click();
        driver.findElement(By.id("input_2")).click();

    }
}
