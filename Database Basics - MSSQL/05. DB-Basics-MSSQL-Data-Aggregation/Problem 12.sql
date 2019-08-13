-- option 1:
declare @previousDeposit decimal(8,2)
declare @currentDeposit decimal (8,2)
declare @totalSum decimal(8,2)=0

declare wizardCursor cursor for select DepositAmount from WizzardDeposits
open wizardCursor 
fetch next from wizardCursor into @currentDeposit

while @@FETCH_STATUS=0 
begin

if @previousDeposit is not null
begin 
	set @totalSum += @previousDeposit - @currentDeposit
end

set @previousDeposit=@currentDeposit
fetch next from wizardCursor into @currentDeposit 
end

close wizardCursor
deallocate wizardCursor 

select @totalSum as 'SumDifference'

-- option 2: 
select sum(w.Difference) as 'SumDifference'
from   (select 
		DepositAmount,
		lead(DepositAmount) over (order by Id) as NextDeposit,
		DepositAmount - lead(DepositAmount) over (order by Id) as 'Difference'
		from WizzardDeposits) as w