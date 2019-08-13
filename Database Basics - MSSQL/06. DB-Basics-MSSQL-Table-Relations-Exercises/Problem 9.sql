select Mountains.MountainRange, Peaks.PeakName, Peaks.Elevation
from Peaks
inner join Mountains on Mountains.Id=Peaks.MountainId
where Mountains.Id=17
order by Peaks.Elevation desc
