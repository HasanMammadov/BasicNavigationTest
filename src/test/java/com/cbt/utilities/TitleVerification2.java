package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
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



//
//        WebDriver driver = BrowserFactory.getDriver("chrome");
//        driver.get(urls.get(0));
//        String title = driver.getTitle().toLowerCase().replace(" ","");
//        System.out.println("title = " + title);
//        String url = driver.getCurrentUrl();
//        System.out.println("url = " + url);
//        if(title.contains("amazon")&&url.contains("amazon")){
//            System.out.println("Test passed");
//        }else {
//            System.out.println("Test failed");
//        }
//
//
//driver.quit();
//
//
//
//
//
//        WebDriver driverWayfair = BrowserFactory.getDriver("chrome");
//        driverWayfair.get(urls.get(1));
//        String titleWayfair = driverWayfair.getTitle().toLowerCase().replace(" ","");
//        System.out.println("title = " + titleWayfair);
//        String urlWayfair = driverWayfair.getCurrentUrl();
//        System.out.println("url = " + urlWayfair);
//        if(titleWayfair.contains("wayfair")&&urlWayfair.contains("wayfair")){
//            System.out.println("Test passed");
//        }else {
//            System.out.println("Test failed");
//        }
//
//
//        driverWayfair.quit();
//
//
//
//
//
//
//
//        WebDriver driverWalmart = BrowserFactory.getDriver("chrome");
//        driverWalmart.get(urls.get(2));
//        String titleWalmart = driverWalmart.getTitle().toLowerCase().replace(" ","");
//        System.out.println("title = " + titleWalmart);
//        String urlWalmart = driverWalmart.getCurrentUrl();
//        System.out.println("url = " + urlWalmart);
//        if(titleWalmart.contains("walmart")&&urlWalmart.contains("walmart")){
//            System.out.println("Test passed");
//        }else {
//            System.out.println("Test failed");
//        }
//
//
//        driverWalmart.quit();
//
//
//
//
//
//
//        WebDriver driverwestelm = BrowserFactory.getDriver("chrome");
//        driverwestelm.get(urls.get(3));
//        String titleWestelm = driverwestelm.getTitle().toLowerCase().replace(" ","");
//        System.out.println("title = " + titleWestelm);
//        String urlWestelm = driverwestelm.getCurrentUrl();
//        System.out.println("url = " + urlWestelm);
//        if(titleWestelm.contains("westelm")&&urlWestelm.contains("westelm")){
//            System.out.println("Test passed");
//        }else {
//            System.out.println("Test failed");
//        }
//
//
//        driverwestelm.quit();
//
//

    }



}
