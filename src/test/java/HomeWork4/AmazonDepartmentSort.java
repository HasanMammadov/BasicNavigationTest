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

public class AmazonDepartmentSort {
    private WebDriver driver;

@Test
    public void testAmazon(){
        driver.get("http://amazon.com");
    List<WebElement> allDepartments = driver.findElements(By.cssSelector("[name='url']>option"));


    String actual = driver.findElement(By.cssSelector("[class='nav-search-label']")).getText();
    String expected = "All";
    Assert.assertEquals(actual,expected);

int notSorted=0;
    for (int i = 0; i <allDepartments.size()-1 ; i++) {
        String value = allDepartments.get(i).getText();
        String nextValue = allDepartments.get(i+1).getText();

        if(value.compareTo(nextValue)>0){
            notSorted++;
        }
    }

    Assert.assertTrue(notSorted>0);







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
/*
        for (int i = 0; i <columns.size()-1 ; i++) {
        String value = columns.get(i).getText();// columdaki birinci ad
        String nextValue =columns.get(i+1).getText();//columdaki novbeti ad
        //Ascii table gore muqayise edeceyik. sert budur ki -1 olsa demeli sort olub
        // Adlarin bas herfini goturur. Deyek Ki Batch and Convar.
        // B -65 di. C 66. ABCDE -ederlerde artir. 65,66,67. eger faktikinin  ozunden soraki ile cixma emeliayti -1 birdise
        // demeli sort olub. B 65. C 66.  65-65 =-1

        // Bunun ucun CompareTo metodunudan istifade edirik. Iki stringi yoxlamaq ucun


        Assert.assertTrue(value.compareTo(nextValue)<=0);// ikisinin muqayisenden alinan netice -1 dirse sort olub

        }
}

 */

