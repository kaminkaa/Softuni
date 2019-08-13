--20
select 
p.Id,
count(i.Id)
from Products as p
join ProductsIngredients as ip on ip.ProductId=p.Id
join Ingredients as i on i.Id=ip.IngredientId
group by p.Id


select 
p.Name,
i.Id
from Products as p
join ProductsIngredients as ip on ip.ProductId=p.Id
join Ingredients as i on i.Id=ip.IngredientId
group by p.Name,i.Id

select 
i.Name,
count(i.DistributorId) as DistributorsAmount
from Ingredients as i
group by i.Name




select 
p.Name,
i.Id
from Products as p
join ProductsIngredients as ip on ip.ProductId=p.Id
join Ingredients as i on i.Id=ip.IngredientId 
join (	select 
		i.DistributorId as Distributor,
		count(i.Id) as IngredientsAmount
		from Ingredients as i
		group by i.DistributorId
		having count(i.Id)=1) as da on da.Ingredient=i.Id


group by p.Name,i.Id




select 
p.Name as ProductName,
d.Name as DistributorName
from Products as p
join ProductsIngredients as ip on ip.ProductId=p.Id
join Ingredients as i on i.Id=ip.IngredientId 
join (	select 
		i.DistributorId as Distributor,
		count(i.Id) as IngredientsAmount
		from Ingredients as i
		group by i.DistributorId
		having count(i.Id)=1) as da on da.Distributor=i.DistributorId
join Distributors as d on d.Id=da.Distributor


