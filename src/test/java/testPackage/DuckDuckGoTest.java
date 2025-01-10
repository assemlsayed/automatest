package testPackage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pagesPackage.DuckDuckGoLandingPage;
import pagesPackage.DuckDuckGoSearchResultsPage;

import java.time.Duration;


public class DuckDuckGoTest {

    WebDriver driver =null;
    Wait<WebDriver> wait = null;
    /**#1
     _ Basic _
     Open Google Chrome
     Navigate to [https://duckduckgo.com/]
     Assert that the page title is [Google]
     Close Google Chrome
     */
    @Test
    public void TitleTest() {
        driver.navigate().to("https://duckduckgo.com/");
        Assert.assertEquals(DuckDuckGoLandingPage.DDGPageTitle(driver), "Google");
    }

    /**
    #2
_ Basic _
Open Google Chrome
Navigate to [https://duckduckgo.com/]
Assert that the DuckDuckGo logo is displayed
Close Google Chrome

    * */
    @Test(dependsOnMethods = "TitleTest")
    public void logoTest() {

        driver.navigate().to("https://duckduckgo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(d -> DuckDuckGoLandingPage.logo(driver).isDisplayed());
        Assert.assertTrue(DuckDuckGoLandingPage.logo(driver).isDisplayed());

    }

    /**#3
________________ Basic ________________
Open Google Chrome
Navigate to [https://duckduckgo.com/]
Search for [Selenium WebDriver]
Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
Close Google Chrome
*/
    @Test(dependsOnMethods = "logoTest")
    public void searchLinkTest() {
       driver.navigate().to("https://duckduckgo.com/");
       driver.findElement(DuckDuckGoLandingPage.searchBox(driver)).sendKeys("Selenium WebDriver", Keys.ENTER);
       wait = new WebDriverWait(driver, Duration.ofSeconds(1));
       wait.until(d -> DuckDuckGoSearchResultsPage.firstResultLink(driver).isDisplayed());
       String firstLinkText = DuckDuckGoSearchResultsPage.firstResultLink(driver).getDomAttribute("href");
       Assert.assertEquals(firstLinkText, "https://www.selenium.dev/documentation/webdriver/");
    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
