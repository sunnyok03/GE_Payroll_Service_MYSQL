package com.bridgelabz.gepayrollservicegdbc;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/payroll_service";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Abcd@1234";

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Connection established...");
            Statement statement = connection.createStatement();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}