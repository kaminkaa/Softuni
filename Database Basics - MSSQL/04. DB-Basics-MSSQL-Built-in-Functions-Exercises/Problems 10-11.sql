select CountryName,IsoCode 
from Countries
where (len(CountryName) - len(replace(CountryName,'A','')))>=3 
order by IsoCode 

select PeakName,RiverName, lower(concat(left(PeakName,len(PeakName)-1),RiverName)) as 'Mix'
from Peaks,Rivers 
where right(PeakName,1)=left(RiverName,1) 
order by Mix asc