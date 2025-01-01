package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TaskClass {

    @Test
    public void controlTest(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();

       boolean redBox = driver.findElement(By.id("box0")).isDisplayed();
       Assert.assertTrue(redBox);
       driver.quit();
    }

    @Test
    public void implicitWaitTest(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        boolean redBox = driver.findElement(By.id("box0")).isDisplayed();
        Assert.assertTrue(redBox);
        driver.quit();
    }
}
