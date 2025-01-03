package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TasksTests {

    @Test //TC1
    public void test1() {
        WebDriver driver = new ChromeDriver(); //create a new instance of ChromeDriver
        driver.manage().window().maximize(); //maximize the window

        driver.navigate().to("https://www.google.com/ncr"); //navigate to google.com

        String pageTitle = driver.getTitle(); //get the title of the page
        String expectedTitle = "Google"; //expected title
        Assert.assertEquals(pageTitle, expectedTitle); //assertion that the actual title is equal to the expected title

        driver.quit(); //close the browser
    }
    @Test //TC2
    public void test2() {
       WebDriver driver = new ChromeDriver(); //create a new instance of ChromeDriver
        driver.manage().window().maximize(); //maximize the window
        driver.navigate().to("https://duckduckgo.com/"); //navigate to google.co

        WebElement image = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[1]/a")); //find the element by xpath

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> image.isDisplayed());
        Assert.assertTrue(image.isDisplayed()); //assert that the image is displayed
        driver.quit();
    }

    @Test //TC3
    public void test3(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");

        driver.findElement(By.id("searchbox_input")).sendKeys("Selenium WebDriver"); //find the search box and enter "Selenium WebDriver"
        driver.findElement(By.xpath("//*[@id=\"searchbox_homepage\"]/div/div[1]/div/button[2]")).click();   //find the search button and click on it


        WebElement firstLink = driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div[3]/h2/a"));   //find the first link
//        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        wait.until(d -> firstLink.isDisplayed());


        String firstLinkText = firstLink.getDomAttribute("href");   //get the link of the first link
        Assert.assertEquals(firstLinkText, "https://www.selenium.dev/documentation/webdriver/"); //assert that the link is equal to the expected link

        driver.quit();
    }

    @Test //TC7
    public void CountryForTheCompany(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");

        By austriaCountry =By.xpath("//table[@id='customers']//tr[td[text()='Ernst Handel']]/td[text()='Austria']");
        boolean isAustriaCountryDisplayed = driver.findElement(austriaCountry).isDisplayed();
        Assert.assertTrue(isAustriaCountryDisplayed);


        driver.quit();

    }
}
