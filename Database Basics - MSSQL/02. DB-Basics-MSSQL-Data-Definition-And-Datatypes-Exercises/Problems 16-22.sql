create database SoftUni

create table Towns
(
	TownID int primary key identity,
	TownName varchar(50) not null
)

create table Addresses
(
	AddressID int primary key identity,
	AddressText text,
	TownID int foreign key references Towns(TownID)
)

create table Departments
(
	DepartmentID int primary key identity,
	DepartmentName varchar(50) not null
)

create table Employees
(
	EmployeeID int primary key identity,
	FirstName varchar(50) not null,
	MiddleName varchar(50),
	LastName varchar(50) not null,
	JobTitle varchar(50),
	DepartmentID int foreign key references Departments(DepartmentID),
	HireDate date,
	Salary money,
	AddressID int foreign key references Addresses(AddressID)
)

insert into Towns
values('Sofia')

insert into Towns
values('Plovdiv')

insert into Towns
values('Varna')

insert into Towns
values('Burgas')

insert into Departments
values('Engineering')

insert into Departments
values('Sales')

insert into Departments
values('Marketing')

insert into Departments
values('Software Development')

insert into Departments
values('Quality Assurance')

insert into Employees (FirstName,MiddleName,LastName,JobTitle,DepartmentID,HireDate,Salary)
values('Ivan','Ivanov','Ivanov','.NET Developer',4,'2013-02-01',3500.00)

insert into Employees (FirstName,MiddleName,LastName,JobTitle,DepartmentID,HireDate,Salary)
values('Petar','Petrov','Petrov','Senior Engineer',1,'2004-03-02',4000.00)

insert into Employees (FirstName,MiddleName,LastName,JobTitle,DepartmentID,HireDate,Salary)
values('Maria','Petrova','Ivanova','Intern',5,'2016-08-28',525.25)

insert into Employees (FirstName,MiddleName,LastName,JobTitle,DepartmentID,HireDate,Salary)
values('Georgi','Teziev','Ivanov','CEO',2,'2007-12-09',3000.00)

insert into Employees (FirstName,MiddleName,LastName,JobTitle,DepartmentID,HireDate,Salary)
values('Petar','Pan','Pan','Intern',3,'2016-08-28',599.88)

select * from Towns 

select * from Departments

select * from Employees

select * from Towns order by [TownName] asc 

select * from Departments order by [DepartmentName] asc 

select * from Employees order by [Salary] desc 

select [TownName] from Towns

select [DepartmentName] from Departments

select [FirstName], [LastName], [JobTitle], [Salary] from Employees

update Employees set Salary = Salary + 0.1 * Salary 

select [Salary] from [dbo].[Employees]

