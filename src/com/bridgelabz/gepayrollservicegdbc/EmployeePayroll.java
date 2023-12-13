package com.bridgelabz.gepayrollservicegdbc;

import java.time.LocalDate;

/*
@desc:representation in object of the database payroll_service
 */
public class EmployeePayroll {
    private int empId;
    private char gender;
    private String name;
    private double salary;
    private String phoneNumber;
    private String address;
    private LocalDate startDate;
    private double basicPay;
    private String dept;

   /*
   @desc: getter method of employee id
   @return : int (id of the employee)
    */
    public int getEmpId() {
        return empId;
    }

    /*
      @desc: setter method of employee id
      @params: int (id of the employee)
     */
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    /*
     @desc: getter method of employee name
     @return : String (name of the employee)
      */
    public String getName() {
        return name;
    }

    /*
       @desc: setter method of employee name
       @params: String (name of the employee)
      */
    public void setName(String name) {
        this.name = name;
    }

    /*
     @desc: getter method of employee phone number
     @return : String (phone number of the employee)
      */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /*
       @desc: setter method of employee phone number
       @params: String (phone number of the employee)
      */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*
     @desc: getter method of employee address
     @return : String (address of the employee)
      */
    public String getAddress() {
        return address;
    }

    /*
       @desc: setter method of employee address
       @params: String (address of the employee)
      */
    public void setAddress(String address) {
        this.address = address;
    }

    /*
    @desc: getter method of employee salary
    @return : double (salary of the employee)
  */
    public double getSalary(){
        return salary;
    }

    /*
     @desc: setter method of employee salary
     @params: double (salary of the employee)
    */
    public void setSalary(double salary){
        this.salary = salary;
    }

    /*
     @desc: getter method of employee gender
     @return : Char (gender of the employee)
      */
    public char getGender() {
        return gender;
    }

    /*
      @desc: setter method of employee gender
      @params: char (gender of the employee ('M' or 'F'))
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /*
     @desc: getter method of employee startDate
     @return : LocalDate (start date of the employee working)
      */
    public LocalDate getStartDate() {
        return startDate;
    }

    /*
         @desc: setter method of employee startDate
         @params: LocalDate (startDate of the employee)
        */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /*
     @desc: getter method of employee dept
     @return : String (dept of the employee)
      */
    public String getDept() {
        return dept;
    }

    /*
        @desc: setter method of employee dept
        @params: String (dept of the employee)
       */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /*
      @desc: getter method of employee company basicPay
      @params: double (basicPay of the employee)
      */
    public double getBasicPay(){
        return basicPay;
    }

    /*
  @desc: setter method of employee company basicPay
  @params: double (basicPay of the employee)
  */
    public void setBasicPay(double basicPay){
        this.basicPay = basicPay;
    }

    /*
    @desc: convert object to string
    @return : return object in string format
     */
    @Override
    public String toString() {
        return "EmployeePayroll{" +
                "empId=" + empId +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", startDate=" + startDate +
                ", basicPay=" + basicPay +
                ", dept='" + dept + '\'' +
                '}';
    }
}
