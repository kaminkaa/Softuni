create table Teachers
(
	TeacherID int not null primary key,
	Name varchar(50),
	ManagerID int,
	constraint FK_ManagerID_TeacherID foreign key (ManagerID) references Teachers(TeacherID)
)

insert into Teachers
values (101,'John',null),
	   (102,'Maya',106),
	   (103,'Silvia',106),
	   (104,'Ted',105),
	   (105,'Mark',101),
	   (106,'Greta',101)