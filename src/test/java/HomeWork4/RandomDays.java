package HomeWork4;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomDays {


    @Test
    public void weekDays() throws InterruptedException {
   // driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
//        WebElement checkBox = driver.findElement(By.xpath("//table//tbody//tr[2]//input"));
//        WebElement weekDay = driver.findElement(By.xpath("//table//tbody//tr[2]"));
//        //2-6

        int countFriday = 0;

  //while (countFriday>=3) {
    Random random = new Random();
    int num = random.nextInt(5);
        Thread.sleep(5000);

        List<WebElement> days = driver.findElements(By.xpath("//table//tbody//tr[" + (num + 2) + "]"));

    String wDays ="";
    for (WebElement each : days) {
        wDays=each.getText();

        each.click();
        System.out.println(each.getText());
        each.click();

    }



//    if(wDays.equals("Friday")){
//        countFriday++;
//    }
//}









//        Random random = new Random();
//            int num = random.nextInt(5);
//            Thread.sleep(3000);
//             driver.findElement(By.xpath("//table//tbody//tr["+(num+2)+"]//input")).click();
//            Thread.sleep(3000);
//
//            WebElement weekDay = driver.findElement(By.xpath("//table//tbody//tr["+(num+2)+"]"));
//            Thread.sleep(3000);
//
//            String eachDay = weekDay.getText();
//            Thread.sleep(3000);
//
//            System.out.println(eachDay);
//            Thread.sleep(3000);
//
//            driver.findElement(By.xpath("//table//tbody//tr["+(num+2)+"]//input")).click();
//            Thread.sleep(3000);
//
//            if(eachDay.equals("Friday")){
//                countFriday++;
//            }
//
//
      }






    private WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
