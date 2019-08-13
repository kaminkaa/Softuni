--1
create proc dbo.usp_SubmitReview 
@CustomerID int,
@ReviewContent varchar(255),
@ReviewGrade tinyint,
@AirlineName varchar(30)
as
begin
	begin transaction
	declare @AirlineID int = (select AirlineID from Airlines where AirlineName=@AirlineName)
	if @AirlineID is null
	begin 
		rollback
		raiserror('Airline does not exist.',16,1)
		return
	end
	declare @ReviewID int = isnull((select max(ReviewID)from CustomerReviews),0) + 1 
	insert into CustomerReviews(ReviewID,ReviewContent,ReviewGrade,AirlineID,CustomerID)
	values (@ReviewID,@ReviewContent,@ReviewGrade,@AirlineID,@CustomerID)
	commit
end

exec usp_SubmitReview 1,'Me is very happy. Me likey this airline. Me good.',10,'Royal Airline'


--2
go
create proc dbo.usp_PurchaseTicket
@CustomerID int,
@FlightID int,
@TicketPrice decimal(8,2),
@Class varchar(6),
@Seat varchar(5)
as
begin
	begin transaction 

	update CustomerBankAccounts
	set Balance -= @TicketPrice
	where CustomerID=@CustomerID

	declare @AccountBalance decimal(10,2) = (select Balance from CustomerBankAccounts where CustomerID=@CustomerID) 

	if @AccountBalance<=0 or @AccountBalance is null
	begin 
		rollback;
		throw 50001,'Insufficient bank account balance for ticket purchase.',1;
		return		
	end
	
	declare @TicketID int = isnull((select max(TicketID)from Tickets),0) + 1 
	insert into Tickets(TicketID,Price,Class,Seat,CustomerID,FlightID)
	values(@TicketID,@TicketPrice,@Class,@Seat,@CustomerID,@FlightID)
	commit
end

exec dbo.usp_PurchaseTicket 1,7,'9000.00','First','98-O'