-- 15
select us.ContinentCode, us.CurrencyCode, us.CurrencyUsage
from
	(select c.ContinentCode, c.CurrencyCode, count(*) as 'CurrencyUsage'
	from Countries as c
	group by c.ContinentCode, c.CurrencyCode
	having count(*)>1) as us
inner join 
	(select u.ContinentCode, max(u.Usage) as 'MaxUsage'
	 from 
		(select c.ContinentCode, c.CurrencyCode, count(*) as 'Usage'
		from Countries as c
		group by c.ContinentCode, c.CurrencyCode) as u 
		group by u.ContinentCode) as mu
on us.ContinentCode=mu.ContinentCode and us.CurrencyUsage=mu.MaxUsage
order by us.ContinentCode asc