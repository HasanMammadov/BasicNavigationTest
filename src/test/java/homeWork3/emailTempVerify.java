package homeWork3;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class emailTempVerify {
    private RemoteWebDriver driver;
    private String emailLink = "https://www.tempmailaddress.com/";
    private By copyBy = By.linkText("Copy");

    private String signhUpLink = "https://practice-cybertekschool.herokuapp.com";
    private By signUpBy = By.linkText("Sign Up For Mailing List");
    private By fullNameBy = By.cssSelector("[name='full_name']");//[name='email']
    private By emailBy = By.cssSelector("[name='email']");
    private By subheaderBy = By.tagName("h3");
    private By receiveEmailBy = By.xpath("//tbody[@id='schranka']/tr[1] ");
    private By fromBy =By.cssSelector("#odesilatel");
    private By subjectBy = By.cssSelector("#predmet");



    @Test
public void email() throws InterruptedException {
    driver.get(emailLink);
   // Thread.sleep(3000);
    WebElement copy = driver.findElement(copyBy);
    copy.click();
   // Thread.sleep(3000);
    String emailAdress = driver.findElement(By.cssSelector("[class='animace']")).getText();
    driver.navigate().to(signhUpLink);
    //    Thread.sleep(3000);
        driver.findElement(signUpBy).click();
     //   Thread.sleep(3000);

        driver.findElement(fullNameBy).sendKeys("Hasan Mammadov");
        Thread.sleep(3000);

        driver.findElement(emailBy).sendKeys(emailAdress, Keys.ENTER);
        Thread.sleep(3000);
        WebElement subheaderTex = driver.findElement(subheaderBy);

        Assert.assertTrue(subheaderTex.isDisplayed());
        driver.navigate().to(emailLink);


        WebElement doNOtReply = driver.findElement(receiveEmailBy);
        String notReply= doNOtReply.getText();

        Assert.assertTrue(notReply.contains("practice.cybertekschool.com"));
        doNOtReply.click();
        Thread.sleep(3000);

        WebElement from = driver.findElement(fromBy);
        String expectedFrom = "do-not-reply@practice.cybertekschool.com";
        String actualFrom =from.getText();

        Assert.assertEquals(expectedFrom,actualFrom);

        WebElement subject = driver.findElement(subjectBy);
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = subject.getText();

        Assert.assertEquals(expectedSubject,actualSubject);






    }


    @BeforeMethod
    public void setDriver(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
