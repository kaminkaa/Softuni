--29
select p.PeakName, m.MountainRange as 'Mountain', p.Elevation
from Peaks as p 
join Mountains as m on (p.MountainId=m.Id)
order by p.Elevation desc, p.PeakName asc


--30
select p.PeakName, m.MountainRange as 'Mountain', c.CountryName, ct.ContinentName
from Peaks as p 
join Mountains as m on (p.MountainId=m.Id)
join MountainsCountries as mc on (m.Id=mc.MountainId)
join Countries as c on (mc.CountryCode=c.CountryCode)
join Continents as ct on (c.ContinentCode=ct.ContinentCode)
order by p.PeakName asc, c.CountryName asc


--31
select 
c.CountryName, 
ct.ContinentName,
isnull(count(r.Id),0) as RiversCount,
isnull(sum(r.Length),0) as TotalLength
from Countries as c
left join CountriesRivers as cr on cr.CountryCode=c.CountryCode
left join Rivers as r on r.Id=cr.RiverId
join Continents as ct on ct.ContinentCode=c.ContinentCode
group by c.CountryName, ct.ContinentName
order by RiversCount desc, TotalLength desc, c.CountryName asc