--16
go
create view v_UserWithCountries 
as
select 
concat(c.FirstName,' ',c.LastName) as CustomerName,
c.Age,
c.Gender,
co.Name as CountryName
from Customers as c
join Countries as co on co.Id=c.CountryId
go

SELECT TOP 5 *
  FROM v_UserWithCountries
 ORDER BY Age

--17
go
create function dbo.udf_GetRating (@Name nvarchar(25))
returns varchar(10)
as
begin
	declare @rating varchar(10) = (select
									case 
									when avg(f.Rate)<5.00 then 'Bad'
									when avg(f.Rate) between 5 and 8 then 'Average'
									when avg(f.Rate)>8 then 'Good'
									else 'No ratings'
									end as Rating
									from Feedbacks as f
									join Products as p on p.Id=f.ProductId and p.Name=@Name)
	return @rating 
end
go

SELECT TOP 5 Id, Name, dbo.udf_GetRating(Name)
  FROM Products
 ORDER BY Id

 --18
 go
 create procedure dbo.usp_SendFeedback
 @CustomerId int,
 @ProductId int,
 @Rate decimal(10,2),
 @Description nvarchar(255)
 as
	begin transaction 
		declare @FeedbacksAmount int
		set @FeedbacksAmount = (select count(f.Id) from Feedbacks as f where f.CustomerId=@CustomerId)

		insert into Feedbacks(Description,Rate,ProductId,CustomerId)
		values(@Description,@Rate,@ProductId,@CustomerId)

		if @FeedbacksAmount >=3
		begin
		rollback 
		raiserror('You are limited to only 3 feedbacks per product!',16,1)
		return
		end

		commit

EXEC usp_SendFeedback 1, 5, 7.50, 'Average experience';
SELECT COUNT(*) FROM Feedbacks WHERE CustomerId = 1 AND ProductId = 5;

--19
go
create trigger tr_Delete_Relations on Products instead of delete
as

	delete from ProductsIngredients
	where ProductId = ( select d.Id from deleted as d)

	update Feedbacks
	set ProductId=Null 
	where ProductId = ( select d.Id from deleted as d)

	delete from Products
	where Id = ( select d.Id from deleted as d)


DELETE FROM Products WHERE Id = 7