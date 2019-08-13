alter table Departments 
alter column ManagerID int null

select Employees.EmployeeID
from Employees
join Departments on Employees.DepartmentID=Departments.DepartmentID
where Departments.Name in ('Production','Production Control')

--delete these employees from the projects they were invloved in:
delete from EmployeesProjects
where EmployeeID in (select Employees.EmployeeID
					 from Employees
					 join Departments on Employees.DepartmentID=Departments.DepartmentID
					 where Departments.Name in ('Production','Production Control'))

--check if the employees that must be deleted are managers. if so, say they wont be anymore. 
update Employees
set ManagerID = null 
where ManagerID in  (select Employees.EmployeeID
					 from Employees
					 join Departments on Employees.DepartmentID=Departments.DepartmentID
					 where Departments.Name in ('Production','Production Control'))

--check if the employees that must be deleted are managers of departments. if so, say they wont be anymore. 
update Departments
set ManagerID = null 
where ManagerID in  (select Employees.EmployeeID
					 from Employees
					 join Departments on Employees.DepartmentID=Departments.DepartmentID
					 where Departments.Name in ('Production','Production Control'))

--now the employees can be deleted
delete from Employees
where EmployeeID in (select Employees.EmployeeID
					 from Employees
					 join Departments on Employees.DepartmentID=Departments.DepartmentID
					 where Departments.Name in ('Production','Production Control'))

--and the departments can be deleted
delete from Departments
where Departments.Name in ('Production', 'Production Control')