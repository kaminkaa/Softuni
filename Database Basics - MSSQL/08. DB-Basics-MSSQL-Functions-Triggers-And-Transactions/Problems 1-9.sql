--1
go
create procedure dbo.usp_GetEmployeesSalaryAbove35000 
as
	select Employees.FirstName, Employees.LastName 
	from Employees 
	where Employees.Salary>35000
go

exec usp_GetEmployeesSalaryAbove35000 


--2
go
create procedure dbo.usp_GetEmployeesSalaryAboveNumber 
@number money
as
	select Employees.FirstName, Employees.LastName 
	from Employees 
	where Employees.Salary>=@number
go

exec usp_GetEmployeesSalaryAboveNumber 48100 


--3
go
create procedure dbo.usp_GetTownsStartingWith 
@string varchar(4)
as
	select Towns.Name as 'Town'
	from Towns
	where Towns.Name like @string + '%'
go

exec usp_GetTownsStartingWith 'b'


--4
go
create procedure usp_GetEmployeesFromTown 
@Town varchar(30)
as
	select Employees.FirstName, Employees.LastName
	from Employees
	join Addresses on (Employees.AddressID=Addresses.AddressID)
	join Towns on (Addresses.TownID=Towns.TownID)
	where Towns.Name=@Town
go

exec usp_GetEmployeesFromTown 'Sofia'


--5
go
create function ufn_GetSalaryLevel(@Salary money) 
returns varchar(30)
as
begin 
	declare @SalaryLevel varchar(30)
	if @Salary<30000 
		set @SalaryLevel='Low'
	else if @Salary between 30000 and 50000
		set @SalaryLevel='Average'
	else 
		set @SalaryLevel='High'
	return @SalaryLevel 
end
go

select Employees.Salary, [dbo].[ufn_GetSalaryLevel](Employees.Salary) as 'Salary Level'
from Employees


--6
go
create procedure usp_EmployeesBySalaryLevel
@SalaryLevel varchar(30)
as
	select Employees.FirstName, Employees.LastName
	from Employees
	where [dbo].[ufn_GetSalaryLevel](Employees.Salary)=@SalaryLevel
go 

exec usp_EmployeesBySalaryLevel 'high'


--7
go 
create function ufn_IsWordComprised(@setOfLetters varchar(10), @word varchar(30))
returns bit
as
begin
	declare @length int = len(@word) 
	declare @index int = 1

	while (@index<=@length)
	begin
	declare @char char(1) = substring(@word, @index, 1)
	if (charindex (@char,@setOfLetters)<=0)
	begin
	return 0
	end
	set @index += 1
	end
	return 1
end
go

select [dbo].[ufn_IsWordComprised]('oistmiahf','Sofia') as 'Result'


--8
-- separate 


--9
go
create procedure usp_AssignProject
@EmloyeeId int,
@ProjectID int
as
begin
declare @count int = 0
set @count =  (select count(EmployeesProjects.ProjectID) 
			  from EmployeesProjects
			  where EmployeesProjects.EmployeeID=@EmloyeeId)

begin transaction

insert into EmployeesProjects
values(@EmloyeeId,@ProjectID)

if @count>=3
	begin
	raiserror('The employee has too many projects!',16,1)
	rollback 
	end
else
commit 
end
go 

exec usp_AssignProject 2,15