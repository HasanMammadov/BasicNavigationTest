package HomeWork4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class AmazonMainDepartments {

    private WebDriver driver;

    @Test
    public void mainDepartments() throws InterruptedException {
        driver.get(" https://www.amazon.com/gp/site-directory");
        List<WebElement> allDeps = driver.findElements(By.cssSelector("[name='url']>option"));

       List<WebElement> mainDeps = driver.findElements(By.cssSelector("[class='fsdDeptTitle']"));

int notPresent=0;
        for (WebElement eachDep:allDeps) {
            for (WebElement eachMain:mainDeps) {
              String eachDepr =eachDep.getText();
              String eachMainn = eachMain.getText();

              if(eachDepr.equals(eachMainn)){
                  System.out.println("eachMainn = " + eachMainn);
                  System.out.println("eachDepr = " + eachDepr);
              }else {
                  notPresent++;
              }
            }
        }
        System.out.println(notPresent);

        Assert.assertTrue(notPresent>0);


//        driver.findElement(By.id("searchDropdownBox")).click();
//        Thread.sleep(3000);

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

}
