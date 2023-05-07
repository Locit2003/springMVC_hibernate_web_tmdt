CREATE DATABASE DB_web_btl
GO
USE DB_web_btl
GO
CREATE TABLE [role](
id int IDENTITY(1,1) NOT NULL primary key,
name varchar(50) NULL,
)
GO
CREATE TABLE users(
id int IDENTITY(1,1) NOT NULL primary key,
username varchar(45) NULL,
password varchar(200) NULL,
enabled bit NULL,
)
GO
CREATE TABLE users_roles(
id int IDENTITY(1,1) NOT NULL primary key,
userId int NULL foreign key references users(id),
roleId int NULL foreign key references [role](id),
)
GO
INSERT [role] VALUES (N'ROLE_ADMIN')
GO
INSERT [role] VALUES (N'ROLE_USER')
GO
INSERT users VALUES (N'admin', N'$2a$12$s8FyYcAauHqILMBcI6x0BepO5JI.9/C16QRYMswF7
Avt0rRkOiR0u', 1)
GO
INSERT users VALUES (N'user', N'$2a$12$s8FyYcAauHqILMBcI6x0BepO5JI.9/C16QRYMswF7A
vt0rRkOiR0u', 1)
GO
INSERT users_roles (userId, roleId) VALUES (1, 1)
GO
INSERT users_roles (userId, roleId) VALUES (1, 2)
GO
INSERT users_roles (userId, roleId) VALUES (2, 2)

select * from role;