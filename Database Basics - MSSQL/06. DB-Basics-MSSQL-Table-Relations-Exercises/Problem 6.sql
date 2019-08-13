create database University
use University

create table Majors
(
	MajorID int not null primary key,
	Name varchar(50)
)

create table Subjects
(
	SubjectID int not null primary key,
	SubjectName varchar(50)
)

create table Students
(
	StudentID int not null primary key,
	StudentNumber int,
	StudentName varchar(50),
	MajorID int,
	constraint FK_Students_Majors foreign key (MajorID) references Majors(MajorID)
)

create table Agenda
(
	StudentID int not null,
	SubjectID int not null,
	constraint PK_Agenda primary key (StudentID,SubjectID),
	constraint FK_Students_Subjects foreign key (StudentID) references Students(StudentID),
	constraint FK_Subjects_Students foreign key (SubjectID) references Subjects(SubjectID)
)

create table Payments
(
	PaymentID int not null primary key,
	PaymentDate date,
	PaymentAmount money,
	StudentID int,
	constraint FK_Payments_Students foreign key (StudentID) references Students(StudentID)
)