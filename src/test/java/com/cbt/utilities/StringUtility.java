package com.cbt.utilities;

public class StringUtility {


    public static void main(String[] args) {

    }

    public static void verifyEquals(String expected,String actual){

        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        if(expected.equals(actual)){

            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

    }


}
