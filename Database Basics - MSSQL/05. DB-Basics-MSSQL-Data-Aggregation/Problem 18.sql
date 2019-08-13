-- my atempt: 
select DepartmentID, max(Salary) as 'ThirdHighestSalary'
from Employees Emp1
where 2 = 	(select 
		    count(distinct(Emp2.Salary))
			from Employees Emp2
			where Emp2.Salary > Emp1.Salary 
			and Emp1.DepartmentID=Emp2.DepartmentID) -- and departmentid da sa ednakvi, ne s group by 
group by DepartmentID

-- working option:
select sr.DepartmentID,sr.MaxSalary
from   (select 
		DepartmentId,
		max(Salary) as 'MaxSalary',
		DENSE_RANK() over (partition by DepartmentId order by Salary desc) as SalaryRank
		from Employees
		group by DepartmentID,Salary) as sr
where sr.SalaryRank=3