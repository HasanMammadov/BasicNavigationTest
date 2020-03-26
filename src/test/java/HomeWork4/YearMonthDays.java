package HomeWork4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class YearMonthDays {
    private WebDriver driver;


    @Test
    public void dayMonthYear(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        Random random = new Random();
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));

        List<WebElement> years = driver.findElements(By.cssSelector("[id='year']>option"));
        List<WebElement> month = driver.findElements(By.cssSelector("[id='month']>option"));


        int i=0;

        while (i<=100){
            int indexYear = random.nextInt(100);
            int indexMonth = random.nextInt(12);


            selectYear.selectByVisibleText(years.get(indexYear).getText());
            selectMonth.selectByVisibleText("January");
            selectMonth.selectByVisibleText(month.get(indexMonth).getText());

            i++;
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
