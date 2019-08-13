--1
select top 5 Employees.EmployeeID, Employees.JobTitle, Addresses.AddressID, Addresses.AddressText
from Employees
join Addresses on (Employees.AddressId=Addresses.AddressId)
order by Addresses.AddressID asc 

--2
select top 50 Employees.FirstName, Employees.LastName, Towns.Name as 'Town', Addresses.AddressText
from Employees
join Addresses on (Employees.AddressID=Addresses.AddressID)
join Towns on (Addresses.TownID=Towns.TownID)
order by Employees.FirstName asc, Employees.LastName

--3
select Employees.EmployeeID, Employees.FirstName, Employees.LastName, Departments.Name as 'DepartmentName'
from Employees
join Departments on (Employees.DepartmentID=Departments.DepartmentID)
where Departments.Name='Sales'
order by Employees.EmployeeID asc  

--4
select top 5 Employees.EmployeeID, Employees.FirstName, Employees.Salary, Departments.Name as 'DepartmentName'
from Employees
join Departments on (Employees.DepartmentID=Departments.DepartmentID)
where Employees.Salary>15000
order by Departments.DepartmentID asc

--5
select top 3 Employees.EmployeeID, Employees.FirstName
from Employees
left join EmployeesProjects on (Employees.EmployeeID=EmployeesProjects.EmployeeID)
where EmployeesProjects.ProjectID is null
order by Employees.EmployeeID asc

--6
select Employees.FirstName, Employees.LastName, Employees.HireDate, Departments.Name as 'DeptName'
from Employees
inner join Departments on Employees.DepartmentID=Departments.DepartmentID
where Employees.HireDate>'1999-01-01' and Departments.Name in ('Sales','Finance')
order by Employees.HireDate asc

--7
select top 5 Employees.EmployeeID, Employees.FirstName, Projects.Name as 'ProjectName'
from Employees
join EmployeesProjects on (Employees.EmployeeID=EmployeesProjects.EmployeeID)
join Projects on (EmployeesProjects.ProjectID=Projects.ProjectID)
where Projects.StartDate>'2002-08-13' and Projects.EndDate is null 
order by Employees.EmployeeID

--8
select Employees.EmployeeID, Employees.FirstName, 
case 
--when datepart(year,Projects.StartDate)>2005 then NULL
when Projects.StartDate>'2005-01-01' then NULL
else Projects.Name 
end as 'ProjectName'
from Employees
join EmployeesProjects on (Employees.EmployeeID=EmployeesProjects.EmployeeID)
join Projects on (EmployeesProjects.ProjectID=Projects.ProjectID)
where Employees.EmployeeID=24

--9
select e.EmployeeID, e.FirstName, e.ManagerID, m.FirstName as 'ManagerName'
from Employees as e
left join Employees as m on (e.ManagerID=m.EmployeeID)
where e.ManagerID in (3,7)
order by e.EmployeeID

--10
select top 50 e.EmployeeID, e.FirstName + ' ' + e.LastName as 'EmployeeName', m.FirstName + ' ' + m.LastName as 'ManagerName', Departments.Name as 'DepartmentName'
from Employees as e
left join Employees as m on (e.ManagerID=m.EmployeeID)
join Departments on (e.DepartmentID=Departments.DepartmentID)
order by e.EmployeeID

--11
select min(e2.AvgSalary) as 'MinAverageSalary'
from	(select avg(Salary) as 'AvgSalary'
		from Employees
		group by DepartmentID) as e2

