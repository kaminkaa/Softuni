--1
select TicketID,Price,Class,Seat
from Tickets
order by TicketID asc

--2
select CustomerID, FirstName + ' ' + LastName as 'FullName', Gender
from Customers
order by FullName asc, CustomerID asc

--3
select FlightID,DepartureTime,ArrivalTime
from Flights 
where Status='Delayed'
order by FlightID asc

--4
select distinct top 5 Airlines.AirlineID,AirlineName,Nationality,Rating
from Airlines
join Flights on (Flights.AirlineID=Airlines.AirlineID)
order by Rating desc, Airlines.AirlineID asc

--5
select Tickets.TicketID, Airports.AirportName as 'Destination', Customers.FirstName + ' ' + Customers.LastName as 'CustomerName'
from Tickets
join  Flights on (Tickets.FlightID=Flights.FlightID)
join Airports on (Airports.AirportID=Flights.DestinationAirportID)
join Customers on (Customers.CustomerID=Tickets.CustomerID)
where Tickets.Price<5000 and Tickets.Class='First'
order by Tickets.TicketID asc

--6
select distinct Customers.CustomerID, FirstName + ' ' + LastName as 'FullName', Towns.TownName as 'HomeTown'
from Flights
join Tickets on (Tickets.FlightID=Flights.FlightID)
join Customers on (Customers.CustomerID=Tickets.CustomerID)
join Towns on (Customers.HomeTownID=Towns.TownID)
join Airports on (Flights.OriginAirportID=Airports.AirportID)
where Customers.HomeTownID=Airports.TownID
order by Customers.CustomerID asc

--7
select distinct 
c.CustomerID,
FirstName + ' ' + LastName as 'FullName',
DATEDIFF(year,c.DateOfBirth,'20160101') as 'Age'
from Customers as c
join Tickets as t on (c.CustomerID=t.CustomerID)
join Flights as f on (f.FlightID=t.FlightID and f.Status='Departing')
Order by Age asc, CustomerID asc

--8
select top 3
Customers.CustomerID, 
FirstName + ' ' + LastName as 'FullName', 
Tickets.Price as 'TicketPrice',
Airports.AirportName as 'Destination'
from Customers
inner join Tickets on (Customers.CustomerID=Tickets.CustomerID)
join Flights on (Flights.FlightID=Tickets.FlightID)
join Airports on (Flights.DestinationAirportID=Airports.AirportID)
where Flights.Status='Delayed'
order by Tickets.Price desc, CustomerID asc

--9
select 
f.FlightID, 
f.DepartureTime,
f.ArrivalTime,
ao.AirportName as 'Origin',
ad.AirportName as 'Destination'
from   (select top 5 *
		from Flights
		where Flights.Status='Departing'
		order by Flights.DepartureTime desc) as f
join Airports as ao on (f.OriginAirportID=ao.AirportID)
join Airports as ad on (f.DestinationAirportID=ad.AirportID)
order by f.DepartureTime asc, f.FlightID asc

--10
select distinct Customers.CustomerID, FirstName + ' ' + LastName as 'FullName',
DATEDIFF(year,Customers.DateOfBirth,'20160101') as 'Age'
from Customers
join Tickets on (Customers.CustomerID=Tickets.CustomerID)
join Flights on (Flights.FlightID=Tickets.FlightID and Flights.Status='Arrived')
where DATEDIFF(year,Customers.DateOfBirth,'20160101')<21
order by Age desc, Customers.CustomerID asc

--11
select 
a.AirportID,
a.AirportName,
count(t.TicketID) as 'Passengers'
from Airports as a 
join Flights as f on (f.OriginAirportID=a.AirportID and f.Status='Departing') 
join Tickets as t on (t.FlightID=f.FlightID) 
group by a.AirportID,a.AirportName
order by a.AirportID
