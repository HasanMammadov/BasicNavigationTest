package homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Autocomplete {

    private WebDriver driver;
    private String url = "https://practice-cybertekschool.herokuapp.com";
    private By autocompleteBy = By.linkText("Autocomplete");
    private By inputBy = By.cssSelector("#myCountry");
    private String text="United States of America";
    private By hiddenBy = By.cssSelector("#myCountryautocomplete-list");
    private By submit = By.cssSelector("[value='Submit']");


    @Test
    public void autocompleteMessage()  {
        driver.findElement(autocompleteBy).click();
        driver.findElement(inputBy).sendKeys(text);
        driver.findElement(hiddenBy).click();
        driver.findElement(submit).click();

        String expected = "You selected: United States of America";

        String actual= driver.findElement(By.cssSelector("#result")).getText();

        Assert.assertEquals(actual,expected);

    }





@BeforeMethod
public void setDriver(){
    WebDriverManager.chromedriver().version("79").setup();
    driver = new ChromeDriver();
    driver.get(url);
    driver.manage().window().maximize();
}
@AfterMethod
public void tearDown() throws InterruptedException {

    driver.quit();
}
}
