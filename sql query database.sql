create database bankmanagementsystem;
show databases;
use bankmanagementsystem;

create table signup(formno varchar(20),name varchar(20),father_name varchar(20),
 dob varchar(20),gender varchar(20),email varchar(50),marital_status varchar(20), 
 address varchar(50),city varchar(30),pincode varchar(20),state varchar(30));
 
 show tables;
 
 select * from signup;
 
 create table signuptwo (formno varchar(20),religion varchar(20),
	category varchar(20),income varchar(20),education varchar(20),
    occupation varchar(20),senior varchar(20),account varchar(20),
    pan varchar(20),aadhar varchar(20));
    
select * from signuptwo;

create table signupthree (formno varchar(20),accountType varchar(50),
	cardNumber varchar(25),pinNumber varchar(10),facility varchar(150));
    
select * from signupthree;

create table login (formno varchar(20),cardNumber varchar(25),pinNumber varchar(10));

select * from login;

create table bank(pin varchar(10),date varchar(30),type varchar(20),amount varchar(20));

select * from bank;
