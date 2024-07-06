-- Create database
-- CREATE DATABASE fawry;

-- Use the database
-- USE fawry;

-- Create user table
-- CREATE TABLE user (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(255) NOT NULL
-- );

-- Create course table
-- CREATE TABLE course (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(255) NOT NULL,
--     description TEXT
-- );

-- Create user_course table to represent the many-to-many relationship
-- CREATE TABLE user_course (
--     user_id INT,
--     course_id INT,
--     PRIMARY KEY (user_id, course_id),
--     FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
--     FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE
-- );
-- select * from user;
select * from user_course;