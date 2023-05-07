CREATE DATABASE DB_web_btl
GO
USE DB_web_btl
GO
CREATE TABLE [Role](
Id int IDENTITY(1,1) NOT NULL primary key,
Name varchar(50) NULL,
)
GO
CREATE TABLE Account(
Id int IDENTITY(1,1) NOT NULL primary key,
Username varchar(45) NULL,
Email varchar(50) NULL,
Phone varchar(50) Null,
[Password] varchar(100) NULL,
Fullname varchar(100) NULL,
[Address] varchar(100) NULL,
Gender bit Null,
Birthday datetime NULL,
[Enabled] bit NULL,
)
GO
CREATE TABLE Account_roles(
Id int IDENTITY(1,1) NOT NULL primary key,
UserId int NULL foreign key references Account(Id),
RoleId int NULL foreign key references [Role](Id),
)
GO
INSERT [Role] VALUES (N'ROLE_ADMIN')
GO
INSERT [Role] VALUES (N'ROLE_USER')
GO
INSERT Account VALUES (N'admin',N'admin@gmail.com', N'0399999993', N'$2a$12$fgQHk4ioj5KmleObfoj/7OzSW0DUdkB53erRQdXxx9GW5yG2TdnGK','Nguyen','Ha Noi - Viet Nam',1,'1997-01-12', 1)
GO
INSERT Account VALUES (N'user',N'user@gmail.com', N'0399999999', N'$2a$12$fgQHk4ioj5KmleObfoj/7OzSW0DUdkB53erRQdXxx9GW5yG2TdnGK','Hoa','TP HCM - Viet Nam',0,'1999-01-12', 1)
GO
INSERT Account_roles (UserId, RoleId) VALUES (1, 1)
GO
INSERT Account_roles (UserId, RoleId) VALUES (1, 2)
GO
INSERT Account_roles (UserId, RoleId) VALUES (2, 2)

select * from [Role];
select * from Account;
select * from Account_roles;