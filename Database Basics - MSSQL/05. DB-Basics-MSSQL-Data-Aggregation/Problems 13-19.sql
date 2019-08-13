select DepartmentID, sum(Salary) as 'TotalSalary'
from Employees
group by DepartmentID
order by DepartmentID 

select DepartmentID, min(Salary)
from Employees
where HireDate>'2000-01-01'
group by DepartmentID
having DepartmentID=2 or DepartmentID=5 or DepartmentID=7 

select *
into NewTable
from Employees
where Salary>30000
---
delete from NewTable
where ManagerID=42
---
update NewTable
set Salary=Salary+5000
where DepartmentID=1
---
select DepartmentID, avg(Salary) as 'AverageSalary'
from NewTable
group by DepartmentID

select DepartmentID, max(Salary) as 'MaxSalary'
from Employees
group by DepartmentID
having max(Salary) not between 30000 and 70000

select count(Salary) as 'Count'
from Employees
where ManagerID is null 

-- problem 18 separate

select top 10 FirstName,LastName,DepartmentID
from Employees as empl1
where empl1.Salary>(select avg(empl2.Salary) 
					from Employees as empl2
					where empl1.DepartmentID=empl2.DepartmentID
					group by DepartmentID)
order by DepartmentID