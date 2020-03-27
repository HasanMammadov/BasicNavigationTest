package HomeWork4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Links {
    private WebDriver driver;
    @Test
    public void ifDisplayedTagA(){
        driver.get("https://www.w3schools.com/");
        List<WebElement> listTagName = driver.findElements(By.tagName("a"));
        System.out.println("displayed elements: "+listTagName.size());

        for (WebElement eachTag:listTagName) {
            String text = "";
            String href="";
            if(eachTag.isDisplayed()){
                text=eachTag.getText();
                href=eachTag.getAttribute("href");
                System.out.println("text = "+text+" :: href = " + href);
                Assert.assertTrue(eachTag.isDisplayed());
            }

          //  System.out.println("href = " + href);
        }

    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
