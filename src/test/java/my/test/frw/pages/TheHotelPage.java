package my.test.frw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TheHotelPage {
    WebDriver driver;
    By byHotelTitle=By.ByXPath.xpath("//h1[@class='title']");
    By byHotelLoc=By.ByXPath.xpath("//span[@class='location-name-container']");

    By byBookNowBtn= By.ByXPath.xpath("//button[@class='button is-success']");
    //Personal details popup
    By bySubmitBtn_onPopup= By.ByXPath.className("lead-modal-submit-button");
    By byFullNameTxt_onPopup = By.ByXPath.name("name");
    By byEmailTxt_onPopup = By.ByXPath.name("email");
    By byPhoneTxt_onPopup = By.ByXPath.name("phone");
    By byCountryDD_onpopup = By.ByXPath.xpath("//select[@class='input']");

    By byUniversityTxt_onPopup = By.ByXPath.name("university");
    By byNextBtn_onPopup= By.ByXPath.className("next-button");

    //dates checkin - out
    By byDateDD_onPopup = By.xpath("//option[text()='Day']/..");
    By byMonthDD_onPopup = By.xpath("//option[text()='Month']/..");
    By byYearDD_onPopup = By.xpath("//option[text()='Year']/..");
    By byDuration_onPopup = By.className("lease-duration");
    By byBudget_onPopup = By.className("no-of-students");
    By byAptType_onPopup = By.className("configuration");

    By byCompleteBookingBtn = By.xpath("//a[contains(text(),'Complete Booking')]");


    public TheHotelPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> readHotelDetails(){
        List<String> hotelProps=new ArrayList<String>();
        hotelProps.add(driver.findElement(byHotelTitle).getText());
        hotelProps.add(driver.findElement(byHotelLoc).getText());

        return hotelProps;
    }

    public CompleteBookingPage bookTheHotel(){
        driver.findElement(byBookNowBtn).click();

        //popup
        driver.findElement(byFullNameTxt_onPopup).sendKeys("abc");
        driver.findElement(byEmailTxt_onPopup).sendKeys("abc@xyz.com");
        driver.findElement(byPhoneTxt_onPopup).sendKeys("1234567890");
        driver.findElement(byCountryDD_onpopup).click();
        driver.findElement(By.xpath("//option[@value='+91']")).click();
        driver.findElement(bySubmitBtn_onPopup).click();

        //popup 1/7
        driver.findElement(byUniversityTxt_onPopup).sendKeys("MyUniversity");
        driver.findElement(byNextBtn_onPopup).click();

        //popup 2/7
        driver.findElement(byDateDD_onPopup).click();
        driver.findElement(By.xpath("//option[@value='10']")).click();
        driver.findElement(byMonthDD_onPopup).click();
        driver.findElement(By.xpath("//option[@value='June']")).click();
        driver.findElement(byYearDD_onPopup).click();
        driver.findElement(By.xpath("//option[@value='2023']")).click();
        driver.findElement(byNextBtn_onPopup).click();

        //popup 3/7
        driver.findElement(byDuration_onPopup).click();
        driver.findElement(By.xpath("//option[@value='8 - 12 weeks']")).click();
        driver.findElement(byNextBtn_onPopup).click();

        //popup 4/7
        driver.findElement(byNextBtn_onPopup).click();
        //popup 5/7
        driver.findElement(byBudget_onPopup).click();
        driver.findElement(By.xpath("//option[@value='90']")).click();
        driver.findElement(byNextBtn_onPopup).click();
        //popup 6/7
        driver.findElement(byAptType_onPopup).click();
        driver.findElement(By.xpath("//option[contains(@value,'Private room with shared bath')]")).click();
        driver.findElement(byNextBtn_onPopup).click();
        //popup 7/7
        driver.findElement(byNextBtn_onPopup).click();

        driver.findElement(byCompleteBookingBtn).click();

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        while (iterator.hasNext()){
            String iHandle=iterator.next();
            System.out.println("Window Handle : "+ iHandle );
            driver.switchTo().window(iHandle);
           if(driver.getTitle().contains("Booking Form")){
               System.out.println("Breaking for : " + driver.getTitle() );
                break;
            }
        }

        return new CompleteBookingPage(driver);
    }
}
