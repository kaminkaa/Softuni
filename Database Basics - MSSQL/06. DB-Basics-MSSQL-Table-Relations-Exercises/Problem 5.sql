create database [Online Store]

use [Online Store]

create table Cities
(
	CityID int not null primary key,
	Name varchar(50)
)

create table Customers
(
	CustomerID int not null primary key,
	Name varchar(50),
	Birthday date,
	CityID int,
	constraint FK_Customers_Cities foreign key (CityID) references Cities(CityID)
)

create table Orders
(
	OrderID int not null primary key,
	CustomerID int not null,
	constraint FK_Orders_Customers foreign key (CustomerID) references Customers(CustomerID)
)

create table ItemTypes
(
	ItemTypeID int not null primary key,
	Name varchar(50) 
)

create table Items
(
	ItemID int not null primary key,
	Name varchar(50),
	ItemTypeID int,
	constraint FK_Items_ItemTypes foreign key (ItemTypeID) references ItemTypes(ItemTypeID) 
)

create table OrderItems
(
	OrderID int,
	ItemID int,
	constraint PK_OrderItems primary key (OrderID,ItemID),
	constraint FK_OrderItems_Orders foreign key (OrderID) references Orders(OrderID), 
	constraint FK_OrderItems_Items foreign key (ItemID) references Items(ItemID)
)