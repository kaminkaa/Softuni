--5
select p.Name, p.Price, p.Description
from Products as p
order by p.Price desc, p.Name asc

--6
select i.Name, i.Description, i.OriginCountryId
from Ingredients as i
where i.OriginCountryId in (1,10,20)
order by i.Id asc

--7
select top 15 
i.Name,
i.Description,
c.Name
from Ingredients as i
join Countries as c on c.Id=i.OriginCountryId
where c.Name in ('Bulgaria','Greece')
order by i.Name asc, c.Name asc

--8
select top 10 
p.Name,
p.Description,
avg(f.Rate) as AverageRate,
count(f.Id) as FeedbacksAmount
from Products as p
join Feedbacks as f on f.ProductId=p.Id
group by p.Name, p.Description
order by AverageRate desc,FeedbacksAmount desc

--9
select 
f.ProductId,
f.Rate,
f.Description,
f.CustomerId,
c.Age,
c.Gender
from Feedbacks as f
join Customers as c on c.Id=f.CustomerId
where f.Rate<5
order by f.ProductId desc, f.Rate asc

--10
select 
concat(c.FirstName,' ',c.LastName) as CustomerName,
c.PhoneNumber,
c.Gender
from Customers as c
left join Feedbacks as f on f.CustomerId=c.Id
where f.Id is null
order by c.Id asc

--11
select 
f.ProductId,
concat(c.FirstName,' ',c.LastName) as CustomerName,
isnull(f.Description,'') as FeedbackDescription
from Feedbacks as f
join Customers as c on f.CustomerId=c.Id
join (  select CustomerId ,count(*) as Feedbacks
		from Feedbacks
		group by CustomerId) as cf on cf.CustomerId=c.Id
where cf.Feedbacks>=3
order by f.ProductId asc, CustomerName asc, f.Id asc

--12
select 
c.FirstName,
c.Age,
c.PhoneNumber
from Customers as c
where   (c.Age>=21 and c.FirstName like '%an%') or
		c.PhoneNumber like '%38' or c.CountryId not in (select CountryId from Countries where Countries.Name='Greece')
order by c.FirstName asc, c.Age desc

--13
select 
d.Name as DistributorName,
i.Name as IngredientName,
p.Name as ProductName,
ar.AverageRate
from Distributors as d
join Ingredients as i on i.DistributorId=d.Id
join ProductsIngredients as ip on ip.IngredientId=i.Id
join Products as p on p.Id=ip.ProductId
join (	select 
		f.ProductId,
		avg(f.Rate) as AverageRate
		from Feedbacks as f
		group by f.ProductId
		having avg(f.Rate) between 5 and 8) ar on ar.ProductId=p.Id
order by DistributorName asc, IngredientName asc, ProductName asc

--14
select *
from (  select top 1 with ties 
		co.Name,
		avg(f.Rate) as FeedbackRate
		from Feedbacks as f
		join Customers as c on c.Id=f.CustomerId
		join Countries as co on co.Id=c.CountryId
		group by co.Name
		order by FeedbackRate desc) as cf

--15
select 
c.Name,
di.Distributor
from Countries as c
join Distributors as d on d.CountryId=c.Id
join (	select
		d.Name as Distributor,
		i.DistributorId as DistributorId,
		rank() over (order by count(i.Id)) as IngredientsNumberRank
		from Ingredients as i
		join Distributors as d on d.Id=i.DistributorId
		group by d.Name,i.DistributorId) as di on di.DistributorId=d.Id
where di.IngredientsNumberRank=1
group by c.Name,di.Distributor
order by c.Name asc, di.Distributor asc
