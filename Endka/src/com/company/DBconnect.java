package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {


        public static Connection connect(){
            String jdbcURL ="jdbc:mysql://localhost:3306/bank";
            String username = "root";
            String password="";
            try {
                Connection connection = DriverManager.getConnection(jdbcURL,username,password);
                if (connection!=null){
                    System.out.println("connected");
                }
                return connection;

            }catch (Exception ex){
                ex.printStackTrace();
            }
            return null;
        }

    }

