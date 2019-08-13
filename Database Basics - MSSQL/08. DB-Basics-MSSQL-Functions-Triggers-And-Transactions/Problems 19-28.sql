--19 --Rows must be ordered by cash in descending order!!!!!!!!!!!--
go
create function ufn_CashInUsersGames (@GameName nvarchar(50))
returns @SumCashTable table (SumCash money)
as
begin
insert into @SumCashTable (SumCash)
select sum(rn.Cash) as 'SumCash'
from    (select GameId, Cash,
		ROW_NUMBER() over (partition by GameId order by Cash desc) as 'RowNumber'
		from UsersGames
		right join Games on (UsersGames.GameId=Games.Id)
		where Games.Name=@GameName) as rn
		where (rn.RowNumber%2<>0)
return
end
go

select * from ufn_CashInUsersGames ('Love in a mist')


--20
