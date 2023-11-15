

INSERT INTO Users(login, password) VALUES ('ABOBA', '000');
INSERT INTO Users(login, password) VALUES ('DENISKA', 'YES');
INSERT INTO Users(login, password) VALUES ('URURU', 'YES');
INSERT INTO Users(login, password) VALUES ('ABOBUS', '111');
INSERT INTO Users(login, password) VALUES ('QWERTY', 'TYUIOP');


INSERT INTO chatrooms(name, owner_id) VALUES ('ABOBAROOM', 1);
INSERT INTO chatrooms(name, owner_id) VALUES ('DENISKAROOM', 2);
INSERT INTO chatrooms(name, owner_id) VALUES ('URURUROOM', 3);
INSERT INTO chatrooms(name, owner_id) VALUES ('ABOBUSROOM', 4);
INSERT INTO chatrooms(name, owner_id) VALUES ('QWERTYROOM', 5);


INSERT INTO messages (author_id, room_id, text, date) VALUES (1, 1, 'THAT MY ROOM', '2023-10-16 18:00:00');
INSERT INTO messages (author_id, room_id, text, date) VALUES (2, 1, 'THIS ROOM IS SHIT', '2023-10-16 18:10:00');
INSERT INTO messages (author_id, room_id, text, date) VALUES (2, 3, 'BEST ROOM FROM DENISKA', '2023-10-16 18:12:00');
INSERT INTO messages (author_id, room_id, text, date) VALUES (4, 4, 'ABOBUS ROOM', '2023-10-16 20:20:00');
INSERT INTO messages (author_id, room_id, text, date) VALUES (4, 1, 'ABOBUS ROOM THE BEST', '2023-10-16 20:22:00');
