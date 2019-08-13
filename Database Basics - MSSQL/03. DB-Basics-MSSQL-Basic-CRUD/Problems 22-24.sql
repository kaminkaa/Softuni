select PeakName from Peaks order by PeakName asc 

select top 30 CountryName,Population from Countries where ContinentCode='EU' order by Population desc, CountryName asc 

select CountryName,CountryCode,
case 
when CurrencyCode='EUR' then 'Euro'
else 'Not Euro'
end   as 'Currency'
from Countries order by CountryName asc 
