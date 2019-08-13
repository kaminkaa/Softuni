create database CarRental

create table Categories 
(
	ID int primary key identity,
	Category varchar(50) not null,
	DailyRate money not null,
	WeeklyRate money,
	MonthlyRate money,
	WeekendRate money
)

create table Cars
(
	ID int primary key identity,
	PlateNumber int not null,
	Make varchar(50),
	Model varchar (50) not null,
	CarYear smallint not null,
	CategoryID int,
	Doors int,
	Picture varbinary(8000),
	Condition varchar(30),
	Available varchar (10) not null
)

create table Employees
(
	ID int primary key identity,
	FirstName varchar(50) not null, 
	LastName varchar(50) not null,
	Title varchar(50) not null,
	Notes text
)

create table Customers
(
	ID int primary key identity,
	DriverLicenceNumber varchar(50) not null,
	FullName varchar(150) not null,
	Address varchar(150),
	City varchar(50),
	ZIPCode int,
	Notes text
)

create table RentalOrders
(
	ID int primary key identity,
	EmployeeID int not null,
	CustomerID int not null,
	CarID int not null,
	CarCondition varchar(30),
	TankLevel float not null,
	KilometrageStart float,
	KilometrageEnd float,
	TotalKilometrage float,
	StartDate date not null,
	EndDate date not null,
	TotalDays int,
	RateApplied money not null,
	TaxRate money,
	OrderStatus varchar (50),
	Notes text
)

insert into Categories
values ('fast car',410.99,3000.00,15000.50,700.99)

insert into Categories
values ('family car',210.99,1500.00,7500.50,350.99)

insert into Categories
values ('business car',310.99,2000.00,10000.50,500.99)

insert into Cars
values (123456,null,'VW',2008,2,5,null,'new','yes')

insert into Cars
values (789123,null,'Ferrari',2012,1,2,null,'old','no')

insert into Cars
values (564789,null,'Lexus',2010,3,4,null,'new','no')

insert into Employees
values ('George','Michael','sales person',null)

insert into Employees
values ('Nicki','Minaj','accounant',null)

insert into Employees
values ('Taylor','Swift','mechanic',null)

insert into Customers
values ('AA124789','James Baucher','Tintqva 15', 'Sofia',1579,null)

insert into Customers
values ('BB987456','J Lo','Hollywood bld 12', 'LA',101156,null)

insert into Customers
values ('CC546327','Rickie Martin','Calle 8', 'Mexico',98765,null)

insert into RentalOrders
values (2,1,3,'new',79.98,1145.98,76.98,15.98,'2017-01-02','2017-02-02',876,500.98,900.98,'confirmed',null)

insert into RentalOrders
values (1,3,2,'old',59.98,2345.98,96.98,65.98,'2017-07-05','2017-02-02',876,500.98,900.98,'confirmed',null)

insert into RentalOrders
values (3,2,1,'new',39.98,9845.98,554.98,45.98,'2017-03-17','2017-02-02',876,500.98,900.98,'confirmed',null)