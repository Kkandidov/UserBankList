-- database creation 
CREATE DATABASE users_accounts;

-- table creation user
CREATE TABLE user (
user_id int          NOT NULL,
name    varchar(45),
surname varchar(45)
);

-- table creation account
CREATE TABLE account (
account_id int NOT NULL,
account    int NOT NULL,
user_id    int NOT NULL
);

-- primary keys definition
ALTER TABLE user ADD PRIMARY KEY (user_id);
ALTER TABLE account ADD PRIMARY KEY (account_id);

-- foreign keys definition
ALTER TABLE account ADD CONSTRAINT FK_user_id FOREIGN KEY
(user_id) REFERENCES user (user_id);