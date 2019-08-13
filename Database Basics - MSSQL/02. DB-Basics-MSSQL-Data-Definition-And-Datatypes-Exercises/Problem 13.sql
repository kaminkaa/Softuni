create database Movies

create table Directors
(
	DirectorsID int primary key not null,
	DirectorsName varchar(50) not null,
	Notes text 
)

create table Genres
(
	GenreID int primary key not null,
	GenreName varchar(50) not null,
	Notes text
)

create table Categories
(
	CategoryID int primary key not null,
	CategoryName varchar(50) not null,
	Notes text
)

create table Movies
(
	MovieID int primary key not null,
	Title varchar(50) not null,
	DirectorsID int,
	CopyrightYear smallint, 
	Length smallint,
	GenreID int,
	CategoryID int,
	Rating numeric(3,2),
	Notes text 
)

insert into Directors (DirectorsID,DirectorsName,Notes)
values(01,'John Travalota', null)

insert into Directors (DirectorsID,DirectorsName,Notes)
values(02,'Steven Spielberg', 'good')

insert into Directors (DirectorsID,DirectorsName,Notes)
values(03,'Guy Richie', 'best')

insert into Directors (DirectorsID,DirectorsName,Notes)
values(04,'Adam McKay', null)

insert into Directors (DirectorsID,DirectorsName,Notes)
values(05,'George Miller', null)

insert into Genres 
values(11,'comedy','like')

insert into Genres 
values(12,'romantic','dont like')

insert into Genres 
values(13,'drama',null)

insert into Genres 
values(14,'thriller',null)

insert into Genres 
values(15,'action','like')

insert into Categories
values(21,'best movie',null)

insert into Categories
values(22,'best actor',null)

insert into Categories
values(23,'best actress',null)

insert into Categories
values(24,'best Directors',null)

insert into Categories
values(25,'best soundtrack',null)

insert into Movies(MovieID,Title,DirectorsID,CopyrightYear,Length,GenreID,CategoryID,Rating,Notes)
values(101,'Ironman',03,2002,138,15,21,9.8,null)

insert into Movies(MovieID,Title,DirectorsID,CopyrightYear,Length,GenreID,CategoryID,Rating,Notes)
values(102,'This means war',01,2000,126,11,24,7.8,null)

insert into Movies(MovieID,Title,DirectorsID,CopyrightYear,Length,GenreID,CategoryID,Rating,Notes)
values(103,'Mockingbird',05,2010,110,14,22,8.8,null)

insert into Movies(MovieID,Title,DirectorsID,CopyrightYear,Length,GenreID,CategoryID,Rating,Notes)
values(104,'Hary Potter',02,2011,152,13,23,9.99,null)

insert into Movies(MovieID,Title,DirectorsID,CopyrightYear,Length,GenreID,CategoryID,Rating,Notes)
values(105,'The Martian',04,2016,140,12,25,9.00,null)