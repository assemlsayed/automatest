package pagesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DuckDuckGoSearchResultsPage {

    public static WebElement firstResultLink(WebDriver driver){

       WebElement firstResultLink = driver.findElement(By.xpath("//div[@class=\"ikg2IXiCD14iVX7AdZo1\"]//a"));
         return firstResultLink;
    }
}
