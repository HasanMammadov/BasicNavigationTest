package com.cbt.utilities;
import java.util.Locale;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {


    public static void main(String[] args) throws InterruptedException {
     WebDriver driver =  getDriver("chrome");
     driver.get("http://google.com");
     driver.manage().window().maximize();
     Thread.sleep(3000);
     driver.quit();


    }

    public static WebDriver getDriver(String browser){

        String osName = System.getProperty("os.name");

        if(osName.contains("Mac")&&browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().version("79").setup();
            return  new ChromeDriver();
        }else if(osName.contains("Mac")&&browser.equalsIgnoreCase("Opera")){
            WebDriverManager.operadriver().setup();
            return  new OperaDriver();
        }else if(osName.contains("Mac")&&browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            return  new FirefoxDriver();

        }else if(osName.contains("Mac")&&browser.equalsIgnoreCase("Safari")){
            return  new SafariDriver();

        }else {
            return null;
        }



    }

}
