--1
create table ArrivedFlights
(
	FlightID int,
	ArrivalTime datetime not null,
	Origin varchar(50) not null,
	Destination varchar(50) not null,
	Passengers int not null
)

go
create trigger tr_ArrivedFlightsUpdate on Flights after update
as
		insert into ArrivedFlights (FlightID,ArrivalTime,Origin,Destination,Passengers)
		select 
		inserted.FlightID,
		ArrivalTime, 
		ao.AirportName as 'Origin', 
		ad.AirportName as 'Destination',
		(select count(*) from Tickets where FlightID=inserted.FlightID ) as 'Passengers'
		from inserted
		join Airports as ao on (ao.AirportID=inserted.OriginAirportID)
		join Airports as ad on (ad.AirportID=inserted.DestinationAirportID)
		where inserted.Status='Arrived'

update Flights
set Status='Arrived'
where FlightID=7