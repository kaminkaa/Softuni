--10
go
create procedure dbo.usp_GetHoldersFullName 
as
	select AccountHolders.FirstName + ' ' + AccountHolders.LastName as 'Full Name'
	from AccountHolders
go

exec usp_GetHoldersFullName 


--11
go
create procedure dbo.usp_GetHoldersWithBalanceHigherThan 
@number money
as
	begin
	select ah.FirstName, ah.LastName
	from AccountHolders as ah
	left join Accounts as a on (ah.Id=a.AccountHolderId)
	group by ah.FirstName, ah.LastName
	having sum(a.Balance)>@number
	end

exec usp_GetHoldersWithBalanceHigherThan 250000


--12
go
create function ufn_CalculateFutureValue 
(@sum money, @rate float, @years int)
returns float
as
	begin
	declare @fv float
	set @fv=@sum*(power((1+@rate),@years))
	return @fv
	end
go

declare @output decimal(10,4)
exec @output = ufn_CalculateFutureValue 1000, 0.1, 5
select @output


--13
go
create proc dbo.usp_CalculateFutureValueForAccount 
@AccountID int,
@rate float
as
	select  a.Id as 'Account Id', 
			ah.FirstName, 
			ah.LastName, 
			a.Balance as 'Current Balance',
			[dbo].[ufn_CalculateFutureValue] (a.Balance,@rate,5) as 'Balance in 5 years'
	from Accounts as a
	join AccountHolders as ah on (a.AccountHolderId=ah.Id)
	where a.Id=@AccountID
go

exec usp_CalculateFutureValueForAccount 1,0.1


--14
go
create proc dbo.usp_DepositMoney 
@AccountId int,
@moneyAccount money
as
	begin transaction

	update Accounts
	set Accounts.Balance += @moneyAccount
	where Accounts.Id=@AccountId 

	if @@ROWCOUNT <> 1
	begin
	raiserror ('Invalid account!',16,1)
	rollback
	end
	else
	commit 
go

exec usp_DepositMoney 5,399


--15
go
create proc dbo.usp_WithdrawMoney 
@AccountId int,
@moneyAccount money
as
	begin transaction

	update Accounts
	set Accounts.Balance -= @moneyAccount
	where Accounts.Id=@AccountId 

	if @@ROWCOUNT <> 1
	begin
	raiserror ('Invalid account!',16,1)
	rollback
	end
	else
	commit 
go

exec usp_WithdrawMoney 5,1000


--16
go
create proc dbo.usp_TransferMoney
@SenderId int,
@ReceiverId int,
@Amount money
as
	exec usp_DepositMoney @ReceiverId , @Amount
	exec usp_WithdrawMoney @SenderId, @Amount
go

exec usp_TransferMoney 5,4,10000


--17
create table Logs
(
	LogId int not null identity primary key,
	AccountId int,
	OldSum money,
	NewSum money,
	constraint FK_Logs_Accounts foreign key (AccountId) references Accounts(Id)
)

go
create trigger tr_BalanceUpdate on Accounts for update
as
begin
	insert into Logs (AccountId,OldSum,NewSum)
	select i.Id, d.Balance as 'OldSum', i.Balance as 'NewSum'
	from inserted as i
	join deleted as d on (i.Id=d.Id)
end

update Accounts
set Balance+=1000
where Id=5


--18
create table NotificationEmails
(
	Id int identity primary key,
	Recipient int,
	Subject varchar(max),
	Body varchar(max) 
)

go
create trigger tr_NotificationEmails_Logs on Logs after insert
as
begin
	insert into NotificationEmails(Recipient,Subject,Body)
	select 
	i.AccountId as 'Recipient',
	concat('Balance change for account: ', convert(varchar(10),i.AccountId)) as 'Subject',
	concat('On ',convert(varchar(50),GETDATE()),' your balance was changed from ',convert(varchar(30),i.OldSum),' to ',convert(varchar(30),i.NewSum)) as 'Body'	   
	from inserted as i
end

