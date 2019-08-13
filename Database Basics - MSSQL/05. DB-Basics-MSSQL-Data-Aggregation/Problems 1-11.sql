select count(Id) as 'Count'
from WizzardDeposits 

select max(MagicWandSize) as 'LongestMagicWand'
from WizzardDeposits

select DepositGroup, max(MagicWandSize) as 'LongestMagicWand'
from WizzardDeposits
group by DepositGroup

--problem 4 has separate query 
 
select DepositGroup, sum(DepositAmount) as 'TotalSum'
from WizzardDeposits
group by DepositGroup

select DepositGroup, sum(DepositAmount) as 'TotalSum'
from WizzardDeposits
where MagicWandCreator like '%Ollivander%'
group by DepositGroup

select DepositGroup, sum(DepositAmount) as 'TotalSum'
from WizzardDeposits
where MagicWandCreator like '%Ollivander%'
group by DepositGroup
having sum(DepositAmount)<150000
order by TotalSum desc 

select DepositGroup,MagicWandCreator,min(DepositCharge) as 'MinDepositCharge'
from WizzardDeposits
group by DepositGroup,MagicWandCreator
order by MagicWandCreator asc, DepositGroup asc 

select 
case 
when Age between 0 and 10 then '[0-10]'
when Age between 11 and 20 then '[11-20]'
when Age between 21 and 30 then '[21-30]'
when Age between 31 and 40 then '[31-40]'
when Age between 41 and 50 then '[41-50]'
when Age between 51 and 60 then '[51-60]'
when Age >=61 then '[61+]'
end as 'AgeGroup',
count(Id) as 'WizzardCount' 
from WizzardDeposits
group by 
case 
when Age between 0 and 10 then '[0-10]'
when Age between 11 and 20 then '[11-20]'
when Age between 21 and 30 then '[21-30]'
when Age between 31 and 40 then '[31-40]'
when Age between 41 and 50 then '[41-50]'
when Age between 51 and 60 then '[51-60]'
when Age >=61 then '[61+]'
end 

select substring(FirstName,1,1) as 'FirstLetter'
from WizzardDeposits
group by substring(FirstName,1,1),DepositGroup
having DepositGroup='Troll Chest'

select DepositGroup,IsDepositExpired, avg(DepositInterest) as 'AverageInterest'
from WizzardDeposits
where DepositStartDate>'1985-01-01'
group by DepositGroup,IsDepositExpired
order by DepositGroup desc,IsDepositExpired asc
