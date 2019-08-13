create database ex_06

use ex_06 

create table Passports
(
	PassportId int not null,
	PassportNumber varchar(10) not null,
	constraint PK_Passports primary key (PassportId)
)

insert into Passports
values (101,'N34FG21B'),
	   (102,'K65LO4R7'),
	   (103,'ZE657QP2')

create table Persons
(
	PersonId int not null,
	FirstName varchar(15) not null,
	Salary money not null,
	PassportId int not null unique,
	constraint PK_Persons primary key (PersonId),
	constraint FK_PersonsPassports foreign key (PassportId) references Passports(PassportId)
)

insert into Persons 
values (1,'Roberto',43300.00,102),
	   (2,'Tom',56100.00,103),
	   (3,'Yana',60200.00,101)	



