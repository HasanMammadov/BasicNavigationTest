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

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class TodaysDate {

   private WebDriver driver;

@Test
   public void toDayDateVerify(){


//
//       WebElement year = driver.findElement(By.id("year"));
//       WebElement month = driver.findElement(By.id("month"));
//       WebElement day=  driver.findElement(By.id("day"));day

    Select day = new Select(driver.findElement(By.id("day")));
    String actualDay = day.getFirstSelectedOption().getText();

    Select month = new Select(driver.findElement(By.id("month")));
    String actualMonth = month.getFirstSelectedOption().getText();

    Select year = new Select(driver.findElement(By.id("year")));
    String actualYear = year.getFirstSelectedOption().getText();

    LocalDate localDate =  LocalDate.now();

    String expectedDate = DateTimeFormatter.ofPattern("yyyyMMMMdd").format(localDate);

    System.out.println("expectedDate = " + expectedDate);
    String actual = actualYear+actualMonth+actualDay;
    System.out.println("actual = " + actual);

    Assert.assertEquals(expectedDate,actual);








}








 @AfterMethod
public void tearDown(){
    driver.quit();
}

   @BeforeMethod
   public void setDriver(){
       WebDriverManager.chromedriver().version("79").setup();
       driver =new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("http://practice.cybertekschool.com/dropdown");
   }
}
