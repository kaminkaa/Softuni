create table Students
(
	StudentId int not null primary key,
	Name varchar(10) not null
)

insert into Students
values (1,'Mila'),
	   (2,'Toni'),
	   (3,'Ron')

create table Exams
(
	ExamID int not null primary key,
	Name varchar(20) not null
)

insert into Exams 
values (101,'SpringMVC'),
	   (102,'Neo4j'),
	   (103,'Oracle 11g')

create table StudentsExams
(
	StudentID int not null,
	ExamID int not null,
	constraint PK_StudentsExams primary key(StudentID,ExamID),
	constraint FK_StudentsExams_Students foreign key (StudentID) references Students(StudentID),
	constraint FK_StudentsExams_Exams foreign key (ExamID) references Exams(ExamID)
)

insert into StudentsExams
values (1,101), 
	   (1,102),
	   (2,101),
	   (3,103),
	   (2,102),
	   (2,103)