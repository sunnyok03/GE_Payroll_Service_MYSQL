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

