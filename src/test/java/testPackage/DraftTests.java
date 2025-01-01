package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DraftTests {

    @Test
    public void test()
    {

        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().minimize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();



       // driver.manage().logs();
        driver.navigate().to("https://duckduckgo.com/");


       // driver.switchTo().alert().sendKeys("pass");//for popups


        String windowHandle1 = driver.getWindowHandle();
        String windowHandle2 = driver.switchTo().newWindow(WindowType.TAB).getWindowHandle();

        driver.switchTo().window(windowHandle1);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
        driver.switchTo().window(windowHandle2);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
        driver.switchTo().window(windowHandle1);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
        driver.switchTo().window(windowHandle2);








       // driver.close(); //close the opened tap
        // driver.quit(); //close the browser







       // driver.getTitle();
       // int waitTime=10;
        //driver.wait(waitTime);

    }

}
