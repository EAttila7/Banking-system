package com.company;

import java.sql.*;

public class DBWork {
    static Connection connection = DBconnect.connect();//connection with database
//method getBANK
    public static void getBanks() throws SQLException {
        if (connection != null) {
            String sql = "SELECT * FROM bank";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (!resultSet.isBeforeFirst()) {
                System.out.println("DYM ZHOK");
            } else {
                while (resultSet.next()) {
                    int bid = resultSet.getInt("bank_id");
                    String bname = resultSet.getString("bank_name");
                    String baddress = resultSet.getString("bank_address");

                    System.out.println(bid + ": " + bname + " (" + baddress + ")");
                }
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
// method getCLIENT_ID
    public static void getCId() throws SQLException {
        if (connection != null) {
            String sql = "SELECT client_id FROM clients ORDER BY client_id DESC LIMIT 1;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (!resultSet.isBeforeFirst()) {
                System.out.println("DYM ZHOK");
            } else {
                while (resultSet.next()) {

                    int cid = resultSet.getInt("client_id");
                    System.out.println(cid);
                }
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
//method SIGN IN

public static boolean getSign(String username,String userpass) throws SQLException {

    if (connection != null) {
        String sql = "SELECT * FROM clients WHERE fname=? AND password=?";
        Statement statement = connection.createStatement();
        PreparedStatement preparedSet = connection.prepareStatement(sql);
        preparedSet.setString(1, username);
        preparedSet.setString(2, userpass);
        ResultSet resultSet = preparedSet.executeQuery();
        if (!resultSet.isBeforeFirst()) {
            return false;
        }
        else {
            while (resultSet.next()) {
                Client client=new Client();
                client.setName(resultSet.getString("fname"));
                client.setName(resultSet.getString("password"));
                return true;
                }
            }
        }
   return false;
    }

//----------------------------------------------------------------------------------------------------------------------
//method REGISTRATION
    public static void insertClient(Client client) throws SQLException{
        if (connection != null) {
            String sql = "INSERT INTO clients(fname, lname, address,password, bank_id) VALUES (?,?,?,?,?)";
            PreparedStatement preparedSet = connection.prepareStatement(sql);
            preparedSet.setString(1, client.getName());
            preparedSet.setString(2, client.getSurname());
            preparedSet.setString(3, client.getAddress());
            preparedSet.setString(4, client.getPassword());
            preparedSet.setInt(5, client.getId());
            int row = preparedSet.executeUpdate();
                if (row > 0){
                    System.out.println("User Registered");
           }
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    public static void insertDeposit(Deposit deposit) throws SQLException{
        if (connection != null) {
            String sql = "INSERT INTO deposit(client_id, deposit_percent , deposit_sum ,term) VALUES (?,?,?,?)";
            PreparedStatement preparedSet1 = connection.prepareStatement(sql);
            preparedSet1.setInt(1, deposit.getId());
            preparedSet1.setInt(2, deposit.getPercent());
            preparedSet1.setLong(3, deposit.getSum());
            preparedSet1.setInt(4, deposit.getTerm());
            int row = preparedSet1.executeUpdate();
                if (row > 0){
                     System.out.println("Congratulations, you have opened a deposit");
            }
        }
    }


}