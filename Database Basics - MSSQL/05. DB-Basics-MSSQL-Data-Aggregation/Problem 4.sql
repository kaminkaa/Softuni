-- option 1:
select DepositGroup
from WizzardDeposits
group by DepositGroup 
having avg(MagicWandSize)=(select min(s.a) 
						   from (select avg(MagicWandSize) as A
								 from WizzardDeposits
								 group by DepositGroup) as S)


-- option 2:								 
select top 1 with ties DepositGroup
from WizzardDeposits
group by DepositGroup
order by avg(MagicWandSize) 