INSERT INTO public.room(id, number, name, capacity, has_window) VALUES
(201,321,'London',3,1),
(202,432,'Berlin',2,0),
(203,543,'Tokyo',4,1),
(204,444,'Warsaw',5,0),
(205,555,'Paris',5,1),
(206,666,'Oslo',2,1),
(207,777,'Melbourne',8,1);

INSERT INTO public.guest(id, name, email, gold_member, check_in_date, check_out_date) VALUES
(101,'Piotr', 'p@p.com', 1, '2020-01-01', '2020-02-02'),
(102,'Kinga', 'k@k.com', 1, '2012-03-03', '2012-03-04'),
(103,'Damian', 'd@d.com', 0, '2017-03-04', '2017-04-05'),
(104,'August', 'a@a.com', 0, '2019-04-07', '2019-04-08'),
(105,'Aleksandra', 'aaaaa@k.com', 0, '2012-01-01', '2013-02-02'),
(106,'Elo', 'elo@halko.com', 0, '2023-07-01', '2023-07-07'),
(107,'Jan', 'kowalski@dot.com', 1, '2015-12-13', '2016-01-03'),
(108,'Jan', 'nowak@dot.com', 0, '2010-06-06', '2010-06-21'),
(109,'Piotr', 'p@p.com', 0, '2017-08-17', '2017-08-19'),
(110,'Andrzej', 'a@a.com', 0, '2021-02-01', '2021-05-02');