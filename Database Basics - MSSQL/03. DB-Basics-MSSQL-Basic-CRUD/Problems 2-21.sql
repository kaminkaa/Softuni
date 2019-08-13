select * from Departments

select [Name] from Departments

select [FirstName],[LastName],[Salary] from Employees 

select FirstName, MiddleName, LastName from Employees 

select FirstName + '.' + LastName + '@softuni.bg' as 'Full Email Address'
from Employees

select distinct Salary from Employees

select * from Employees where JobTitle='Sales Representative'

select FirstName,LastName,JobTitle from Employees where Salary between 20000 and 30000

select FirstName + ' ' + isnull(MiddleName,'') + ' ' + LastName as 'Full Name'
from Employees where Salary=25000 or Salary=14000 or Salary=12500 or Salary=23600

select FirstName,Lastname from Employees where ManagerID is null 

select FirstName,LastName,Salary from Employees where Salary>50000 order by Salary desc 

select top 5 FirstName, LastName from Employees order by Salary desc

select FirstName, LastName from Employees where not (DepartmentID=4) 

select * from Employees order by Salary desc, FirstName asc, LastName desc, MiddleName asc 

go
create view v_EmployeesSalaries
as
select FirstName,LastName,Salary from Employees
go

select * from v_EmployeesSalaries

go
create view v_EmployeeNameJobTitle
as
select FirstName + ' ' + isnull(MiddleName,'') + ' ' + LastName as 'Full Name', JobTitle as 'Job Title' from Employees 
go 

select * from v_EmployeeNameJobTitle

select distinct JobTitle from Employees

select top 10 * from Projects order by StartDate asc, Name asc 

select top 7 FirstName,LastName,HireDate from Employees order by HireDate desc

update Employees 
set Salary=Salary +(0.12 * Salary)
where DepartmentID=1 or DepartmentID=2 or DepartmentID=4 or DepartmentID=11

select Salary from Employees




