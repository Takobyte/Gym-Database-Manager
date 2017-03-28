--  gym
insert into gym
values ('00001', 'Gym One', '1234 Lower Mall', '2017-03-01', 12345678); 
 
--  room
insert into room
values (1, 'main room 1', 80, 00001, 0, 1); 

insert into room
values (2, 'main room 2', 100, 00001, 0, 1); 

insert into room
values (3, 'activity room 1', 20, 00001, 1, 0); 

insert into room
values (4, 'activity room 2', 30, 00001, 1, 0); 

insert into room
values (5, 'activity room 3', 15, 00001, 1, 0); 

insert into room
values (6, 'activity room 4', 35, 00001, 1, 0); 

insert into room
values (7, 'activity room 5', 30, 00001, 1, 0); 

--  suppliers
insert into suppliers
values (00001, 'Acme, inc.', 60672932, '4821 COSTA ST'); 

insert into suppliers
values (00002, 'Widget Corp', 90337498, '2093 LEVANT ST'); 

insert into suppliers
values (00003, '123 Warehousing', 79894386, '4412 NIMITZ DR'); 

insert into suppliers
values (00004, 'Demo Company', 60146343, '6920 CROSSOVER DR'); 

insert into suppliers
values (00005, 'Smith and Co.', 54831493, '6329 STONEYBROOK AVE'); 

-- equipment
insert into equipment
values (00001, 'treadmill', 1, 1000, '2009-12-08', '2015-12-08', 36, 00003, 00004); 

insert into equipment
values (00002, 'elliptic machine', 2, 800, '2012-02-25', '2017-02-25', 12, 00001, 00001); 

insert into equipment
values (00003, 'cycle', 3, 100, '2006-08-09', '2014-08-09', 48, 00002, 00004); 

insert into equipment
values (00004, 'weights', 4, 200, '2007-12-26', '2015-12-26', 36, 00003, 00001); 

insert into equipment
values (00005, 'dumbells', 5, 50, '2006-11-17', '2014-11-17', 48, 00003, 00003); 

insert into equipment
values (00006, 'treadmill', 1, 1000, '2008-04-23', '2016-04-23', 24, 00005, 00002); 

insert into equipment
values (00007, 'elliptic machine', 2, 800, '2006-01-04', '2014-01-04', 48, 00001, 00003); 

insert into equipment
values (00008, 'cycle', 3, 100, '2013-07-14', '2017-07-14', 12, 00001, 00002); 

insert into equipment
values (00009, 'weights', 4, 200, '2007-05-07', '2016-05-07', 24, 00002, 00004); 

insert into equipment
values (00010, 'dumbells', 5, 50, '2014-11-28', '2014-11-28', 48, 00003, 00003); 

insert into equipment
values (00011, 'treadmill', 1, 1000, '2017-10-08', '2017-10-08', 12, 00002, 00003); 

insert into equipment
values (00012, 'elliptic machine', 2, 800, '2013-07-03', '2017-07-03', 12, 00005, 00002); 

insert into equipment
values (00013, 'cycle', 3, 100, '2007-04-21', '2015-04-21', 36, 00002, 00004); 

insert into equipment
values (00014, 'weights', 4, 200, '2012-06-02', '2014-06-02', 48, 00004, 00001); 

insert into equipment
values (00015, 'dumbells', 5, 50, '2011-01-08', '2017-01-08', 12, 00003, 00005); 

--  employees
insert into employees
values (78397, 'Daniel Taylor', 'manager', 4100, '2789 ZOE ST', '1972-12-22', 24172481, 1, 0); 

insert into employees
values (16379, 'James Thomas', 'manager', 3500, '359 CARTER ST', '1988-02-14', 74055913, 1, 0); 

insert into employees
values (50185, 'Patricia Thomas', 'manager', 2300, '3231 ALBERTA ST', '1976-07-13', 38276833, 1, 0); 

insert into employees
values (69232, 'Kirsten Garcia', 'clerk', 2800, '9927 ESSEX ST', '1973-02-02', 50721629, 0, 0); 

insert into employees
values (42405, 'John Johnson', 'clerk', 4800, '1011 DOCK ST', '1990-06-24', 36349856, 0, 0); 

insert into employees
values (97217, 'Maria Williams', 'clerk', 8800, '9745 MASSASOIT ST', '1970-09-02', 63134510, 0, 0); 

