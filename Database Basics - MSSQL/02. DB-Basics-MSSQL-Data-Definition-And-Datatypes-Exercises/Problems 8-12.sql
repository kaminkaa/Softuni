create table Users
(
	ID int identity not null,
	Username varchar(30) unique not null, 
	Password varchar(26) not null,
	ProfilePicture varbinary(max),
	LastLoginTime smalldatetime,
	IsDeleted bit
)

alter table Users
add constraint pk_id
primary key (ID)

insert into Users(Username,Password,ProfilePicture,LastLoginTime,IsDeleted)
values ('redhot','peppers',null,'1955-12-13 12:43:00',0)

insert into Users(Username,Password,ProfilePicture,LastLoginTime,IsDeleted)
values ('nickelback','rockstar',null,'1995-11-13 10:03:00',1)

insert into Users(Username,Password,ProfilePicture,LastLoginTime,IsDeleted)
values ('bon jovi','notright',null,'2055-02-17 13:53:59',0)

insert into Users(Username,Password,ProfilePicture,LastLoginTime,IsDeleted)
values ('drwho','sherlock',null,'2015-09-15 02:13:00',1)

insert into Users(Username,Password,ProfilePicture,LastLoginTime,IsDeleted)
values ('kitty','hello',null,'2033-04-10 16:25:00',0)

alter table Users
drop constraint pk_id

alter table Users
add constraint pk_id_username
primary key (ID,Username)

alter table Users
add constraint check_password
check (len(Password)>=5) 

alter table Users
add constraint def_val
default getdate() for LastLoginTime

alter table Users
drop constraint pk_id_username 

alter table Users
add constraint pk_id
primary key (ID)

alter table Users
add constraint uniq_username
check (len(Username)>=3)


