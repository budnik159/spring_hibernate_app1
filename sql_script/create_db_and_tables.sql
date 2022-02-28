CREATE DATABASE  university_db;
USE university_db;


CREATE TABLE university_group (
  id int NOT NULL AUTO_INCREMENT,
  group_name varchar(50),
  PRIMARY KEY (id)
);

CREATE TABLE student (
	id int NOT NULL AUTO_INCREMENT,
    name varchar(30),
    surname varchar(30),
    receipt_date Date,
    university_group_id int,
    PRIMARY KEY(id), FOREIGN KEY(university_group_id) references university_db.university_group(id)
)

