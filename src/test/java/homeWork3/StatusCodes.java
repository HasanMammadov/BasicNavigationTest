package homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StatusCodes {


    private WebDriver driver;
    private String url = "https://practice-cybertekschool.herokuapp.com";
    private By statusCodesBy = By.linkText("Status Codes");
    private By statusCodes200By = By.linkText("200");
    private By statusCodes301By = By.linkText("301");
    private By statusCodes404By = By.linkText("404");
    private By statusCodes500By = By.linkText("500");




    @Test
public void test200(){
    driver.findElement(statusCodes200By).click();
    String expected = "This page returned a 200 status code.";
    String actual = driver.findElement(By.tagName("p")).getText();
        actual=actual.substring(0,actual.indexOf("\n"));

        Assert.assertEquals(actual,expected);


}

    @Test
    public void test301(){
        driver.findElement(statusCodes301By).click();
        String expected = "This page returned a 301 status code.";
        String actual = driver.findElement(By.tagName("p")).getText();
        actual=actual.substring(0,actual.indexOf("\n"));
        Assert.assertEquals(actual,expected);


    }


    @Test
    public void test404(){
        driver.findElement(statusCodes404By).click();
        String expected = "This page returned a 404 status code.";
        String actual = driver.findElement(By.tagName("p")).getText();
        actual=actual.substring(0,actual.indexOf("\n"));

        Assert.assertEquals(actual,expected);


    }

    @Test
    public void test500(){
        driver.findElement(statusCodes500By).click();
        String expected = "This page returned a 500 status code.";
        String actual = driver.findElement(By.tagName("p")).getText();
        actual=actual.substring(0,actual.indexOf("\n"));

        Assert.assertEquals(actual,expected);


    }




@BeforeMethod
    public void setDriver(){
    WebDriverManager.chromedriver().version("79").setup();
    driver= new ChromeDriver();
    driver.get(url);
    driver.manage().window().maximize();
    driver.findElement(statusCodesBy).click();

    }
    @AfterMethod
    public void tearDown(){
    driver.quit();
    }
}