insert into employees
values (38826, 'Elizabeth Taylor', 'trainer', 6900, '3469 VINE TER', '1983-11-04', 16679760, 0, 1); 

insert into employees
values (39527, 'Kirsten Brown', 'trainer', 8500, '8201 TUSCANY ALY', '1979-05-23', 76081869, 0, 1); 

insert into employees
values (33651, 'Thomas Miller', 'trainer', 4300, '9475 SIBERT LN', '1984-04-17', 58441176, 0, 1); 

insert into employees
values (67932, 'Jennifer Miller', 'trainer', 2500, '3967 WINN WAY', '1977-06-05', 44786761, 0, 1); 

insert into employees
values (48717, 'Minura Garcia', 'trainer', 3600, '3348 CHESTER AVE', '1972-08-08', 71414767, 0, 1); 

insert into employees
values (43186, 'Susan Johnson', 'trainer', 3900, '2813 MUIR CT', '1986-01-28', 45071649, 0, 1); 

insert into employees
values (21122, 'Thomas Garcia', 'trainer', 2800, '8727 DUNNES ALY', '1970-07-02', 67463787, 0, 1); 

insert into employees
values (90473, 'Patricia Miller', 'trainer', 6400, '3743 ORANGE ALY', '1982-03-02', 54218179, 0, 1); 

insert into employees
values (40243, 'Michael Davis', 'trainer', 9800, '2001 HAROLD AVE', '1975-11-07', 22176335, 0, 1); 

insert into employees
values (75507, 'Joseph Jackson', 'trainer', 7700, '8544 MOORE LN', '1983-04-08', 32111332, 0, 1); 

insert into works_in
values (78397, 00001, '2014-01-04', '2015-08-25'); 

insert into works_in
values (16379, 00001, '2011-01-09', '2016-06-08'); 

insert into works_in
values (50185, 00001, '2010-01-18', '2015-12-15'); 

insert into works_in
values (69232, 00001, '2011-04-17', '2015-03-01'); 

insert into works_in
values (42405, 00001, '2010-06-05', '2016-04-18'); 

insert into works_in
values (97217, 00001, '2014-04-09', '2016-11-23'); 

insert into works_in
values (38826, 00001, '2012-02-12', '2016-02-27'); 

insert into works_in
values (39527, 00001, '2014-04-21', '2016-01-07'); 

insert into works_in
values (33651, 00001, '2012-06-16', '2016-01-04'); 

insert into works_in
values (67932, 00001, '2014-03-19', '2016-02-27'); 

insert into works_in
values (48717, 00001, '2012-04-27', '2015-06-26'); 

insert into works_in
values (43186, 00001, '2010-05-11', '2015-05-01'); 

insert into works_in
values (21122, 00001, '2011-11-14', '2015-04-26'); 

insert into works_in
values (90473, 00001, '2014-12-19', '2015-08-17'); 

insert into works_in
values (40243, 00001, '2012-03-25', '2016-11-12'); 

insert into works_in
values (75507, 00001, '2012-08-14', '2016-09-07'); 

-- class_type
insert into class_type
values ('yoga'); 

insert into class_type
values ('cycling'); 

insert into class_type
values ('kick boxing'); 

insert into class_type
values ('karate'); 

insert into class_type
values ('variety'); 

-- group_classes
insert into group_classes
values (0000000001, 20, '2016-11-22 15-50-00', '2016-11-22 16-50-00', 00004, 'kick boxing'); 

insert into group_classes
values (0000000002, 10, '2016-12-22 13-40-00', '2016-12-22 14-40-00', 00004, 'yoga'); 

insert into group_classes
values (0000000003, 20, '2014-02-15 07-10-00', '2014-02-15 08-10-00', 00004, 'cycling'); 

insert into group_classes
values (0000000004, 20, '2014-08-07 15-20-00', '2014-08-07 16-20-00', 00004, 'yoga'); 

insert into group_classes
values (0000000005, 10, '2015-11-28 19-00-00', '2015-11-28 20-00-00', 00004, 'yoga'); 

insert into group_classes
values (0000000006, 15, '2016-03-08 07-50-00', '2016-03-08 08-50-00', 00004, 'cycling'); 

