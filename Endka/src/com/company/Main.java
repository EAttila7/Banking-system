package com.company;
import java.sql.*;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        DBconnect dBconnect = new DBconnect();// connection
        dBconnect.connect();// new connection
        Scanner scanner;
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("* Hello human               *");
            System.out.println("* 1.Do you have an account? *");
            System.out.println("* 2.To register go here     *");
            System.out.println("* 3.To open a deposit       *");
            System.out.println("* 4.To exit                 * ");
            System.out.println("* * * * * * * * * * * * * * *");
            System.out.println("Enter option (1-3): ");
            try {
                int op = scanner.nextInt();
                if (op == 1) {
                    vhodClient();
                } else if (op == 2) {
                    insertClient();
                } else if (op == 3) {
                    insertDeposit();
                } else if (op == 4) {
                    break;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("* * * * * * * * * * * * * * *");
        }
    }


    private static void vhodClient() throws SQLException {
        String username;
        String userpass;
        Scanner scanner2;
        scanner2 = new Scanner(System.in);
        Client client1 = new Client();
        System.out.println("Please enter name");
        username=scanner2.next();
        System.out.println("Please enter password");
        userpass=scanner2.next();
        if(DBWork.getSign(username,userpass)){
            System.out.println("You already registered");
        }
    else{
            System.out.println("Wrong user name or password");
        }
    }

    private static void insertClient() throws SQLException {
        Scanner scanner1;
        scanner1 = new Scanner(System.in);
        Client client = new Client();

//        System.out.println("Please enter name");
//        client.setName(scanner1.next());

        String validname = "";
        while (!Validation.ValidName(validname)) {
            System.out.print("Please enter name ");
            validname = scanner1.next();
            client.setName(validname);

            if (!Validation.ValidName(validname)) {
                System.out.println("Please enter the correct name");
            }
        }


//        System.out.println("Please enter surname");
//        client.setSurname(scanner1.next());

        String validsname = "";
        while (!Validation.ValidName(validsname)) {
            System.out.print("Please enter surname ");
            validsname = scanner1.next();
            client.setSurname(validsname);

            if (!Validation.ValidName(validsname)) {
                System.out.println("Please enter the correct surname");
            }
        }

        System.out.println("Please enter address");
        client.setAddress(scanner1.next());

//        System.out.println("Please enter password");
//        client.setPassword(scanner1.next());
        String pass = "";

        while (!Validation.checkPassword(pass)) {
            System.out.print("Enter password: ");
            pass = scanner1.next();
            client.setPassword(pass);

            if (!Validation.checkPassword(pass)) {
                System.out.println("Password is too weak, please try again, password must contain at least 1 uppercase, lowercase, numbers and symbols.");
            }
        }

        DBWork.getBanks();
        System.out.println("Please select your bank");
        client.setId(scanner1.nextInt());
        DBWork.insertClient(client);
//return client id
        System.out.println("Your id remember id");
        DBWork.getCId();

    }
//----------------------------------------------------------------------------------------------------------------------

        private static void insertDeposit () throws SQLException {
            Scanner scanner4;
            scanner4 = new Scanner(System.in);
            Deposit deposit = new Deposit();


            System.out.println("Please enter your it");
            deposit.setId(scanner4.nextInt());
            System.out.println("Please enter deposit persent");
            deposit.setPercent(scanner4.nextInt());
            System.out.println("Please enter sum");
            deposit.setSum(scanner4.nextLong());
            System.out.println("Please enter term");
            deposit.setTerm(scanner4.nextInt());
            DBWork.insertDeposit(deposit);

        }
//----------------------------------------------------------------------------------------------------------------------
        private static void nextstep () {
            Scanner scanner3;
            scanner3 = new Scanner(System.in);
            while (true) {
                System.out.println("Hello human");
                System.out.println("1.Do you have an account?");
                System.out.println("2.To register go here");
                System.out.println("3.To exit");

                System.out.println("Enter option (1-3): ");
                try {
                    int op = scanner3.nextInt();
                    if (op == 1) {
                        vhodClient();
                    } else if (op == 2) {
                        insertClient();
                    } else if (op == 3) {
                        break;
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("*************************");
            }
        }

}


