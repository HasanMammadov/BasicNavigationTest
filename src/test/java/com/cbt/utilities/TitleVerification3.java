package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://luluandgeorgia.com","http://wayfair.com","http://walmart.com",
                "http://westelm.com");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        for (String url:urls) {


            driver.get(url);
            driver.manage().window().maximize();
            String title = driver.getTitle().replace(" ","").toLowerCase();

            if(driver.getCurrentUrl().contains(title)){
                System.out.println("Pass - "+driver.getCurrentUrl()+" url contains "+ title);
            }else{
                System.out.println("Fail - "+driver.getCurrentUrl()+" does NOT  contains "+ title);

            }

        }

        driver.quit();



    }
}
