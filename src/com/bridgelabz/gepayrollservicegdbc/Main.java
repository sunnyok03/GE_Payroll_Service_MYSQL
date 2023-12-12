package com.bridgelabz.gepayrollservicegdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Queries to implement CRUD on employee_payroll table
 */
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/payroll_service";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Abcd@1234";

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            System.out.println("Connection established...");
            List<EmployeePayroll> list = retrieveData();
//            for(EmployeePayroll employee : list){
//                System.out.println(employee);
//            }

            // update basePay of "Terissa" to 3000000.00 and sync with db
//            updateBasicPay(3000000.00,"Terissa");

            // fetch data of joinee between startDate and endDate
           list = joinedBetweenDates(LocalDate.of(2023,12,10),LocalDate.of(2023,12,11));
                    for(EmployeePayroll employeePayroll : list){
                        System.out.println(employeePayroll.getName());
                    }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    @desc: retrieve data from the table employee_payroll
    @params: connection
    @return: list of data
     */
    private static List<EmployeePayroll> retrieveData(){
        List<EmployeePayroll> list = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
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

    /*
    @desc: update basicPay with given name
    @params: connection,basicPay,name
     */
    private static void updateBasicPay(double basicPay, String name){
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            String query = "update employee_payroll set basic_pay = ? where name = ?";
            System.out.println(query);
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setDouble(1,basicPay);
                preparedStatement.setString(2,name);

                if(preparedStatement.executeUpdate() > 0){
                    System.out.println("DB updated with new basicPay...");
                }
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*
    @desc: find all employees joined in particular date range
    @params: start date and end date
    @return : list of employees
     */
    private static List<EmployeePayroll> joinedBetweenDates(LocalDate startDate,LocalDate endDate){
        List<EmployeePayroll> list = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){
            String query = "select * from employee_payroll where start_date between ? and ?";
            System.out.println(query);
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setDate(1,Date.valueOf(startDate));
                preparedStatement.setDate(2,Date.valueOf(endDate));
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()) {
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
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }
}