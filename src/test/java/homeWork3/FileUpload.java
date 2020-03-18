package homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {

    private WebDriver driver;
    private String url = "https://practice-cybertekschool.herokuapp.com";


    @Test
    public void fileUpload() throws InterruptedException {
driver.findElement(By.linkText("File Upload")).click();
driver.findElement(By.cssSelector("#file-upload")).sendKeys("/Users/hasanmammadov/Desktop/day to day activity.docx");
driver.findElement(By.cssSelector("#file-submit")).click();

String expected = "File Uploaded!";

String actual =driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(actual,expected);

    }




@BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown(){
    driver.quit();
    }
}
