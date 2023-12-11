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

# USE CASE 6
alter table employee_payroll add gender char after column_id;
set sql_safe_updates = 0;
update employee_payroll set gender= 'M' where name = "A" or name = "C";
update employee_payroll set gender= 'F' where name = "B";

# USE CASE 7
select sum(salary) from employee_payroll;
select avg(salary) from employee_payroll;
select min(salary) from employee_payroll;
select max(salary) from employee_payroll;
select count(*) as male_count from employee_payroll where gender = 'M';
select count(*) as female_count from employee_payroll where gender = 'F';

# USE CASE 8
alter table employee_payroll add phone varchar(20), add address varchar(200) default "L", add department varchar(200) not null;

# USE CASE 9
alter table employee_payroll add basic_pay double, add deduction double, add taxable_pay double, add income_tax double, add net_pay double;

# USE CASE 10
insert into employee_payroll (gender,name,salary,start_date,phone,address,department,basic_pay,deduction,taxable_pay,income_tax,net_pay) values ('F',"Terissa",50000,"2023-12-11",9191919191,"Hyd","sale",30000,10000,30000,5000,25000);
insert into employee_payroll (gender,name,salary,start_date,phone,address,department,basic_pay,deduction,taxable_pay,income_tax,net_pay) values ('F',"Terissa",50000,"2023-12-11",9191919191,"Hyd","marketing",30000,10000,30000,5000,25000);

# USE CASE 10 (ER Diagram)
create table Company(
	comp_id int primary key,
    comp_name varchar(100)
);

insert into Company (comp_id,comp_name) values (1,"Company 1");

create table Department(
	dept_id int primary key,
    dept_name varchar(100)
);

insert into Department(dept_id,dept_name) values (1,"Sales");
insert into Department(dept_id,dept_name) values (2,"Marketing");

create table Employee(
    EmployeeID int primary key auto_increment,
    EmployeeName varchar(100),
    PhoneNumber varchar(20),
    Address varchar(200),
    Gender char(1),
    StartDate date,
    dept_id int,
    comp_id int,
    FOREIGN KEY (dept_id) REFERENCES Department(dept_id),
    FOREIGN KEY (comp_id) REFERENCES Company(comp_id)
);

insert into Employee values (1,"Terissa",9191919191,"Hyd",'F',"2023-12-11",1,1);



