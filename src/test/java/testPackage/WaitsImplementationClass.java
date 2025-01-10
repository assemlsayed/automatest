package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsImplementationClass {

    @Test
    public void controlTest(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        By adderButton =By.id("adder");
        driver.findElement(adderButton).click();

        By redBox = By.id("box0");
        boolean isRedBoxDisplayed = driver.findElement(redBox).isDisplayed();



        Assert.assertTrue(isRedBoxDisplayed);
        driver.quit();
    }
    // CTRL / to comment out
    //task is: task#7 from tasks google sheet

    @Test
    public void implicitWaitTest(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("adder")).click();

        boolean isRedBoxDisplayed = driver.findElement(By.id("box0")).isDisplayed();

        Assert.assertTrue(isRedBoxDisplayed);
        driver.quit();
    }
}
