package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) throws InterruptedException {

        List<String> url = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown","http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get(url.get(0));
        String titleCom = driver.getTitle();

        String result2 = driver.getCurrentUrl();

        if(result2.startsWith("http://practice.cybertekschool.com")){
            System.out.println("Page url starts with expected link");
        }else{
            System.out.println("Page does NOT start with expected link");
        }




            driver.get(url.get(1));
        String titleDropDown = driver.getTitle();
        String result = driver.getCurrentUrl();

        if(result.startsWith("http://practice.cybertekschool.com")){
            System.out.println("Page url starts with expected link");
        }else{
            System.out.println("Page does NOT start with expected link");
        }


        driver.get(url.get(2));
        String titleLogin = driver.getTitle();
        String result1 = driver.getCurrentUrl();

        if(result1.startsWith("http://practice.cybertekschool.com")){
            System.out.println("Page url starts with expected link");
        }else{
            System.out.println("Page does NOT start with expected link");
        }


        StringUtility.verifyEquals(titleCom,titleDropDown);
        StringUtility.verifyEquals(titleDropDown,titleLogin);
        StringUtility.verifyEquals(titleCom,titleLogin);









        driver.quit();
    }




    }

