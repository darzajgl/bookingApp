INSERT INTO room(id, number, name, capacity, has_window) VALUES
(201,321,'London',3,1),
(202,432,'Berlin',2,0),
(203,543,'Tokyo',4,1),
(204,444,'Warsaw',5,0),
(205,555,'Paris',5,1),
(206,666,'Oslo',2,1),
(207,888,'ABC',2,1),
(208,898,'DEF',2,1),
(209,786,'GGG',2,1),
(210,777,'Melbourne',8,1);

INSERT INTO guest(id, name, email, gold_member, check_in_date, check_out_date, room_id) VALUES
(101,'Piotr', 'p@p.com', 1, '2020-01-01', '2020-02-02',201),
(102,'Kinga', 'k@k.com', 1, '2012-03-03', '2012-03-04',202),
-- (103,'Damian', 'd@d.com', 0, '2017-03-04', '2017-04-05',203),
-- (104,'August', 'a@a.com', 0, '2019-04-07', '2019-04-08',204),
-- (105,'Aleksandra', 'aaaaa@k.com', 0, '2012-01-01', '2013-02-02',205),
-- (106,'Elo', 'elo@halko.com', 0, '2023-07-01', '2023-07-07',206),
-- (107,'Jan', 'kowalski@dot.com', 1, '2015-12-13', '2016-01-03',207),
(108,'Jan', 'nowak@dot.com', 0, '2010-06-06', '2010-06-21',208),
-- (109,'Piotr', 'p@p.com', 0, '2017-08-17', '2017-08-19',209),
-- (111,'Adam', 'aaaa@sssss.com', 0, '2011-01-17', '2011-02-19',null),
(110,'Andrzej', 'a@a.com', 0, '2021-02-01', '2021-05-02',210);