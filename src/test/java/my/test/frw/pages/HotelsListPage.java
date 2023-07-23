package my.test.frw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class HotelsListPage {
    WebDriver driver;


    By chkPrivate_RoomType = By.xpath("//input[@value='private_room']");
    By chkEntirePlace_RoomType = By.xpath("//input[@value='entire_place']");
    By chkShared_RoomType = By.xpath("//input[@value='shared_room']");
    By chkPrivateBathroom = By.xpath("//input[@value='private_bathroom']");
    By chkPrivateKitchen = By.xpath("//input[@value='private_kitchen']");

    By listHotels = By.xpath("//div[@class=' search-list-element-container']");


    //Xpaths for descriptive programming

    String xPath_nth_inv_heading="//div[@class=' search-list-element-container'][%PLACE_HOLDER%]//*[@class='inventory-heading']";
    String xPath_nth_inv_location="//div[@class=' search-list-element-container'][%PLACE_HOLDER%]//*[@class='inventory-location']";



    public HotelsListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectRoomType(String roomType){

        By by=null;
        if(roomType.equalsIgnoreCase("Private")){
            by=chkPrivate_RoomType;
        }else if (roomType.equalsIgnoreCase("Entire")){
            by=chkEntirePlace_RoomType;
        }
        else if (roomType.equalsIgnoreCase("Shared")){
            by=chkShared_RoomType;
        }
        driver.findElement(by).click();
    }

    public void selectSharingType(String shareType)  {
        By by=null;
        if(shareType.toLowerCase().contains("bathroom")){
            by=chkPrivateBathroom;
        }else if (shareType.toLowerCase().contains("kitchen")){
            by=chkPrivateKitchen;
        }
        driver.findElement(by).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> readNthPropertyDetails(int n){

        List<String> hotelProps=new ArrayList<String>();
        //WebElement hotelEle=driver.findElements(listHotels).get(n-1);

        hotelProps.add(driver.findElement(By.ByXPath.xpath(xPath_nth_inv_heading.replace("%PLACE_HOLDER%",String.valueOf(n)))).getText());
        hotelProps.add(driver.findElement(By.ByXPath.xpath(xPath_nth_inv_location.replace("%PLACE_HOLDER%",String.valueOf(n)))).getText());

        System.out.println(hotelProps.get(0)+" : "+hotelProps.get(1));

        return hotelProps;
    }

    public TheHotelPage selectNthHotel(int n){

        WebElement hotelEle=driver.findElements(listHotels).get(n-1);
        Actions act=new Actions(driver);
        act.scrollToElement(hotelEle).build().perform();
        hotelEle.click();

        String currHandl = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        while (iterator.hasNext()){
            String iHandle=iterator.next();
            //System.out.println("Window Handle : "+ iHandle);
            if(currHandl!=iHandle){
                driver.switchTo().window(iHandle);
            }
        }

        return new TheHotelPage(driver);

    }
}
