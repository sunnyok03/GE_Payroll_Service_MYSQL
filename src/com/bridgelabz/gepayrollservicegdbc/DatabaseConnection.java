package com.bridgelabz.gepayrollservicegdbc;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
@desc; to create connection between database and java and applies queries
 */
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private static Connection connection ;
    private static final String URL = "jdbc:mysql://localhost:3306/payroll_service";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Abcd@1234";

    /*
    @desc: constructor to create the connection (keeping it private so
            that user cant directly use constructor
     */
    private DatabaseConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            DatabaseConnection.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    @desc: instance of the DatabaseConnection, so we don't have to initialize everytime
    @return: instance of the DatabaseConnection class (singleton design pattern)
     */
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    /*
@desc: retrieve data from the table employee_payroll
@params: connection
@return: list of data
 */
    public List<EmployeePayroll> retrieveAllData(){
        List<EmployeePayroll> list = new ArrayList<>();
        try{
            String query = "select * from employee_payroll";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                EmployeePayroll employeePayroll = createObject(resultSet);
                list.add(employeePayroll);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    /*
    @desc: create an object from the data fetched from db
    @params: resultSet
    @return: EmployeePayroll object
     */
    private EmployeePayroll createObject(ResultSet resultSet) throws SQLException {
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
        return employeePayroll;
    }

    /*
    @desc: print data in string format
     */
    public void printList(List<EmployeePayroll> list){
        for(EmployeePayroll employee : list){
            System.out.println(employee);
        }
    }

    /*
@desc: update basicPay with given name
@params: connection,basicPay,name
 */
    public void updateBasicPay(double basicPay, String name){
        try{
            String query = "update employee_payroll set basic_pay = ? where name = ?";
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
    public List<EmployeePayroll> joinedBetweenDates(LocalDate startDate, LocalDate endDate){
        List<EmployeePayroll> list = new ArrayList<>();

        try{
            String query = "select * from employee_payroll where start_date between ? and ?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setDate(1,Date.valueOf(startDate));
                preparedStatement.setDate(2,Date.valueOf(endDate));
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()) {
                    EmployeePayroll employeePayroll = createObject(resultSet);
                    list.add(employeePayroll);
                }
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    /*
    @desc: applies arithmetic operation group by gender
     */
    public void arithmeticOperation(){
        try{
            String query = "select sum(basic_pay),avg(basic_pay),min(basic_pay),max(basic_pay),gender from employee_payroll group by gender";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()) {
                    double sum = resultSet.getDouble("sum(basic_pay)");
                    double avg = resultSet.getDouble("avg(basic_pay)");
                    double min = resultSet.getDouble("min(basic_pay)");
                    double max = resultSet.getDouble("max(basic_pay)");
                    char gender = resultSet.getString("gender").charAt(0);
                    System.out.println("sum: " + sum + " avg: " + avg + " min: " + min + " max: " + max + " gender: " + gender);
                }
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*
    @desc: close the connection
     */
    public void close() {
        try {
            if (connection != null) {
                System.out.println("Connection closed...");
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}