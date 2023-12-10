# USE CASE 1
create database payroll_service;
use payroll_service;
show databases;

# USE CASE 2
create table employee_payroll(
	column_id int auto_increment,
    name varchar(100),
    salary double,
    start_date date,
    primary key (column_id)
);

# USE CASE 3
insert into employee_payroll (name,salary,start_date) values
("A",1000,'2024-12-09'),
("B",2000,"2023-12-10"),
("C",3000,"2023-12-11");

# USE CASE 4
select database(); # shows current database
select * from employee_payroll; 

# USE CASE 5
select salary from employee_payroll where name = "B";
select * from employee_payroll where (start_date between '2023-12-10' AND '2023-12-11');


