package com.bridgelabz.gepayrollservicegdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/payroll_service";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Abcd@1234";

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            System.out.println("Connection established...");
            List<EmployeePayroll> list = retrieveData(connection);
            for(EmployeePayroll employee : list){
                System.out.println(employee);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<EmployeePayroll> retrieveData(Connection connection){
        List<EmployeePayroll> list = new ArrayList<>();

        try(connection){
            String query = "select * from employee_payroll";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                EmployeePayroll employeePayroll = new EmployeePayroll();
                employeePayroll.setEmpId(resultSet.getInt("column_id"));
                employeePayroll.setGender(resultSet.getString("gender").charAt(0));
                employeePayroll.setName(resultSet.getString("name"));
                employeePayroll.setSalary(resultSet.getDouble("salary"));
                employeePayroll.setStartDate(resultSet.getDate("start_date").toLocalDate());
                employeePayroll.setPhoneNumber(resultSet.getString("phone"));
                employeePayroll.setAddress(resultSet.getString("address"));
                employeePayroll.setBasicPay(resultSet.getDouble("basic_pay"));
                employeePayroll.setDept(resultSet.getString("department"));

                list.add(employeePayroll);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }
}