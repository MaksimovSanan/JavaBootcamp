

INSERT INTO Users(login, password) VALUES ('ABOBA', '000'),
('DENISKA', 'YES'),
('URURU', 'YES'),
('ABOBUS', '111'),
('QWERTY', 'TYUIOP');


INSERT INTO chatrooms(name, owner_id) VALUES ('ABOBAROOM', 1),
('DENISKAROOM', 2),
('URURUROOM', 3),
('ABOBUSROOM', 4),
('QWERTYROOM', 5);


INSERT INTO messages (author_id, room_id, text, date) VALUES (1, 1, 'THAT MY ROOM', '2023-10-16 18:00:00'),
(2, 1, 'THIS ROOM IS SHIT', '2023-10-16 18:10:00'),
(2, 3, 'BEST ROOM FROM DENISKA', '2023-10-16 18:12:00'),
(4, 4, 'ABOBUS ROOM', '2023-10-16 20:20:00'),
(4, 1, 'ABOBUS ROOM THE BEST', '2023-10-16 20:22:00');