insert into group_classes
values (0000000007, 15, '2014-12-23 13-00-00', '2014-12-23 14-00-00', 00004, 'kick boxing'); 

insert into group_classes
values (0000000008, 20, '2016-07-19 18-00-00', '2016-07-19 19-00-00', 00004, 'kick boxing'); 

insert into group_classes
values (0000000009, 15, '2014-09-18 07-40-00', '2014-09-18 08-40-00', 00004, 'cycling'); 

insert into group_classes
values (0000000010, 10, '2014-01-07 19-40-00', '2014-01-07 20-40-00', 00004, 'cycling'); 

-- teaches
insert into teaches
values (33651, 0000000001); 

insert into teaches
values (75507, 0000000002); 

insert into teaches
values (21122, 0000000003); 

insert into teaches
values (67932, 0000000004); 

insert into teaches
values (67932, 0000000005); 

insert into teaches
values (39527, 0000000006); 

insert into teaches
values (75507, 0000000007); 

insert into teaches
values (43186, 0000000008); 

insert into teaches
values (39527, 0000000009); 

insert into teaches
values (38826, 0000000010); 

-- members
insert into members
values (37816, 'Richard Johnson', 59407407, '1986-04-11', '8960 NORTHWOOD DR', '2018-06-13', '2018-02-26', 00001); 

insert into members
values (46274, 'Patricia Anderson', 90992012, '1999-02-19', '6932 WOODSIDE AVE', '2019-03-26', '2019-01-18', 00001); 

insert into members
values (66906, 'Michael Moore', 63815776, '1954-01-22', '7735 HEMLOCK ST', '2019-11-26', '2019-06-24', 00001); 

insert into members
values (98299, 'Michael Johnson', 28776182, '1984-05-14', '8266 BANNOCK ST', '2018-03-17', '2019-08-17', 00001); 

insert into members
values (51198, 'Robert White', 26566507, '1997-09-23', '5289 SPENCER ST', '2019-07-08', '2018-02-09', 00001); 

insert into members
values (44061, 'Richard Garcia', 87502690, '1971-10-02', '5564 MILAN TER', '2019-11-11', '2019-05-03', 00001); 

insert into members
values (56988, 'William Smith', 90802471, '1997-04-12', '3743 ANDREW ST', '2018-02-04', '2018-11-15', 00001); 

insert into members
values (20569, 'Mary Jackson', 82504899, '1990-06-01', '8509 SUNSET BLVD OFF RAMP', '2019-01-27', '2018-09-20', 00001); 

insert into members
values (30819, 'Patricia Jones', 89279695, '1999-06-18', '6647 MAYNARD ST', '2019-11-10', '2019-12-12', 00001); 

insert into members
values (33151, 'Richard Taylor', 55179526, '1992-07-18', '34 BEACHMONT DR', '2019-10-24', '2019-01-18', 00001); 

insert into members
values (77841, 'Elizabeth Brown', 86438447, '1952-04-23', '9160 FISHER LOOP', '2018-05-21', '2018-04-12', 00001); 

insert into members
values (71477, 'Maria Garcia', 32078118, '1977-04-01', '8699 VENUS ST', '2019-09-14', '2019-08-15', 00001); 

insert into members
values (51321, 'Masashi Williams', 59797123, '1973-01-25', '9814 I-80 TO HWY 101 RAMP', '2019-12-13', '2019-07-10', 00001); 

insert into members
values (98417, 'Jung Garcia', 10485646, '1991-02-24', '2257 MANSFIELD ST', '2018-08-13', '2019-07-06', 00001); 

insert into members
values (62371, 'Robert Jackson', 41842128, '1990-06-15', '1225 BURGOYNE ST', '2019-07-03', '2019-09-28', 00001); 

insert into members
values (72209, 'William Miller', 90454194, '1955-02-11', '4270 PARADISE AVE', '2019-03-12', '2019-09-14', 00001); 

insert into members
values (49815, 'Jung Brown', 94474314, '1973-08-10', '770 MAGNOLIA ST', '2019-07-03', '2018-12-21', 00001); 

insert into members
values (43069, 'Masashi Johnson', 25451543, '1991-07-21', '3419 GALINDO AVE', '2019-03-19', '2018-04-26', 00001); 

insert into members
values (47811, 'John Martin', 49701178, '1990-04-26', '1830 HAVENSIDE DR', '2019-12-13', '2018-11-11', 00001); 

