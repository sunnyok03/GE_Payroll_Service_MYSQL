package com.bridgelabz.gepayrollservicegdbc;

import javax.xml.crypto.Data;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Queries to implement CRUD and other operations on employee_payroll table
 */
public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

        // all data
        List<EmployeePayroll> list = databaseConnection.retrieveAllData();
        databaseConnection.printList(list);

        // update basePay of "Terissa" to 3000000.00 and sync with db
        databaseConnection.updateBasicPay(3000000.00, "Terissa");

        // fetch data of joinee between startDate and endDate
        list = databaseConnection.joinedBetweenDates(LocalDate.of(2023, 12, 10), LocalDate.of(2023, 12, 11));
        databaseConnection.printList(list);

        // apply arithmetic operations (sum,min,max,avg,count)
        databaseConnection.arithmeticOperation();
    }


}