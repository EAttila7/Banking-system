package com.company;

public class Validation {
    //    public static Boolean checkPassword(String password) {
//        return password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{8,}");
//    }
    public static boolean checkPassword(String password) {

        boolean Valid = true;

        if (!(password.length() >= 8)) {// here i check lenght, if password less than 8 return false
//            System.out.println("Password must be at least 8");//sout this text
            Valid = false;//and valid equal false
        }

        String uppCase = "(.*[A-Z].*)";// i check uppercase, if there is no uppercase letter in the password, it is not accepted
        if (!password.matches(uppCase)) { //if the given string does not match the given regular expression
//            System.out.println("The password must be at least 1 uppercase.");//sout this text
            Valid = false;//and valid equal false
        }


        String lowCase = "(.*[a-z].*)";// i check lowercase, if there is no lowercase letter in the password, it is not accepted
        if (!password.matches(lowCase)) {//if the given string does not match the given regular expression
//            System.out.println("The password must be contain at least 1 lowercase.");//sout this text
            Valid = false;//and valid equal false
        }

        String specialSymbol = "(.*[@,!,$,^,#].*$)";// i check symbols, if there is no symbols in the password, it is not accepted
        if (!password.matches(specialSymbol)) {//if the given string does not match the given regular expression
//            System.out.println("The password must be contain at least 1 symbol (@,$,!,^)");//sout this text
            Valid = false;//and valid equal false
        }

        String numbers = "(.*[0-9].*)";// i check numbers, if there is no numbers  in the password, it is not accepted
        if (!password.matches(numbers)) {//if the given string does not match the given regular expression
//            System.out.println("The password must be contain at least 1 number.");//sout this text
            Valid = false;//and valid equal false
        }


        return Valid;//if everything is correct, we return true(valid)
    }

    public static boolean ValidName(String name) {

        boolean Valid = true;

        String valname = "(^[A-Za-z]\\w{3,25}$)";

        if (!name.matches(valname)) {
//            System.out.println("Please enter the correct name.");
            Valid = false;
        }
        return Valid;
    }

    public static boolean ValidSname(String surname) {

        boolean Valid = true;

        String valsname = "(^[A-Za-z]\\w{3,25}$)";

        if (!surname.matches(valsname)) {
            System.out.println("Please enter the correct surname.");
            Valid = false;
        }
        return Valid;
    }
}

