--12
select Countries.CountryCode, Mountains.MountainRange, Peaks.PeakName, Peaks.Elevation
from Countries
join MountainsCountries on (Countries.CountryCode=MountainsCountries.CountryCode)
join Mountains on (MountainsCountries.MountainId=Mountains.Id)
join Peaks on (Mountains.Id=Peaks.MountainId)
where Countries.CountryCode='BG' and Peaks.Elevation>2835
order by Peaks.Elevation desc

--13
select Countries.CountryCode, count(Mountains.MountainRange) as 'MountainRanges'
from Countries
join MountainsCountries on (Countries.CountryCode=MountainsCountries.CountryCode)
join Mountains on (MountainsCountries.MountainId=Mountains.Id)
group by Countries.CountryCode
having Countries.CountryCode in ('US','BG','RU')

--14
select top 5 Countries.CountryName, Rivers.RiverName
from Countries
left join CountriesRivers on (Countries.CountryCode=CountriesRivers.CountryCode)
left join Rivers on (CountriesRivers.RiverId=Rivers.Id)
where Countries.ContinentCode='AF'
order by Countries.CountryName 

--15 
--separate 

--16
select count(cwm.CountryWitoutMountain) as 'CountryCode'
from   (select Countries.CountryCode as 'CountryWitoutMountain'
		from Countries
		left join MountainsCountries on (Countries.CountryCode=MountainsCountries.CountryCode)
		where MountainsCountries.MountainId is null)cwm

--17
select top 5 Countries.CountryName, 
max(Peaks.Elevation) as 'HighestPeakElevation',
max(Rivers.Length) as 'LongestRiverLength'
from Countries
left join CountriesRivers on (Countries.CountryCode=CountriesRivers.CountryCode)
left join Rivers on (CountriesRivers.RiverId=Rivers.Id)
left join MountainsCountries on (Countries.CountryCode=MountainsCountries.CountryCode)
left join Mountains on (MountainsCountries.MountainId=Mountains.Id)
left join Peaks on (Mountains.Id=Peaks.MountainId)
group by Countries.CountryName
order by HighestPeakElevation desc, LongestRiverLength desc, Countries.CountryName asc

--18
-- dense_rank, bez group by!
select m.Country,
case 
when m.PeakName is null then '(no highest peak)'
else m.PeakName
end as 'HighestPeakName',
case 
when m.PeakElevation is null then 0
else m.PeakElevation 
end as 'HighestPeakElevation',
case 
when m.MountainRange is null then '(no mountain)'
else m.MountainRange 
end as 'Mountain'
from	(select Countries.CountryName as 'Country', Peaks.PeakName as 'PeakName', Mountains.MountainRange 'MountainRange',
		Peaks.Elevation as 'PeakElevation',
		DENSE_RANK () over (partition by Countries.CountryName order by Peaks.Elevation desc) as 'ElevationRank'
		from Countries
		left join MountainsCountries on (Countries.CountryCode=MountainsCountries.CountryCode)
		left join Mountains on (MountainsCountries.MountainId=Mountains.Id)
		left join Peaks on (Mountains.Id=Peaks.MountainId)) as m
where m.ElevationRank=1
order by m.Country asc, m.PeakName asc

