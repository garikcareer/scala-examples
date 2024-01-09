drop database warehouseDB;
create database if not exists warehouseDB;
use warehouseDB;
create table warehouse (
    id integer primary key auto_increment,
    name varchar(40) not null,
    location varchar(100) not null
);

INSERT INTO warehouse (name, location) VALUES ('Costco Warehouse', 'New York');
SELECT * FROM warehouse;
