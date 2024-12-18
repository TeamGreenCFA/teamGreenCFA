-- Drop the database if it already exists
DROP DATABASE IF EXISTS finalProject;

-- Create a new database
CREATE DATABASE finalProject;

-- Use the created database
USE finalProject;

-- Drop existing tables if they exist to avoid conflicts
DROP TABLE IF EXISTS volunteer;
DROP TABLE IF EXISTS ben;

-- Create the volunteer table
CREATE TABLE volunteer (
                           id INT PRIMARY KEY,
                           firstName VARCHAR(50),
                           lastName VARCHAR(50),
                           email VARCHAR(100),
                           phone VARCHAR(20),
                           age INT,
                           address VARCHAR(200),
                           description TEXT,
                           services VARCHAR(100)
);

-- Create the ben table (beneficiaries)
CREATE TABLE ben (
                     id INT PRIMARY KEY,
                     firstName VARCHAR(50),
                     lastName VARCHAR(50),
                     email VARCHAR(100),
                     phone VARCHAR(20),
                     age INT,
                     address VARCHAR(200),
                     description TEXT,
                     elder BOOLEAN DEFAULT NULL,
                     disabled BOOLEAN DEFAULT NULL,
                     services VARCHAR(100)
);

-- Delete existing data (for safety)
DELETE FROM volunteer;

-- Insert sample data for volunteer table
INSERT INTO volunteer(id, firstName, lastName, email, phone, age, address, description, services)
VALUES
    (1, 'John', 'Doe', 'john.doe@example.com', '123-456-7890', 30, '123 Main St, City A', 'Regular volunteer for cleaning services', 'Cleaning'),
    (2, 'Jane', 'Smith', 'jane.smith@example.com', '456-789-0123', 45, '456 Elm St, City B', 'Helps in delivering groceries', 'Grocery Delivery'),
    (3, 'Michael', 'Brown', 'michael.brown@example.com', '789-012-3456', 50, '789 Pine St, City C', 'Specializes in tutoring and education support', 'Tutoring'),
    (4, 'Emily', 'Johnson', 'emily.johnson@example.com', '321-654-9870', 35, '321 Oak St, City D', 'Coordinates medical aid donations', 'Medical Aid'),
    (5, 'Chris', 'White', 'chris.white@example.com', '654-321-0987', 28, '654 Maple St, City E', 'Volunteer for maintenance and home repairs', 'Home Repair');

-- Delete existing data (for safety)
DELETE FROM ben;

-- Insert sample data for beneficied table
INSERT INTO ben(id, firstName, lastName, email, phone, age, address, description, elder, disabled, services)
VALUES
    (1, 'Alice', 'Walker', 'alice.walker@example.com', '111-222-3333', 70, '100 Elder St, City F', 'Needs weekly grocery delivery', true, false, 'Grocery Delivery'),
    (2, 'Bob', 'Martin', 'bob.martin@example.com', '222-333-4444', 65, '200 Senior Ave, City G', 'Requires occasional home repair services', true, true, 'Home Repair'),
    (3, 'Catherine', 'Adams', 'catherine.adams@example.com', '333-444-5555', 78, '300 Oak St, City H', 'Needs tutoring for her grandchildren', true, false, 'Tutoring'),
    (4, 'David', 'Clark', 'david.clark@example.com', '444-555-6666', 50, '400 Maple St, City I', 'Disabled and in need of cleaning assistance', false, true, 'Cleaning'),
    (5, 'Evelyn', 'Morris', 'evelyn.morris@example.com', '555-666-7777', 82, '500 Pine St, City J', 'Elderly requiring medical aid support', true, false, 'Medical Aid');
