select top 50 Name,cast(Start as date) as 'Started'
from Games
where datepart(year,Start) in (2011,2012)
order by Start asc, Name asc 

select top 50 Name,format(Start,'yyyy-MM-dd')
from Games
where datepart(year,Start) in (2011,2012)
order by Start asc, Name asc 

select Username, right(Email,len(Email)-charindex('@',Email)) as 'Email Provider'
from Users
order by [Email Provider] asc,Username asc

select Username,IpAddress
from Users
where IpAddress like '___.1%.%.___'
order by Username asc

select Name,
case
when format(Start,'hh:mm:ss')>='00:00:00' and format(Start,'hh:mm:ss')<'12:00:00' then 'Morning'
when format(Start,'hh:mm:ss')>='12:00:00' and format(Start,'hh:mm:ss')<'18:00:00' then 'Afternoon'
when format(Start,'hh:mm:ss')>='18:00:00' and format(Start,'hh:mm:ss')<'24:00:00' then 'Evening'
end as 'Part of the Day',
case 
when Duration<=3 then 'Extra Short'
when Duration between 4 and 6 then 'Short'
when Duration>6 then 'Long'
else 'Extra Long'
end as 'Duration'
from Games 
order by Name asc, Duration asc, [Part of the Day] asc

select Name,
case
when CONVERT(VARCHAR,Start,108)>='00:00:00' and CONVERT(VARCHAR,Start,108)<'12:00:00' then 'Morning'
when CONVERT(VARCHAR,Start,108)>='12:00:00' and CONVERT(VARCHAR,Start,108)<'18:00:00' then 'Afternoon'
when CONVERT(VARCHAR,Start,108)>='18:00:00' and CONVERT(VARCHAR,Start,108)<'24:00:00' then 'Evening'
end as 'Part of the Day',
case 
when Duration<=3 then 'Extra Short'
when Duration between 4 and 6 then 'Short'
when Duration>6 then 'Long'
else 'Extra Long'
end as 'Duration'
from Games 
order by Name asc, Duration asc, [Part of the Day] asc