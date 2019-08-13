create database Minions

create table Minions
(
	ID int not null primary key, 
	Name varchar(50),
	Age int
)

create table Towns
(
	TownID int not null primary key,
	Name varchar(50)
)

alter table Minions
add TownID int

alter table Minions 
add constraint for_key
foreign key (TownID)
references Towns(TownID) 

insert into Towns(TownID,Name)
values (1,'Sofia') 

insert into Towns(TownID,Name)
values (2,'Plovdiv') 

insert into Towns(TownID,Name)
values (3,'Varna') 

insert into Minions(ID,Name,Age,TownID)
values (1,'Kevin',22,1)

insert into Minions(ID,Name,Age,TownID)
values (2,'Bob',15,3)

insert into Minions(ID,Name,Age,TownID)
values (3,'Stuart',null,2)

truncate table Minions 

drop table Minions 

drop table Towns 

-- my version:
create table People
(
	ID int primary key identity not null,
	Name varchar(200) not null,
	Picture varbinary(2000), 
	Height numeric(4,2),
	Weight numeric(4,2),
	Gender char(1) not null, 
	Birthdate date not null,
	Biography text 
)

-- correct version:
create table People
(
	ID int primary key identity,
	Name nvarchar(200) not null,
	Picture varbinary(max), 
	Height float,
	Weight float,
	Gender char(1) not null check(Gender in ('m','f')), 
	Birthdate date not null,
	Biography nvarchar(max)
)

insert into People (Name,Picture,Height,Weight,Gender,Birthdate,Biography)
values ('Brad Pit',null,1.73,80.3,'m','19731005','he is an actor')

insert into People (Name,Picture,Height,Weight,Gender,Birthdate,Biography)
values ('Naomi Cambel',null,1.80,55.7,'f','19850316','she is a model')

insert into People (Name,Picture,Height,Weight,Gender,Birthdate,Biography)
values ('Robert Jnr',null,null,null,'m','19661129','he is iron man')

insert into People (Name,Picture,Height,Weight,Gender,Birthdate,Biography)
values ('Jackson',null,1.83,70.3,'m','19680725',null)

insert into People (Name,Picture,Height,Weight,Gender,Birthdate,Biography)
values ('Chris Pratt',null,1.93,89.3,'m','19770604','he is galaxy guardian')

