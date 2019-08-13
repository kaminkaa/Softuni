select FirstName,LastName 
from Employees
where FirstName like 'SA%'

select FirstName,LastName 
from Employees
where LastName like '%ei%'

select FirstName
from Employees
where (DepartmentID=3 or DepartmentID=10) and datepart(year,HireDate) between 1995 and 2005

select FirstName,LastName 
from Employees
where JobTitle not like '%engineer%'

select Name
from Towns
where len(Name)=5 or len(Name)=6 
order by Name asc  

select *
from Towns
where Name like 'M%' or Name like 'K%' or Name like 'B%' or Name like 'E%'
order by Name asc

select *
from Towns
where Name not like 'R%' and Name not like 'B%' and Name not like 'D%' 
order by Name asc

go
create view V_EmployeesHiredAfter2000
as
select FirstName,LastName
from Employees
where datepart(year,HireDate) > 2000 
go

select * from V_EmployeesHiredAfter2000

select FirstName,LastName
from Employees
where len(LastName)=5 