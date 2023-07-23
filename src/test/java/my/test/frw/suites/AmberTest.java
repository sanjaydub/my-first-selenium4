package my.test.frw.suites;

import my.test.frw.pages.CompleteBookingPage;
import my.test.frw.pages.HomePage;
import my.test.frw.pages.HotelsListPage;
import my.test.frw.pages.TheHotelPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Timer;

public class AmberTest extends BaseTest{

    @Test(priority = 2,enabled = true)
    public void testTask(){
        HomePage homePage=new HomePage(driver);

        HotelsListPage londonHotelsPage = homePage.searchCity("London");
        //Selecting room type and shareing type filters
        londonHotelsPage.selectRoomType("Private");
        londonHotelsPage.selectSharingType("Bathroom");

        //Reading 2nd hotel details before selecting it
        List<String> expHotelProps = londonHotelsPage.readNthPropertyDetails(4);

        //selecting 4 hotel in the list
        TheHotelPage theHotelPage = londonHotelsPage.selectNthHotel(4);
        List<String> actHotelProps =theHotelPage.readHotelDetails();

        Assert.assertEquals(actHotelProps.get(0),expHotelProps.get(0),
                "Assert Failed : expected["+expHotelProps.get(0)+"] but actual["+actHotelProps.get(0)+"]");

        Assert.assertTrue(actHotelProps.get(1).contains(expHotelProps.get(1)),
                "Assert Failed : expected["+expHotelProps.get(1)+"] but actual["+actHotelProps.get(1)+"]" );

        driver.close();

    }
    @Test(priority = 3,enabled = true)
    public void testBonusTask1(){
        HomePage homePage=new HomePage(driver);

        HotelsListPage londonHotelsPage = homePage.searchCity("Brooklyn");
        //Selecting room type and shareing type filters
        londonHotelsPage.selectRoomType("Entire");
        londonHotelsPage.selectSharingType("kitchen");

        //Reading 2nd hotel details before selecting it
        List<String> expHotelProps = londonHotelsPage.readNthPropertyDetails(2);

        //selecting 2nd hotel in the list
        TheHotelPage theHotelPage = londonHotelsPage.selectNthHotel(2);
        List<String> actHotelProps =theHotelPage.readHotelDetails();

        Assert.assertEquals(actHotelProps.get(0),expHotelProps.get(0),
                "Assert Failed : expected["+expHotelProps.get(0)+"] but actual["+actHotelProps.get(0)+"]");

        Assert.assertTrue(actHotelProps.get(1).contains(expHotelProps.get(1)),
                "Assert Failed : expected["+expHotelProps.get(1)+"] but actual["+actHotelProps.get(1)+"]" );

        driver.close();

    }

    @Test(priority = 1)
    public void testBonustask2(){
        HomePage homePage=new HomePage(driver);

        HotelsListPage londonHotelsPage = homePage.searchCity("London");
        //Selecting room type and shareing type filters
        londonHotelsPage.selectRoomType("Private");
        londonHotelsPage.selectSharingType("Bathroom");

        //Reading 2nd hotel details before selecting it
        List<String> expHotelProps = londonHotelsPage.readNthPropertyDetails(4);

        //selecting 4 hotel in the list
        TheHotelPage theHotelPage = londonHotelsPage.selectNthHotel(4);
        List<String> actHotelProps =theHotelPage.readHotelDetails();

        Assert.assertEquals(actHotelProps.get(0),expHotelProps.get(0),
                "Assert Failed : expected["+expHotelProps.get(0)+"] but actual["+actHotelProps.get(0)+"]");

        Assert.assertTrue(actHotelProps.get(1).contains(expHotelProps.get(1)),
                "Assert Failed : expected["+expHotelProps.get(1)+"] but actual["+actHotelProps.get(1)+"]" );

        CompleteBookingPage completeBookingPage = theHotelPage.bookTheHotel();
        completeBookingPage.fillForm();
        completeBookingPage.fillEmergencyContact();

        //Asserting booking is completing

        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        driver.switchTo().parentFrame();
        System.out.println("================================");
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        System.out.println("Booking Confirmation message : "+driver.findElement(By.className("text-main")).getText());
        Assert.assertTrue(driver.findElement(By.className("text-main")).getText().contains("You have completed your booking form"));

    }
}