insert into members
values (88392, 'Daniel Williams', 53616843, '1973-06-13', '7977 JUNIPERO SERRA BLVD OFF RAMP', '2019-07-23', '2018-04-22', 00001); 

--  class_purchases
insert into class_purchases
values (0000000001, 0000000001, 20569, 10, '2013-10-09'); 

insert into class_purchases
values (0000000002, 0000000007, 51198, 10, '2013-07-17'); 

insert into class_purchases
values (0000000003, 0000000002, 49815, 10, '2012-05-03'); 

insert into class_purchases
values (0000000004, 0000000005, 46274, 10, '2013-04-19'); 

insert into class_purchases
values (0000000005, 0000000006, 37816, 20, '2012-12-18'); 

insert into class_purchases
values (0000000006, 0000000007, 71477, 20, '2012-01-01'); 

insert into class_purchases
values (0000000007, 0000000001, 98417, 20, '2012-05-01'); 

insert into class_purchases
values (0000000008, 0000000008, 56988, 15, '2012-12-12'); 

insert into class_purchases
values (0000000009, 0000000007, 51198, 20, '2013-10-28'); 

insert into class_purchases
values (0000000010, 0000000005, 47811, 15, '2013-01-06'); 

--  membership_types
insert into membership_types
values (1, 'standard', 30); 

insert into membership_types
values (2, 'premium', 20); 

-- group_exercise_logs
insert into group_exercise_logs
values (00000000000000000001, 'variety', 51321, 0000000008); 

insert into group_exercise_logs
values (00000000000000000002, 'yoga', 51198, 0000000007); 

insert into group_exercise_logs
values (00000000000000000003, 'variety', 43069, 0000000003); 

insert into group_exercise_logs
values (00000000000000000004, 'kick boxing', 71477, 0000000001); 

insert into group_exercise_logs
values (00000000000000000005, 'variety', 77841, 0000000006); 

insert into group_exercise_logs
values (00000000000000000006, 'yoga', 20569, 0000000005); 

insert into group_exercise_logs
values (00000000000000000007, 'yoga', 49815, 0000000005); 

insert into group_exercise_logs
values (00000000000000000008, 'yoga', 56988, 0000000003); 

insert into group_exercise_logs
values (00000000000000000009, 'kick boxing', 30819, 0000000001); 

insert into group_exercise_logs
values (00000000000000000010, 'variety', 43069, 0000000003); 

-- individual_activity_type
insert into individual_activity_type
values ('push-ups'); 

insert into individual_activity_type
values ('weight lifting'); 

insert into individual_activity_type
values ('running'); 

-- individual_exercise_logs
insert into individual_exercise_logs
values (00000000000000000001, 30819,null, 'weight lifting', '2016-07-11 09-50-00', '2016-07-11 10-50-00'); 

insert into individual_exercise_logs
values (00000000000000000002, 44061,null, 'running', '2014-11-06 18-50-00', '2014-11-06 19-50-00'); 

insert into individual_exercise_logs
values (00000000000000000003, 47811,null, 'running', '2014-06-21 08-30-00', '2014-06-21 09-30-00'); 

insert into individual_exercise_logs
values (00000000000000000004, 20569,null, 'weight lifting', '2016-10-09 09-30-00', '2016-10-09 10-30-00'); 

insert into individual_exercise_logs
values (00000000000000000005, 71477,null, 'running', '2014-04-16 08-10-00', '2014-04-16 09-10-00'); 

insert into individual_exercise_logs
values (00000000000000000006, 30819,null, 'push-ups', '2016-06-07 10-50-00', '2016-06-07 11-50-00'); 

insert into individual_exercise_logs
values (00000000000000000007, 66906,null, 'push-ups', '2016-12-10 14-10-00', '2016-12-10 15-10-00'); 

insert into individual_exercise_logs
values (00000000000000000008, 88392,null, 'weight lifting', '2016-08-20 16-50-00', '2016-08-20 17-50-00'); 

insert into individual_exercise_logs
values (00000000000000000009, 71477,null, 'running', '2016-11-25 07-30-00', '2016-11-25 08-30-00'); 

insert into individual_exercise_logs
values (00000000000000000010, 71477,null, 'weight lifting', '2014-08-07 19-40-00', '2014-08-07 20-40-00'); 

