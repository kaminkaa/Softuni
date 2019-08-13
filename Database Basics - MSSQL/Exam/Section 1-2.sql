create database AMS

use AMS 

CREATE TABLE Towns (
	TownID INT,
	TownName VARCHAR(30) NOT NULL,
	CONSTRAINT PK_Towns PRIMARY KEY(TownID)
)

CREATE TABLE Airports (
	AirportID INT,
	AirportName VARCHAR(50) NOT NULL,
	TownID INT NOT NULL,
	CONSTRAINT PK_Airports PRIMARY KEY(AirportID),
	CONSTRAINT FK_Airports_Towns FOREIGN KEY(TownID) REFERENCES Towns(TownID)
)

CREATE TABLE Airlines (
	AirlineID INT,
	AirlineName VARCHAR(30) NOT NULL,
	Nationality VARCHAR(30) NOT NULL,
	Rating INT DEFAULT(0),
	CONSTRAINT PK_Airlines PRIMARY KEY(AirlineID)
)

CREATE TABLE Customers (
	CustomerID INT,
	FirstName VARCHAR(20) NOT NULL,
	LastName VARCHAR(20) NOT NULL,
	DateOfBirth DATE NOT NULL,
	Gender VARCHAR(1) NOT NULL CHECK (Gender='M' OR Gender='F'),
	HomeTownID INT NOT NULL,
	CONSTRAINT PK_Customers PRIMARY KEY(CustomerID),
	CONSTRAINT FK_Customers_Towns FOREIGN KEY(HomeTownID) REFERENCES Towns(TownID)
)

create table Flights
(
	FlightID int not null,
	DepartureTime datetime not null,
	ArrivalTime datetime not null,
	Status varchar(9),
	constraint Check_Status check (Status in ('Departing', 'Delayed', 'Arrived', 'Cancelled')),
	OriginAirportID int,
	DestinationAirportID int,
	AirlineID int,
	constraint PK_Flights primary key (FlightID),
	constraint FK_Flights_Airports_Origin foreign key (OriginAirportID) references Airports(AirportID),
	constraint FK_Flights_Airports_Destination foreign key (DestinationAirportID) references Airports(AirportID),
	constraint FK_Flights_Airlines foreign key (AirlineID) references Airlines(AirlineID)
)

create table Tickets
(
	TicketID int not null,
	Price decimal(8,2) not null,
	Class varchar(6),
	constraint Check_Class check (Class in ('First','Second','Third')),
	Seat varchar(5) not null,
	CustomerID int,
	FlightID int,
	constraint PK_Tickets primary key (TicketID),
	constraint FK_Tickets_Customers foreign key (CustomerID) references Customers(CustomerID),
	constraint FK_Tickets_Flights foreign key (FlightID) references Flights(FlightID)
)

INSERT INTO Towns(TownID, TownName)
VALUES
(1, 'Sofia'),
(2, 'Moscow'),
(3, 'Los Angeles'),
(4, 'Athene'),
(5, 'New York')

INSERT INTO Airports(AirportID, AirportName, TownID)
VALUES
(1, 'Sofia International Airport', 1),
(2, 'New York Airport', 5),
(3, 'Royals Airport', 1),
(4, 'Moscow Central Airport', 2)

INSERT INTO Airlines(AirlineID, AirlineName, Nationality, Rating)
VALUES
(1, 'Royal Airline', 'Bulgarian', 200),
(2, 'Russia Airlines', 'Russian', 150),
(3, 'USA Airlines', 'American', 100),
(4, 'Dubai Airlines', 'Arabian', 149),
(5, 'South African Airlines', 'African', 50),
(6, 'Sofia Air', 'Bulgarian', 199),
(7, 'Bad Airlines', 'Bad', 10)

INSERT INTO Customers(CustomerID, FirstName, LastName, DateOfBirth, Gender, HomeTownID)
VALUES
(1, 'Cassidy', 'Isacc', '19971020', 'F', 1),
(2, 'Jonathan', 'Half', '19830322', 'M', 2),
(3, 'Zack', 'Cody', '19890808', 'M', 4),
(4, 'Joseph', 'Priboi', '19500101', 'M', 5),
(5, 'Ivy', 'Indigo', '19931231', 'F', 1)

insert into Flights
values 
(1,'2016-10-13 06:00:00','2016-10-13 10:00:00','Delayed',1,4,1),
(2,'2016-10-12 12:00:00','2016-10-12 12:01:00','Departing',1,3,2),
(3,'2016-10-14 15:00:00','2016-10-20 04:00:00','Delayed',4,2,4),
(4,'2016-10-12 13:24:00','2016-10-12 16:31:00','Departing',3,1,3),
(5,'2016-10-12 08:11:00','2016-10-12 23:22:00','Departing',4,1,1),
(6,'1995-06-21 12:30:00','1995-06-22 10:00:00','Delayed',1,4,1),
(7,'2016-10-13 06:00:00','2016-10-13 20:30:00','Arrived',2,3,5),
(8,'2016-11-11 13:00:00','2016-11-12 22:00:00','Delayed',4,3,1),
(9,'2015-10-01 12:00:00','2015-12-01 01:00:00','Arrived',1,2,1),
(10,'2016-10-12 19:30:00','2016-10-13 12:30:00','Departing',2,1,7)

insert into Tickets
values
(1,'3000.00','First','233-A',3,8),
(2,'1799.90','Second','123-D',1,1),
(3,'1200.50','Second','12-Z',2,5),
(4,'410.68','Third','45-Q',2,8),
(5,'560.00','Third','201-R',4,6),
(6,'2100.00','Second','13-T',1,9),
(7,'5500.00','First','98-O',2,7)

update Flights 
set AirlineID=1
where Status='Arrived'

update Tickets
set Price = Price + 0.5*Price
where Tickets.FlightID in  (select Flights.FlightID
							from Flights
							where Flights.AirlineID =   (select top 1 AirlineID
														from Airlines
														order by Rating desc))

create table CustomerReviews
(
	ReviewID int,
	ReviewContent varchar(255) not null,
	ReviewGrade tinyint,
	constraint Check_Grade check(ReviewGrade between 0 and 10),
	AirlineID int,
	CustomerID int,
	constraint PK_CustomerReviews primary key (ReviewID),
	constraint FK_CustomerReviews_Airlines foreign key (AirlineID) references Airlines(AirlineID),
	constraint FK_CustomerReviews_Customers foreign key (CustomerID) references Customers(CustomerID)
)

create table CustomerBankAccounts
(
	AccountID int,
	AccountNumber varchar(10) not null,
	constraint uq_AccountNumber unique(AccountNumber),
	Balance decimal(10,2) not null,
	CustomerID int,
	constraint FK_CustomerBankAccounts_Customers foreign key (CustomerID) references Customers(CustomerID)
)

insert into CustomerReviews
values
(1,'Me is very happy. Me likey this airline. Me good.',10,1,1),
(2,'Ja, Ja, Ja... Ja, Gut, Gut, Ja Gut! Sehr Gut!',10,1,4),
(3,'Meh...',5,4,3),
(4,'Well Ive seen better, but Ive certainly seen a lot worse...',7,3,5)

insert into CustomerBankAccounts
values
(1,'123456790','2569.23',1),
(2,'18ABC23672','14004568.23',2),
(3,'F0RG0100N3','19345.20',5)