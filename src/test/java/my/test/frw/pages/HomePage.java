package my.test.frw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    By searchMain = By.id("main-search");
    String locSuggestionBoxXpath="//ul[@id='search-suggestions-container']//*[contains(text(),'cityToSearch')]";
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HotelsListPage searchCity(String cityToSearch){
        driver.findElement(searchMain).sendKeys(cityToSearch, Keys.ENTER);
        //driver.findElement(searchMain).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(locSuggestionBoxXpath.replace("cityToSearch",cityToSearch))).click();
        return new HotelsListPage(driver);
    }
}
