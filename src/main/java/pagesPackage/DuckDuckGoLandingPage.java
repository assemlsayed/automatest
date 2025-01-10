package pagesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DuckDuckGoLandingPage { //DDG=https://duckduckgo.com/

    public static WebElement logo(WebDriver driver) {
        WebElement ddgLogoImg = driver.findElement(By.xpath("//div[contains(@class , 'WrapDesktop')]//a[@title='Learn about DuckDuckGo']/img")); //find the element by xpath
        return ddgLogoImg;
    }

    public static String DDGPageTitle (WebDriver driver){
        String pageTitle = driver.getTitle();
        return pageTitle;
    }
    public static By searchBox(WebDriver driver){
        By searchBox = By.id("searchbox_input");
        return searchBox;
    }

}
