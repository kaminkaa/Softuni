--1
create database Bakery
use Bakery

create table Countries
(
	Id int identity,
	Name nvarchar(50),
	constraint Unq_Country_Name unique(Name),
	constraint PK_Countries primary key (Id)
)

create table Products
(
	Id int identity,
	Name nvarchar(25),
	constraint Unq_Product_Name unique(Name),
	Description nvarchar(250),
	Recipe nvarchar(max),
	Price money,
	constraint Check_Price check(Price>=0),
	constraint PK_Products primary key (Id)
)

create table Customers
(
	Id int identity,
	FirstName nvarchar(25),
	LastName nvarchar(25),
	Gender char(1),
	constraint Check_Gender check(Gender in ('M','F')),
	Age int,
	PhoneNumber varchar(10),
	constraint Length_PhoneNumber check(len(PhoneNumber)=10),
	CountryId int,
	constraint PK_Customers primary key (Id),
	constraint FK_Customers_Countries foreign key (CountryID) references Countries(Id)
)

create table Feedbacks
(
	Id int identity,
	Description nvarchar(255),
	Rate decimal (10,2),
	constraint Check_Rate check(Rate between 0.00 and 10.00),
	ProductId int,
	CustomerId int,
	constraint PK_Feedbacks primary key (Id),
	constraint FK_Feedbacks_Products foreign key (ProductId) references Products(Id),
	constraint FK_Feedbacks_Customers foreign key (CustomerId) references Customers(Id)
)

create table Distributors
(
	Id int identity,
	Name nvarchar(25),
	constraint Unq_Distributor_Name unique(Name),
	AddressText nvarchar(30),
	Summary nvarchar(200),
	CountryId int,
	constraint PK_Distributors primary key (Id),
	constraint FK_Distributors_Countries foreign key (CountryId) references Countries(Id)
)

create table Ingredients
(
	Id int identity,
	Name nvarchar(30),
	Description nvarchar(200),
	OriginCountryId int,
	DistributorId int,
	constraint PK_Ingredients primary key (Id),
	constraint FK_Ingredients_Countries foreign key (OriginCountryId) references Countries(Id),
	constraint FK_Ingredients_Distributors foreign key (DistributorId) references Distributors(Id),
)

create table ProductsIngredients
(
	ProductId int,
	IngredientId int,
	constraint PK_ProductsIngredients primary key(ProductId,IngredientId),
	constraint FK_ProductsIngredients_Products foreign key (ProductId) references Products(Id),
	constraint FK_ProductsIngredients_Ingredients foreign key (IngredientId) references Ingredients(Id),
)