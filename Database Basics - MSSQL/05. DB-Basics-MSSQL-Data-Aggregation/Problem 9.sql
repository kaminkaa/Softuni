with AgeGroups_CTE(AgeGroup,Id)
as (select 
case 
when Age between 0 and 10 then '[0-10]'
when Age between 11 and 20 then '[11-20]'
when Age between 21 and 30 then '[21-30]'
when Age between 31 and 40 then '[31-40]'
when Age between 41 and 50 then '[41-50]'
when Age between 51 and 60 then '[51-60]'
when Age >=61 then '[61+]'
end, Id 
from WizzardDeposits)

select AgeGroup, Count(Id) 
from AgeGroups_CTE
group by AgeGroup

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
group by case 
when Age between 0 and 10 then '[0-10]'
when Age between 11 and 20 then '[11-20]'
when Age between 21 and 30 then '[21-30]'
when Age between 31 and 40 then '[31-40]'
when Age between 41 and 50 then '[41-50]'
when Age between 51 and 60 then '[51-60]'
when Age >=61 then '[61+]'
end 