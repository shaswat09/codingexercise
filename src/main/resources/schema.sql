CREATE TABLE user(userID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1),first_name VARCHAR(100) NOT NULL,middle_name VARCHAR(100) DEFAULT NULL,last_name VARCHAR(100) DEFAULT NULL,age INTEGER NOT NULL,gender VARCHAR(100) DEFAULT NULL,phone VARCHAR(100) DEFAULT NULL,zip_code VARCHAR(100) DEFAULT NULL,PRIMARY KEY (userID));
CREATE TABLE book(id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) PRIMARY KEY,name VARCHAR(100) NOT NULL,authors VARCHAR(100) NOT NULL,user_ID INTEGER UNIQUE FOREIGN KEY REFERENCES user(userID))