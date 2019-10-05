-- filling in the table user
INSERT INTO user(user_id, name, surname)
VALUES (0,'Богдан','Богданов');
INSERT INTO user(user_id, name, surname)
VALUES (1,'Гордей', 'Гордеев');
INSERT INTO user(user_id, name, surname)
VALUES (2,'Дмитрий', 'Дмитриев');
INSERT INTO user(user_id, name, surname)
VALUES (3,'Емельян', 'Емельянов');
INSERT INTO user(user_id, name, surname)
VALUES (4,'Зиновий', 'Зиновьев');
INSERT INTO user(user_id, name, surname)
VALUES (5,'Кирилл', 'Кириллов');
INSERT INTO user(user_id, name, surname)
VALUES (6,'Михаил', 'Михаилов');
INSERT INTO user(user_id, name, surname)
VALUES (7,'Назар', 'Назаров');
INSERT INTO user(user_id, name, surname)
VALUES (8,'Павел', 'Павлов');
INSERT INTO user(user_id, name, surname)
VALUES (9,'Родион', 'Родионов');

-- filling in the table account
INSERT INTO account(account_id, account, user_id)
VALUES (10, 4000, 0);
INSERT INTO account(account_id, account, user_id)
VALUES (11, 2000, 1);
INSERT INTO account(account_id, account, user_id)
VALUES (12, 3000, 2);
INSERT INTO account(account_id, account, user_id)
VALUES (13, 5000, 3);
INSERT INTO account(account_id, account, user_id)
VALUES (14, 1000, 4);
INSERT INTO account(account_id, account, user_id)
VALUES (15, 9000, 5);
INSERT INTO account(account_id, account, user_id)
VALUES (16, 6000, 6);
INSERT INTO account(account_id, account, user_id)
VALUES (17, 8000, 7);
INSERT INTO account(account_id, account, user_id)
VALUES (18, 7000, 8);
INSERT INTO account(account_id, account, user_id)
VALUES (19, 9000, 9);