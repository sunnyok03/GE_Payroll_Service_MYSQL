package com.bridgelabz.gepayrollservicegdbc;

import java.time.LocalDate;

/*
@desc:representation in object of the database payroll_service
 */
public class EmployeePayroll {
    private int empId;
    private String name;
    private String phoneNumber;
    private String address;
    private char gender;
    private LocalDate startDate;
    private int compId;
    private int deptId;

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
     @desc: getter method of employee deptId
     @return : int (deptId of the employee)
      */
    public int getDeptId() {
        return deptId;
    }

    /*
        @desc: setter method of employee deptId
        @params: int (deptId of the employee)
       */
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    /*
     @desc: getter method of employee company ID
     @return : int (compId of the employee)
      */
    public int getCompId() {
        return compId;
    }

    /*
     @desc: setter method of employee company ID
     @params: int (compId of the employee)
     */
    public void setCompId(int compId) {
        this.compId = compId;
    }
}