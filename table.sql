use bookinventory;

create table User(
user_id int primary key auto_increment,
user_fname varchar(100),
user_lname varchar(100),
user_email varchar(100),
user_pass varchar(100),
user_mobile varchar(100)
);

insert into User (user_fname,user_lname,user_email,user_pass,user_mobile) 
values ('Aadeesh','Jain','aadeeshjain.91a@yahoo.com','abcd@234','9876543212');

insert into User (user_id,user_fname,user_lname,user_email,user_pass,user_mobile) 
values (2,'Andrew','Jate','andrewjate.df@yahoo.com','andrew@9','9876547542');

select * from User;

create table Location(
id int primary key auto_increment,
user_store varchar(100)
);

insert into Location(user_store)
values ("gurgaon"), ("chennai");

select * from Location;


create table Books(
id int primary key auto_increment,
book_id varchar(100),
book_name varchar(100),
book_count int
);

insert into Books(book_id,book_name,book_count)
values ("111","Abc",100),
("222","Def",100),
("333","Ghi",100);

select * from Books;

create table Details(
id int primary key auto_increment,
user_name varchar(100),
book_id varchar(100),
book_name varchar(100),
book_count int,
store_name varchar(100)
);



select * from Details;

insert into Details(user_name,book_id,book_name,book_count,store_name)
values ("Rachit","111","Abc",14,"Lucknow"),
("Rachit","111","Abc",10,"Agra"),
("Rachit","222","Def",5,"Lucknow"),
("Rachit","333","Ghi",3,"Chennai"),
("Harshad","111","Abc",5,"Lucknow"),
("Harshad","333","Ghi",3,"Pune");

select distinct store_name from Details where user_name="Rachit";

select  book_id, book_name, book_count from Details where user_name="Rachit" and store_name="Lucknow";

update Details set book_count=27 where user_name="Rachit" and store_name="Lucknow" and book_name="Abc";

delete from Details where user_name="Rachit" and store_name="Lucknow" and book_name="Mno";
