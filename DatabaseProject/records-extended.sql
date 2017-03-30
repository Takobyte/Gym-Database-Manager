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
values (00001, 'Acme, inc.', 67506251, '7633 MAIN DR'); 

insert into suppliers
values (00002, 'Widget Corp', 86412426, '1638 LAGUNITAS DR'); 

insert into suppliers
values (00003, '123 Warehousing', 46474390, '7228 INDUSTRIAL ST OFF RAMP'); 

insert into suppliers
values (00004, 'Demo Company', 91605955, '7448 ALBATROSS CT'); 

insert into suppliers
values (00005, 'Smith and Co.', 24891150, '3442 ZIRCON PL'); 

insert into suppliers
values (00006, 'Fake Brothers', 66027175, '8402 OPAL PL'); 

insert into suppliers
values (00007, 'QWERTY Logistics', 12294638, '9121 PEARL ST'); 

insert into suppliers
values (00008, 'Demo, inc.', 58601231, '2066 BERRY EXTENSION ST'); 

insert into suppliers
values (00009, 'Acme Corp', 63079753, '6710 DE FOREST WAY'); 

insert into suppliers
values (00010, 'Ankh-Sto Associates', 70872052, '8592 SONORA LN'); 

-- equipment
insert into equipment
values (00001, 'treadmill', 1, 1000, '2013-04-05', '2016-04-05', 24, 2, 00010); 

insert into equipment
values (00002, 'elliptic machine', 2, 800, '2006-10-10', '2015-10-10', 36, 1, 00002); 

insert into equipment
values (00003, 'cycle', 3, 100, '2009-06-21', '2014-06-21', 48, 6, 00004); 

insert into equipment
values (00004, 'weights', 4, 200, '2012-07-15', '2017-07-15', 12, 6, 00010); 

insert into equipment
values (00005, 'dumbells', 5, 50, '2007-04-03', '2017-04-03', 12, 7, 00006); 

insert into equipment
values (00006, 'treadmill', 1, 1000, '2007-09-15', '2017-09-15', 12, 5, 00005); 

insert into equipment
values (00007, 'elliptic machine', 2, 800, '2013-10-17', '2016-10-17', 24, 3, 00005); 

insert into equipment
values (00008, 'cycle', 3, 100, '2009-07-23', '2014-07-23', 48, 3, 00010); 

insert into equipment
values (00009, 'weights', 4, 200, '2012-04-01', '2014-04-01', 48, 3, 00004); 

insert into equipment
values (00010, 'dumbells', 5, 50, '2005-06-13', '2014-06-13', 48, 5, 00001); 

insert into equipment
values (00011, 'treadmill', 1, 1000, '2014-12-01', '2017-12-01', 12, 2, 00004); 

insert into equipment
values (00012, 'elliptic machine', 2, 800, '2014-12-17', '2017-12-17', 12, 7, 00007); 

insert into equipment
values (00013, 'cycle', 3, 100, '2016-10-06', '2017-10-06', 12, 5, 00006); 

insert into equipment
values (00014, 'weights', 4, 200, '2011-11-08', '2014-11-08', 48, 2, 00008); 

insert into equipment
values (00015, 'dumbells', 5, 50, '2014-03-22', '2017-03-22', 12, 1, 00003); 

--  employees
insert into employees
values (74309, 'Mary Jones', 'manager', 4400, '3172 SIBERT LOOP', '1979-06-15', 57504987, 1, 0); 

insert into employees
values (36767, 'Kirsten Anderson', 'manager', 2100, '1763 DENSLOWE DR', '1972-11-12', 14839350, 1, 0); 

insert into employees
values (50294, 'Michael Rodriguez', 'manager', 9400, '190 IRIS AVE', '1984-04-02', 44685114, 1, 0); 

insert into employees
values (98589, 'David Lee', 'clerk', 6600, '4485 RAVENWOOD DR', '1976-08-27', 41417215, 0, 0); 

insert into employees
values (83959, 'James Jones', 'clerk', 3500, '6862 ECKER ST', '1973-10-15', 50466091, 0, 0); 

insert into employees
values (38016, 'James Johnson', 'clerk', 4700, '8134 CROOK ST', '1979-05-27', 42155518, 0, 0); 

insert into employees
values (49318, 'Joseph White', 'trainer', 3800, '2224 HAWES ST', '1975-08-06', 77836801, 0, 1); 

insert into employees
values (69954, 'Mary Garcia', 'trainer', 4600, '4997 KAMILLE CT', '1984-12-14', 81388801, 0, 1); 

insert into employees
values (15194, 'Elizabeth Miller', 'trainer', 1100, '2441 EVE ST', '1973-03-28', 30369638, 0, 1); 

insert into employees
values (63237, 'John Rodriguez', 'trainer', 9200, '4678 BURLWOOD DR', '1977-02-12', 69141504, 0, 1); 

insert into employees
values (18721, 'Masashi Miller', 'trainer', 5000, '892 RUDDEN AVE', '1971-03-02', 25131098, 0, 1); 

insert into employees
values (48786, 'Jennifer Miller', 'trainer', 5200, '976 MERCURY ST', '1970-10-07', 49908838, 0, 1); 

insert into employees
values (60782, 'John Martin', 'trainer', 9600, '634 SUNBEAM LN', '1988-11-09', 57876658, 0, 1); 

insert into employees
values (99196, 'Joseph Williams', 'trainer', 4600, '3403 STARVIEW WAY', '1981-09-06', 18162136, 0, 1); 

insert into employees
values (68227, 'John Brown', 'trainer', 6200, '1850 CYRIL MAGNIN ST', '1984-12-10', 11364619, 0, 1); 

insert into employees
values (17892, 'Jung Davis', 'trainer', 1900, '1426 JUNIPERO SERRA  BLVD OFF RAMP', '1981-04-07', 53532362, 0, 1); 

insert into works_in
values (74309, 00001, '2011-10-15', '2016-02-28'); 

insert into works_in
values (36767, 00001, '2011-06-17', '2016-09-07'); 

insert into works_in
values (50294, 00001, '2012-01-25', '2015-06-18'); 

insert into works_in
values (98589, 00001, '2013-04-26', '2016-09-25'); 

insert into works_in
values (83959, 00001, '2011-04-10', '2015-07-14'); 

insert into works_in
values (38016, 00001, '2013-06-18', '2015-10-18'); 

insert into works_in
values (49318, 00001, '2014-12-25', '2015-12-01'); 

insert into works_in
values (69954, 00001, '2013-05-21', '2016-09-17'); 

insert into works_in
values (15194, 00001, '2013-09-01', '2016-02-01'); 

insert into works_in
values (63237, 00001, '2010-04-08', '2015-03-27'); 

insert into works_in
values (18721, 00001, '2010-10-07', '2015-05-26'); 

insert into works_in
values (48786, 00001, '2011-05-03', '2016-01-03'); 

insert into works_in
values (60782, 00001, '2012-07-28', '2016-03-21'); 

insert into works_in
values (99196, 00001, '2013-07-04', '2016-08-08'); 

insert into works_in
values (68227, 00001, '2014-05-09', '2015-07-08'); 

insert into works_in
values (17892, 00001, '2013-09-19', '2015-11-11'); 

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
values (0000000001, 15, '2016-09-23 14-30-00', '2016-09-23 15-30-00', 6, 'cycling'); 

insert into group_classes
values (0000000002, 20, '2014-11-20 10-00-00', '2014-11-20 11-00-00', 7, 'kick boxing'); 

insert into group_classes
values (0000000003, 15, '2015-11-28 15-40-00', '2015-11-28 16-40-00', 3, 'cycling'); 

insert into group_classes
values (0000000004, 20, '2014-03-20 08-10-00', '2014-03-20 09-10-00', 2, 'yoga'); 

insert into group_classes
values (0000000005, 20, '2016-04-23 18-30-00', '2016-04-23 19-30-00', 1, 'yoga'); 

insert into group_classes
values (0000000006, 10, '2014-04-26 19-20-00', '2014-04-26 20-20-00', 5, 'kick boxing'); 

insert into group_classes
values (0000000007, 20, '2014-07-22 18-30-00', '2014-07-22 19-30-00', 1, 'cycling'); 

insert into group_classes
values (0000000008, 20, '2014-06-12 11-10-00', '2014-06-12 12-10-00', 7, 'kick boxing'); 

insert into group_classes
values (0000000009, 10, '2014-03-12 07-20-00', '2014-03-12 08-20-00', 1, 'cycling'); 

insert into group_classes
values (0000000010, 10, '2014-07-21 19-20-00', '2014-07-21 20-20-00', 3, 'cycling'); 

insert into group_classes
values (0000000011, 20, '2015-04-08 13-40-00', '2015-04-08 14-40-00', 3, 'yoga'); 

insert into group_classes
values (0000000012, 10, '2014-07-10 14-30-00', '2014-07-10 15-30-00', 2, 'cycling'); 

insert into group_classes
values (0000000013, 10, '2016-10-10 16-30-00', '2016-10-10 17-30-00', 7, 'kick boxing'); 

insert into group_classes
values (0000000014, 20, '2014-05-28 10-30-00', '2014-05-28 11-30-00', 5, 'kick boxing'); 

insert into group_classes
values (0000000015, 10, '2014-06-18 17-40-00', '2014-06-18 18-40-00', 2, 'kick boxing'); 

insert into group_classes
values (0000000016, 10, '2014-09-06 18-40-00', '2014-09-06 19-40-00', 7, 'yoga'); 

insert into group_classes
values (0000000017, 20, '2016-08-06 12-00-00', '2016-08-06 13-00-00', 3, 'kick boxing'); 

insert into group_classes
values (0000000018, 20, '2016-11-01 18-00-00', '2016-11-01 19-00-00', 4, 'yoga'); 

insert into group_classes
values (0000000019, 20, '2015-04-17 08-00-00', '2015-04-17 09-00-00', 1, 'cycling'); 

insert into group_classes
values (0000000020, 20, '2016-12-10 08-40-00', '2016-12-10 09-40-00', 2, 'kick boxing'); 

insert into group_classes
values (0000000021, 10, '2014-12-26 19-40-00', '2014-12-26 20-40-00', 1, 'yoga'); 

insert into group_classes
values (0000000022, 20, '2016-04-19 19-30-00', '2016-04-19 20-30-00', 3, 'cycling'); 

insert into group_classes
values (0000000023, 20, '2014-01-17 12-10-00', '2014-01-17 13-10-00', 6, 'yoga'); 

insert into group_classes
values (0000000024, 20, '2014-10-26 12-40-00', '2014-10-26 13-40-00', 3, 'kick boxing'); 

insert into group_classes
values (0000000025, 10, '2016-10-17 10-20-00', '2016-10-17 11-20-00', 6, 'yoga'); 

insert into group_classes
values (0000000026, 15, '2015-11-07 16-40-00', '2015-11-07 17-40-00', 5, 'cycling'); 

insert into group_classes
values (0000000027, 10, '2014-03-26 13-20-00', '2014-03-26 14-20-00', 4, 'cycling'); 

insert into group_classes
values (0000000028, 20, '2016-06-20 17-40-00', '2016-06-20 18-40-00', 7, 'kick boxing'); 

insert into group_classes
values (0000000029, 20, '2015-04-27 09-20-00', '2015-04-27 10-20-00', 1, 'kick boxing'); 

insert into group_classes
values (0000000030, 15, '2014-02-23 14-30-00', '2014-02-23 15-30-00', 2, 'yoga'); 

-- teaches
insert into teaches
values (60782, 0000000001); 

insert into teaches
values (60782, 0000000002); 

insert into teaches
values (18721, 0000000003); 

insert into teaches
values (99196, 0000000004); 

insert into teaches
values (17892, 0000000005); 

insert into teaches
values (99196, 0000000006); 

insert into teaches
values (99196, 0000000007); 

insert into teaches
values (63237, 0000000008); 

insert into teaches
values (63237, 0000000009); 

insert into teaches
values (63237, 0000000010); 

insert into teaches
values (17892, 0000000011); 

insert into teaches
values (69954, 0000000012); 

insert into teaches
values (63237, 0000000013); 

insert into teaches
values (69954, 0000000014); 

insert into teaches
values (63237, 0000000015); 

insert into teaches
values (17892, 0000000016); 

insert into teaches
values (18721, 0000000017); 

insert into teaches
values (48786, 0000000018); 

insert into teaches
values (49318, 0000000019); 

insert into teaches
values (68227, 0000000020); 

insert into teaches
values (63237, 0000000021); 

insert into teaches
values (18721, 0000000022); 

insert into teaches
values (63237, 0000000023); 

insert into teaches
values (60782, 0000000024); 

insert into teaches
values (15194, 0000000025); 

insert into teaches
values (49318, 0000000026); 

insert into teaches
values (17892, 0000000027); 

insert into teaches
values (48786, 0000000028); 

insert into teaches
values (60782, 0000000029); 

insert into teaches
values (15194, 0000000030); 

-- members
insert into members
values (21691, 'Jung Jones', 49469272, '1988-04-23', '5450 FISHER ALY', '2019-10-24', '2018-03-08', 00001); 

insert into members
values (13251, 'Linda Williams', 80815389, '1971-12-25', '4377 PARK PRESIDIO BYPASS DR', '2018-05-22', '2018-06-17', 00001); 

insert into members
values (38916, 'Minura Martin', 49737358, '1981-08-01', '9706 MALTA DR', '2019-08-17', '2019-08-17', 00001); 

insert into members
values (47404, 'Jung Rodriguez', 34364880, '1961-05-18', '293 MALVINA PL', '2018-03-21', '2019-09-06', 00001); 

insert into members
values (90964, 'Robert Jones', 22868264, '1998-03-21', '6811 PENNY LN', '2018-12-21', '2019-01-26', 00001); 

insert into members
values (97408, 'William Johnson', 95777003, '1957-02-17', '2582 JOHN MUIR DR', '2018-01-06', '2019-01-02', 00001); 

insert into members
values (37715, 'Minura Wilson', 25817420, '1975-11-19', '1109 HILLCREST RD', '2019-02-19', '2018-03-15', 00001); 

insert into members
values (60388, 'Susan Jones', 19486604, '1994-09-26', '4971 CLAUDE LN', '2019-08-12', '2019-09-24', 00001); 

insert into members
values (77157, 'Jennifer Jones', 66406062, '1980-09-20', '4605 TWIN PEAKS BLVD', '2018-03-18', '2018-12-26', 00001); 

insert into members
values (13791, 'Kirsten Thompson', 76868773, '1989-10-25', '6120 TREASURY PL', '2018-02-16', '2019-09-07', 00001); 

insert into members
values (82733, 'James Lee', 40541204, '1977-12-04', '6891 CAPP ST', '2018-08-27', '2018-07-25', 00001); 

insert into members
values (75492, 'Mark Brown', 33496155, '1948-04-15', '7077 PORTER ST', '2018-09-21', '2019-10-04', 00001); 

insert into members
values (40071, 'James Rodriguez', 18051495, '1953-02-24', '9488 SIXTH ST', '2019-06-07', '2019-07-28', 00001); 

insert into members
values (17042, 'David Moore', 62326597, '1942-08-04', '1793 CONSTANSO WAY', '2019-04-02', '2019-10-25', 00001); 

insert into members
values (15265, 'Michael Thomas', 97684094, '1988-09-28', '5760 CARL ST', '2018-07-22', '2019-09-28', 00001); 

insert into members
values (89888, 'Kirsten Davis', 80385556, '1984-02-12', '1158 DIAMOND ST', '2018-09-19', '2019-02-13', 00001); 

insert into members
values (20662, 'Michael Smith', 48275741, '1950-09-13', '4805 HOBART ALY', '2018-12-12', '2019-02-02', 00001); 

insert into members
values (35869, 'William Martinez', 77778715, '1992-11-01', '9823 ENGLISH ST', '2018-04-02', '2018-12-02', 00001); 

insert into members
values (12118, 'Linda Rodriguez', 27227444, '1986-07-12', '3140 LYNCH ST', '2018-02-07', '2019-03-19', 00001); 

insert into members
values (18708, 'Jennifer Davis', 44196325, '1982-02-06', '4639 MANSELL ST', '2019-06-27', '2019-10-04', 00001); 

insert into members
values (93832, 'Barbara Moore', 81054230, '1971-06-28', '7538 DELAWARE ST', '2018-12-16', '2018-08-26', 00001); 

insert into members
values (62689, 'Jung Johnson', 30039275, '1980-11-05', '7817 MISSION BAY BLVD NORTH', '2018-06-15', '2019-04-04', 00001); 

insert into members
values (25444, 'John Miller', 46694781, '1977-04-26', '3453 MEADE AVE', '2018-10-08', '2018-03-02', 00001); 

insert into members
values (24797, 'Jung Taylor', 29714723, '1942-06-10', '9043 HARLEM ALY', '2019-10-09', '2019-04-09', 00001); 

insert into members
values (26607, 'Minura Jackson', 42344948, '1958-10-03', '6518 LONG AVE', '2018-08-18', '2018-08-25', 00001); 

insert into members
values (28521, 'Michael Martinez', 86067399, '1946-01-27', '7496 HILLCREST CT', '2018-11-01', '2018-08-03', 00001); 

insert into members
values (58989, 'Mark Miller', 87687492, '1991-03-02', '908 HARRISON BLVD', '2018-07-03', '2018-12-15', 00001); 

insert into members
values (76919, 'Barbara Jackson', 85523685, '1999-07-22', '1887 URANUS TER', '2019-11-19', '2018-08-15', 00001); 

insert into members
values (24746, 'Joseph Martin', 59352710, '1981-11-19', '7672 SCIENCE CIR', '2019-09-17', '2019-07-09', 00001); 

insert into members
values (36155, 'Jung Wilson', 38175933, '1988-03-12', '6899 SHORT ST', '2018-02-17', '2018-03-13', 00001); 

insert into members
values (85625, 'Barbara Thompson', 82646674, '1993-12-09', '8134 MARTHA AVE', '2018-03-04', '2018-09-14', 00001); 

insert into members
values (24609, 'Robert Smith', 89712300, '1975-08-02', '2766 MAGELLAN AVE', '2018-10-20', '2018-11-26', 00001); 

insert into members
values (30401, 'James Brown', 63758595, '1984-05-05', '6970 WILLIAMS AVE', '2019-07-22', '2019-08-24', 00001); 

insert into members
values (21051, 'Linda Miller', 39511808, '1989-02-07', '5277 NOB HILL PL', '2018-09-24', '2018-05-17', 00001); 

insert into members
values (90042, 'Barbara Rodriguez', 38891084, '1971-07-03', '7451 STANFORD HEIGHTS AVE', '2018-09-26', '2018-07-26', 00001); 

insert into members
values (54646, 'Jung Lee', 90713969, '1995-08-16', '2002 STOCKTON ST', '2018-12-24', '2019-08-02', 00001); 

insert into members
values (34631, 'Masashi Rodriguez', 55787573, '1949-11-23', '9021 BAY SHORE BLVD OFF RAMP', '2019-07-02', '2018-12-08', 00001); 

insert into members
values (32928, 'Richard Wilson', 75389529, '1980-05-06', '4095 REVERE AVE', '2019-08-22', '2019-06-01', 00001); 

insert into members
values (30645, 'Jennifer Jones', 24384254, '1988-07-11', '8720 CASTILLO ST', '2019-05-28', '2019-06-05', 00001); 

insert into members
values (29929, 'John Lee', 24719751, '1954-06-09', '3502 LIVINGSTON ST', '2018-06-21', '2018-02-24', 00001); 

insert into members
values (51788, 'Minura Taylor', 13105425, '1943-10-11', '994 NAPOLEON ST', '2019-04-17', '2018-08-04', 00001); 

insert into members
values (34518, 'Patricia Johnson', 15793990, '1967-05-20', '6476 CHERRY ST', '2018-07-20', '2018-06-16', 00001); 

insert into members
values (45203, 'Elizabeth Jackson', 89672863, '1959-10-04', '4532 LAKEWOOD AVE', '2018-09-10', '2018-01-23', 00001); 

insert into members
values (85204, 'Linda Lee', 88704803, '1971-09-02', '9765 OLD CHINATOWN LN', '2019-06-24', '2019-09-24', 00001); 

insert into members
values (88884, 'Jennifer Thomas', 99633500, '1969-04-28', '9702 BELMONT AVE', '2019-03-24', '2019-08-10', 00001); 

insert into members
values (25175, 'Elizabeth Rodriguez', 55553818, '1952-07-14', '8448 OSAGE ALY', '2018-07-21', '2019-05-13', 00001); 

insert into members
values (91568, 'Jung Thomas', 67493415, '1992-06-15', '9426 TERRY A FRANCOIS BLVD', '2018-07-24', '2019-04-01', 00001); 

insert into members
values (33657, 'Robert Jones', 57638661, '1992-03-21', '6341 SECOND DR', '2019-10-08', '2018-08-24', 00001); 

insert into members
values (23691, 'Charles Garcia', 61038381, '1971-02-15', '9190 YERBA BUENA DR', '2019-04-08', '2018-11-10', 00001); 

insert into members
values (19753, 'Michael Garcia', 46065269, '1952-11-26', '4354 EUCLID AVE', '2018-11-26', '2018-09-23', 00001); 

--  class_purchases
insert into class_purchases
values (0000000001, 0000000030, 13251, 15, '2012-11-17'); 

insert into class_purchases
values (0000000002, 0000000020, 90042, 15, '2012-01-13'); 

insert into class_purchases
values (0000000003, 0000000016, 30645, 15, '2013-01-26'); 

insert into class_purchases
values (0000000004, 0000000001, 24797, 15, '2013-01-25'); 

insert into class_purchases
values (0000000005, 0000000023, 24797, 15, '2013-05-06'); 

insert into class_purchases
values (0000000006, 0000000026, 15265, 15, '2013-09-27'); 

insert into class_purchases
values (0000000007, 0000000008, 40071, 15, '2012-03-10'); 

insert into class_purchases
values (0000000008, 0000000023, 34518, 15, '2012-10-04'); 

insert into class_purchases
values (0000000009, 0000000026, 19753, 20, '2012-04-14'); 

insert into class_purchases
values (0000000010, 0000000006, 24797, 15, '2012-09-16'); 

insert into class_purchases
values (0000000011, 0000000026, 82733, 15, '2012-04-24'); 

insert into class_purchases
values (0000000012, 0000000020, 91568, 20, '2013-07-18'); 

insert into class_purchases
values (0000000013, 0000000008, 40071, 15, '2013-12-15'); 

insert into class_purchases
values (0000000014, 0000000020, 45203, 20, '2012-05-22'); 

insert into class_purchases
values (0000000015, 0000000004, 85204, 15, '2013-04-02'); 

insert into class_purchases
values (0000000016, 0000000030, 18708, 15, '2012-02-20'); 

insert into class_purchases
values (0000000017, 0000000007, 33657, 15, '2013-09-26'); 

insert into class_purchases
values (0000000018, 0000000018, 76919, 20, '2012-08-09'); 

insert into class_purchases
values (0000000019, 0000000009, 60388, 10, '2013-05-05'); 

insert into class_purchases
values (0000000020, 0000000001, 82733, 15, '2012-12-21'); 

insert into class_purchases
values (0000000021, 0000000002, 12118, 15, '2012-11-08'); 

insert into class_purchases
values (0000000022, 0000000028, 34631, 10, '2012-03-01'); 

insert into class_purchases
values (0000000023, 0000000025, 33657, 20, '2012-05-05'); 

insert into class_purchases
values (0000000024, 0000000026, 85204, 10, '2012-10-15'); 

insert into class_purchases
values (0000000025, 0000000020, 17042, 15, '2013-02-23'); 

insert into class_purchases
values (0000000026, 0000000008, 25444, 10, '2013-07-23'); 

insert into class_purchases
values (0000000027, 0000000030, 33657, 20, '2012-03-06'); 

insert into class_purchases
values (0000000028, 0000000025, 21691, 20, '2013-04-11'); 

insert into class_purchases
values (0000000029, 0000000002, 19753, 20, '2012-10-15'); 

insert into class_purchases
values (0000000030, 0000000010, 21691, 15, '2013-07-18'); 

insert into class_purchases
values (0000000031, 0000000010, 75492, 10, '2013-01-01'); 

insert into class_purchases
values (0000000032, 0000000007, 24797, 15, '2012-10-23'); 

insert into class_purchases
values (0000000033, 0000000030, 40071, 10, '2012-03-15'); 

insert into class_purchases
values (0000000034, 0000000029, 91568, 15, '2013-07-24'); 

insert into class_purchases
values (0000000035, 0000000016, 21691, 15, '2013-03-17'); 

insert into class_purchases
values (0000000036, 0000000023, 88884, 20, '2012-03-27'); 

insert into class_purchases
values (0000000037, 0000000024, 45203, 20, '2013-06-21'); 

insert into class_purchases
values (0000000038, 0000000016, 30645, 15, '2013-05-06'); 

insert into class_purchases
values (0000000039, 0000000009, 34518, 15, '2013-02-14'); 

insert into class_purchases
values (0000000040, 0000000022, 32928, 15, '2012-12-20'); 

insert into class_purchases
values (0000000041, 0000000002, 40071, 15, '2013-03-02'); 

insert into class_purchases
values (0000000042, 0000000017, 20662, 20, '2013-04-16'); 

insert into class_purchases
values (0000000043, 0000000021, 25444, 10, '2013-01-03'); 

insert into class_purchases
values (0000000044, 0000000004, 89888, 15, '2012-04-08'); 

insert into class_purchases
values (0000000045, 0000000022, 21051, 15, '2013-02-06'); 

insert into class_purchases
values (0000000046, 0000000014, 33657, 10, '2012-02-03'); 

insert into class_purchases
values (0000000047, 0000000003, 33657, 20, '2012-09-19'); 

insert into class_purchases
values (0000000048, 0000000003, 24746, 10, '2012-03-26'); 

insert into class_purchases
values (0000000049, 0000000008, 24746, 15, '2013-10-07'); 

insert into class_purchases
values (0000000050, 0000000019, 88884, 10, '2013-08-14'); 

insert into class_purchases
values (0000000051, 0000000023, 75492, 15, '2012-05-09'); 

insert into class_purchases
values (0000000052, 0000000005, 20662, 20, '2012-04-06'); 

insert into class_purchases
values (0000000053, 0000000008, 97408, 10, '2012-09-02'); 

insert into class_purchases
values (0000000054, 0000000030, 28521, 20, '2012-09-09'); 

insert into class_purchases
values (0000000055, 0000000013, 13791, 15, '2012-03-27'); 

insert into class_purchases
values (0000000056, 0000000001, 12118, 10, '2012-02-27'); 

insert into class_purchases
values (0000000057, 0000000008, 45203, 15, '2012-10-18'); 

insert into class_purchases
values (0000000058, 0000000017, 97408, 10, '2013-04-26'); 

insert into class_purchases
values (0000000059, 0000000005, 29929, 10, '2013-10-03'); 

insert into class_purchases
values (0000000060, 0000000002, 60388, 10, '2013-03-13'); 

insert into class_purchases
values (0000000061, 0000000024, 38916, 10, '2012-10-18'); 

insert into class_purchases
values (0000000062, 0000000020, 21051, 10, '2013-03-03'); 

insert into class_purchases
values (0000000063, 0000000005, 85204, 20, '2013-09-24'); 

insert into class_purchases
values (0000000064, 0000000014, 25175, 15, '2013-12-28'); 

insert into class_purchases
values (0000000065, 0000000017, 58989, 15, '2013-12-08'); 

insert into class_purchases
values (0000000066, 0000000012, 85625, 10, '2012-01-14'); 

insert into class_purchases
values (0000000067, 0000000010, 18708, 15, '2012-10-04'); 

insert into class_purchases
values (0000000068, 0000000017, 23691, 15, '2012-09-03'); 

insert into class_purchases
values (0000000069, 0000000003, 75492, 10, '2012-05-09'); 

insert into class_purchases
values (0000000070, 0000000013, 47404, 20, '2013-08-07'); 

insert into class_purchases
values (0000000071, 0000000017, 29929, 20, '2013-07-07'); 

insert into class_purchases
values (0000000072, 0000000028, 47404, 10, '2013-11-13'); 

insert into class_purchases
values (0000000073, 0000000030, 37715, 15, '2013-09-14'); 

insert into class_purchases
values (0000000074, 0000000027, 82733, 10, '2012-09-27'); 

insert into class_purchases
values (0000000075, 0000000019, 85204, 20, '2013-06-15'); 

insert into class_purchases
values (0000000076, 0000000020, 91568, 10, '2013-05-05'); 

insert into class_purchases
values (0000000077, 0000000020, 30401, 10, '2012-08-11'); 

insert into class_purchases
values (0000000078, 0000000011, 54646, 20, '2012-10-13'); 

insert into class_purchases
values (0000000079, 0000000008, 25175, 10, '2013-05-23'); 

insert into class_purchases
values (0000000080, 0000000013, 24609, 20, '2013-02-26'); 

insert into class_purchases
values (0000000081, 0000000027, 23691, 20, '2012-02-11'); 

insert into class_purchases
values (0000000082, 0000000005, 24746, 10, '2013-10-28'); 

insert into class_purchases
values (0000000083, 0000000008, 19753, 20, '2013-05-11'); 

insert into class_purchases
values (0000000084, 0000000014, 97408, 15, '2013-08-23'); 

insert into class_purchases
values (0000000085, 0000000010, 82733, 20, '2013-04-09'); 

insert into class_purchases
values (0000000086, 0000000020, 38916, 10, '2012-02-03'); 

insert into class_purchases
values (0000000087, 0000000024, 21051, 10, '2012-09-13'); 

insert into class_purchases
values (0000000088, 0000000012, 24609, 10, '2012-07-21'); 

insert into class_purchases
values (0000000089, 0000000026, 25444, 10, '2013-12-04'); 

insert into class_purchases
values (0000000090, 0000000029, 62689, 20, '2012-11-12'); 

insert into class_purchases
values (0000000091, 0000000009, 29929, 20, '2013-06-19'); 

insert into class_purchases
values (0000000092, 0000000015, 62689, 20, '2012-11-20'); 

insert into class_purchases
values (0000000093, 0000000012, 35869, 10, '2013-12-22'); 

insert into class_purchases
values (0000000094, 0000000024, 75492, 15, '2013-03-17'); 

insert into class_purchases
values (0000000095, 0000000013, 35869, 20, '2013-05-16'); 

insert into class_purchases
values (0000000096, 0000000018, 91568, 15, '2013-02-20'); 

insert into class_purchases
values (0000000097, 0000000020, 17042, 15, '2012-06-10'); 

insert into class_purchases
values (0000000098, 0000000004, 75492, 20, '2013-11-21'); 

insert into class_purchases
values (0000000099, 0000000005, 60388, 10, '2012-11-16'); 

insert into class_purchases
values (0000000100, 0000000009, 25444, 10, '2012-05-06'); 

--  membership_types
insert into membership_types
values (1, 'standard', 30); 

insert into membership_types
values (2, 'premium', 20); 

-- group_exercise_logs
insert into group_exercise_logs
values (00000000000000000001, 'yoga', 21051, 0000000014); 

insert into group_exercise_logs
values (00000000000000000002, 'yoga', 12118, 0000000028); 

insert into group_exercise_logs
values (00000000000000000003, 'cycling', 33657, 0000000010); 

insert into group_exercise_logs
values (00000000000000000004, 'karate', 29929, 0000000029); 

insert into group_exercise_logs
values (00000000000000000005, 'cycling', 32928, 0000000016); 

insert into group_exercise_logs
values (00000000000000000006, 'variety', 34631, 0000000010); 

insert into group_exercise_logs
values (00000000000000000007, 'variety', 51788, 0000000008); 

insert into group_exercise_logs
values (00000000000000000008, 'yoga', 54646, 0000000008); 

insert into group_exercise_logs
values (00000000000000000009, 'variety', 90042, 0000000011); 

insert into group_exercise_logs
values (00000000000000000010, 'variety', 38916, 0000000008); 

insert into group_exercise_logs
values (00000000000000000011, 'cycling', 40071, 0000000023); 

insert into group_exercise_logs
values (00000000000000000012, 'cycling', 90042, 0000000005); 

insert into group_exercise_logs
values (00000000000000000013, 'kick boxing', 23691, 0000000027); 

insert into group_exercise_logs
values (00000000000000000014, 'karate', 97408, 0000000001); 

insert into group_exercise_logs
values (00000000000000000015, 'cycling', 54646, 0000000005); 

insert into group_exercise_logs
values (00000000000000000016, 'kick boxing', 17042, 0000000027); 

insert into group_exercise_logs
values (00000000000000000017, 'karate', 25444, 0000000010); 

insert into group_exercise_logs
values (00000000000000000018, 'yoga', 17042, 0000000003); 

insert into group_exercise_logs
values (00000000000000000019, 'variety', 17042, 0000000027); 

insert into group_exercise_logs
values (00000000000000000020, 'cycling', 30401, 0000000017); 

insert into group_exercise_logs
values (00000000000000000021, 'cycling', 38916, 0000000003); 

insert into group_exercise_logs
values (00000000000000000022, 'cycling', 34518, 0000000006); 

insert into group_exercise_logs
values (00000000000000000023, 'cycling', 90042, 0000000030); 

insert into group_exercise_logs
values (00000000000000000024, 'kick boxing', 34518, 0000000011); 

insert into group_exercise_logs
values (00000000000000000025, 'variety', 32928, 0000000002); 

insert into group_exercise_logs
values (00000000000000000026, 'karate', 38916, 0000000028); 

insert into group_exercise_logs
values (00000000000000000027, 'kick boxing', 20662, 0000000016); 

insert into group_exercise_logs
values (00000000000000000028, 'karate', 58989, 0000000016); 

insert into group_exercise_logs
values (00000000000000000029, 'kick boxing', 17042, 0000000009); 

insert into group_exercise_logs
values (00000000000000000030, 'karate', 77157, 0000000011); 

insert into group_exercise_logs
values (00000000000000000031, 'karate', 21691, 0000000027); 

insert into group_exercise_logs
values (00000000000000000032, 'variety', 33657, 0000000011); 

insert into group_exercise_logs
values (00000000000000000033, 'karate', 51788, 0000000012); 

insert into group_exercise_logs
values (00000000000000000034, 'karate', 93832, 0000000026); 

insert into group_exercise_logs
values (00000000000000000035, 'kick boxing', 23691, 0000000010); 

insert into group_exercise_logs
values (00000000000000000036, 'karate', 34631, 0000000021); 

insert into group_exercise_logs
values (00000000000000000037, 'variety', 24797, 0000000019); 

insert into group_exercise_logs
values (00000000000000000038, 'karate', 40071, 0000000008); 

insert into group_exercise_logs
values (00000000000000000039, 'cycling', 25175, 0000000011); 

insert into group_exercise_logs
values (00000000000000000040, 'karate', 82733, 0000000017); 

insert into group_exercise_logs
values (00000000000000000041, 'karate', 38916, 0000000028); 

insert into group_exercise_logs
values (00000000000000000042, 'cycling', 13251, 0000000017); 

insert into group_exercise_logs
values (00000000000000000043, 'variety', 60388, 0000000029); 

insert into group_exercise_logs
values (00000000000000000044, 'cycling', 30401, 0000000008); 

insert into group_exercise_logs
values (00000000000000000045, 'karate', 30645, 0000000022); 

insert into group_exercise_logs
values (00000000000000000046, 'variety', 23691, 0000000014); 

insert into group_exercise_logs
values (00000000000000000047, 'kick boxing', 18708, 0000000028); 

insert into group_exercise_logs
values (00000000000000000048, 'cycling', 13251, 0000000013); 

insert into group_exercise_logs
values (00000000000000000049, 'karate', 35869, 0000000005); 

insert into group_exercise_logs
values (00000000000000000050, 'variety', 91568, 0000000017); 

insert into group_exercise_logs
values (00000000000000000051, 'yoga', 75492, 0000000014); 

insert into group_exercise_logs
values (00000000000000000052, 'karate', 89888, 0000000016); 

insert into group_exercise_logs
values (00000000000000000053, 'yoga', 89888, 0000000009); 

insert into group_exercise_logs
values (00000000000000000054, 'cycling', 24746, 0000000020); 

insert into group_exercise_logs
values (00000000000000000055, 'kick boxing', 17042, 0000000019); 

insert into group_exercise_logs
values (00000000000000000056, 'kick boxing', 25175, 0000000002); 

insert into group_exercise_logs
values (00000000000000000057, 'yoga', 37715, 0000000005); 

insert into group_exercise_logs
values (00000000000000000058, 'yoga', 62689, 0000000024); 

insert into group_exercise_logs
values (00000000000000000059, 'variety', 38916, 0000000023); 

insert into group_exercise_logs
values (00000000000000000060, 'cycling', 15265, 0000000024); 

insert into group_exercise_logs
values (00000000000000000061, 'variety', 23691, 0000000012); 

insert into group_exercise_logs
values (00000000000000000062, 'karate', 26607, 0000000002); 

insert into group_exercise_logs
values (00000000000000000063, 'yoga', 38916, 0000000024); 

insert into group_exercise_logs
values (00000000000000000064, 'kick boxing', 60388, 0000000001); 

insert into group_exercise_logs
values (00000000000000000065, 'karate', 34518, 0000000030); 

insert into group_exercise_logs
values (00000000000000000066, 'kick boxing', 76919, 0000000030); 

insert into group_exercise_logs
values (00000000000000000067, 'yoga', 62689, 0000000020); 

insert into group_exercise_logs
values (00000000000000000068, 'karate', 47404, 0000000010); 

insert into group_exercise_logs
values (00000000000000000069, 'variety', 30645, 0000000004); 

insert into group_exercise_logs
values (00000000000000000070, 'kick boxing', 21691, 0000000001); 

insert into group_exercise_logs
values (00000000000000000071, 'kick boxing', 35869, 0000000020); 

insert into group_exercise_logs
values (00000000000000000072, 'karate', 37715, 0000000007); 

insert into group_exercise_logs
values (00000000000000000073, 'yoga', 35869, 0000000007); 

insert into group_exercise_logs
values (00000000000000000074, 'karate', 19753, 0000000029); 

insert into group_exercise_logs
values (00000000000000000075, 'kick boxing', 36155, 0000000030); 

insert into group_exercise_logs
values (00000000000000000076, 'karate', 54646, 0000000026); 

insert into group_exercise_logs
values (00000000000000000077, 'variety', 75492, 0000000004); 

insert into group_exercise_logs
values (00000000000000000078, 'karate', 25175, 0000000029); 

insert into group_exercise_logs
values (00000000000000000079, 'kick boxing', 19753, 0000000017); 

insert into group_exercise_logs
values (00000000000000000080, 'cycling', 17042, 0000000008); 

insert into group_exercise_logs
values (00000000000000000081, 'variety', 24609, 0000000028); 

insert into group_exercise_logs
values (00000000000000000082, 'cycling', 35869, 0000000010); 

insert into group_exercise_logs
values (00000000000000000083, 'karate', 89888, 0000000030); 

insert into group_exercise_logs
values (00000000000000000084, 'variety', 38916, 0000000004); 

insert into group_exercise_logs
values (00000000000000000085, 'yoga', 20662, 0000000023); 

insert into group_exercise_logs
values (00000000000000000086, 'yoga', 91568, 0000000016); 

insert into group_exercise_logs
values (00000000000000000087, 'cycling', 29929, 0000000006); 

insert into group_exercise_logs
values (00000000000000000088, 'kick boxing', 24797, 0000000014); 

insert into group_exercise_logs
values (00000000000000000089, 'karate', 58989, 0000000020); 

insert into group_exercise_logs
values (00000000000000000090, 'karate', 30645, 0000000011); 

insert into group_exercise_logs
values (00000000000000000091, 'cycling', 28521, 0000000006); 

insert into group_exercise_logs
values (00000000000000000092, 'variety', 93832, 0000000011); 

insert into group_exercise_logs
values (00000000000000000093, 'yoga', 12118, 0000000027); 

insert into group_exercise_logs
values (00000000000000000094, 'variety', 24609, 0000000005); 

insert into group_exercise_logs
values (00000000000000000095, 'cycling', 13791, 0000000012); 

insert into group_exercise_logs
values (00000000000000000096, 'cycling', 47404, 0000000004); 

insert into group_exercise_logs
values (00000000000000000097, 'kick boxing', 12118, 0000000015); 

insert into group_exercise_logs
values (00000000000000000098, 'cycling', 60388, 0000000021); 

insert into group_exercise_logs
values (00000000000000000099, 'kick boxing', 24797, 0000000008); 

insert into group_exercise_logs
values (00000000000000000100, 'cycling', 47404, 0000000018); 

-- individual_activity_type
insert into individual_activity_type
values ('running'); 

insert into individual_activity_type
values ('push-ups'); 

insert into individual_activity_type
values ('weight lifting'); 

-- individual_exercise_logs
insert into individual_exercise_logs
values (00000000000000000001, 75492, 'title here', 'push-ups', '2015-03-06 14-20-00', '2015-03-06 15-20-00'); 

insert into individual_exercise_logs
values (00000000000000000002, 35869, 'title here', 'weight lifting', '2015-12-26 16-50-00', '2015-12-26 17-50-00'); 

insert into individual_exercise_logs
values (00000000000000000003, 30645, 'title here', 'weight lifting', '2016-09-25 10-50-00', '2016-09-25 11-50-00'); 

insert into individual_exercise_logs
values (00000000000000000004, 45203, 'title here', 'push-ups', '2016-07-26 09-10-00', '2016-07-26 10-10-00'); 

insert into individual_exercise_logs
values (00000000000000000005, 37715, 'title here', 'push-ups', '2015-05-03 16-50-00', '2015-05-03 17-50-00'); 

insert into individual_exercise_logs
values (00000000000000000006, 25175, 'title here', 'push-ups', '2015-04-07 18-00-00', '2015-04-07 19-00-00'); 

insert into individual_exercise_logs
values (00000000000000000007, 34518, 'title here', 'weight lifting', '2014-05-16 19-20-00', '2014-05-16 20-20-00'); 

insert into individual_exercise_logs
values (00000000000000000008, 19753, 'title here', 'running', '2015-10-17 13-50-00', '2015-10-17 14-50-00'); 

insert into individual_exercise_logs
values (00000000000000000009, 12118, 'title here', 'push-ups', '2015-03-04 16-00-00', '2015-03-04 17-00-00'); 

insert into individual_exercise_logs
values (00000000000000000010, 54646, 'title here', 'running', '2015-12-28 07-00-00', '2015-12-28 08-00-00'); 

insert into individual_exercise_logs
values (00000000000000000011, 34631, 'title here', 'push-ups', '2016-05-16 19-20-00', '2016-05-16 20-20-00'); 

insert into individual_exercise_logs
values (00000000000000000012, 23691, 'title here', 'weight lifting', '2015-06-06 17-30-00', '2015-06-06 18-30-00'); 

insert into individual_exercise_logs
values (00000000000000000013, 13251, 'title here', 'running', '2015-08-05 17-10-00', '2015-08-05 18-10-00'); 

insert into individual_exercise_logs
values (00000000000000000014, 85625, 'title here', 'push-ups', '2016-07-02 10-30-00', '2016-07-02 11-30-00'); 

insert into individual_exercise_logs
values (00000000000000000015, 58989, 'title here', 'push-ups', '2015-04-26 18-50-00', '2015-04-26 19-50-00'); 

insert into individual_exercise_logs
values (00000000000000000016, 51788, 'title here', 'push-ups', '2014-09-12 12-40-00', '2014-09-12 13-40-00'); 

insert into individual_exercise_logs
values (00000000000000000017, 33657, 'title here', 'push-ups', '2014-12-24 11-30-00', '2014-12-24 12-30-00'); 

insert into individual_exercise_logs
values (00000000000000000018, 47404, 'title here', 'weight lifting', '2015-12-03 11-30-00', '2015-12-03 12-30-00'); 

insert into individual_exercise_logs
values (00000000000000000019, 18708, 'title here', 'running', '2014-03-02 15-30-00', '2014-03-02 16-30-00'); 

insert into individual_exercise_logs
values (00000000000000000020, 24797, 'title here', 'weight lifting', '2014-07-26 15-10-00', '2014-07-26 16-10-00'); 

insert into individual_exercise_logs
values (00000000000000000021, 62689, 'title here', 'weight lifting', '2016-02-16 18-00-00', '2016-02-16 19-00-00'); 

insert into individual_exercise_logs
values (00000000000000000022, 51788, 'title here', 'push-ups', '2014-02-11 08-40-00', '2014-02-11 09-40-00'); 

insert into individual_exercise_logs
values (00000000000000000023, 18708, 'title here', 'running', '2015-04-26 14-10-00', '2015-04-26 15-10-00'); 

insert into individual_exercise_logs
values (00000000000000000024, 76919, 'title here', 'weight lifting', '2015-01-01 13-10-00', '2015-01-01 14-10-00'); 

insert into individual_exercise_logs
values (00000000000000000025, 25444, 'title here', 'running', '2015-03-17 12-10-00', '2015-03-17 13-10-00'); 

insert into individual_exercise_logs
values (00000000000000000026, 21691, 'title here', 'push-ups', '2014-05-18 09-00-00', '2014-05-18 10-00-00'); 

insert into individual_exercise_logs
values (00000000000000000027, 21691, 'title here', 'weight lifting', '2014-09-23 16-10-00', '2014-09-23 17-10-00'); 

insert into individual_exercise_logs
values (00000000000000000028, 34631, 'title here', 'running', '2014-02-18 07-30-00', '2014-02-18 08-30-00'); 

insert into individual_exercise_logs
values (00000000000000000029, 33657, 'title here', 'running', '2016-11-11 10-30-00', '2016-11-11 11-30-00'); 

insert into individual_exercise_logs
values (00000000000000000030, 40071, 'title here', 'push-ups', '2016-12-10 07-50-00', '2016-12-10 08-50-00'); 

insert into individual_exercise_logs
values (00000000000000000031, 37715, 'title here', 'running', '2014-03-13 13-10-00', '2014-03-13 14-10-00'); 

insert into individual_exercise_logs
values (00000000000000000032, 12118, 'title here', 'weight lifting', '2015-06-26 10-50-00', '2015-06-26 11-50-00'); 

insert into individual_exercise_logs
values (00000000000000000033, 26607, 'title here', 'running', '2015-03-12 11-30-00', '2015-03-12 12-30-00'); 

insert into individual_exercise_logs
values (00000000000000000034, 35869, 'title here', 'weight lifting', '2014-07-11 14-00-00', '2014-07-11 15-00-00'); 

insert into individual_exercise_logs
values (00000000000000000035, 12118, 'title here', 'weight lifting', '2016-01-15 19-40-00', '2016-01-15 20-40-00'); 

insert into individual_exercise_logs
values (00000000000000000036, 76919, 'title here', 'running', '2014-09-23 17-50-00', '2014-09-23 18-50-00'); 

insert into individual_exercise_logs
values (00000000000000000037, 89888, 'title here', 'running', '2014-11-14 09-20-00', '2014-11-14 10-20-00'); 

insert into individual_exercise_logs
values (00000000000000000038, 30401, 'title here', 'push-ups', '2015-01-13 10-00-00', '2015-01-13 11-00-00'); 

insert into individual_exercise_logs
values (00000000000000000039, 24609, 'title here', 'weight lifting', '2015-08-13 08-00-00', '2015-08-13 09-00-00'); 

insert into individual_exercise_logs
values (00000000000000000040, 23691, 'title here', 'push-ups', '2014-09-17 09-10-00', '2014-09-17 10-10-00'); 

insert into individual_exercise_logs
values (00000000000000000041, 34518, 'title here', 'weight lifting', '2014-03-27 11-30-00', '2014-03-27 12-30-00'); 

insert into individual_exercise_logs
values (00000000000000000042, 62689, 'title here', 'weight lifting', '2015-09-07 17-40-00', '2015-09-07 18-40-00'); 

insert into individual_exercise_logs
values (00000000000000000043, 25444, 'title here', 'push-ups', '2015-08-01 17-10-00', '2015-08-01 18-10-00'); 

insert into individual_exercise_logs
values (00000000000000000044, 93832, 'title here', 'running', '2014-12-17 13-00-00', '2014-12-17 14-00-00'); 

insert into individual_exercise_logs
values (00000000000000000045, 25444, 'title here', 'running', '2014-08-17 17-50-00', '2014-08-17 18-50-00'); 

insert into individual_exercise_logs
values (00000000000000000046, 37715, 'title here', 'running', '2014-11-09 10-00-00', '2014-11-09 11-00-00'); 

insert into individual_exercise_logs
values (00000000000000000047, 90042, 'title here', 'running', '2015-12-13 16-50-00', '2015-12-13 17-50-00'); 

insert into individual_exercise_logs
values (00000000000000000048, 32928, 'title here', 'push-ups', '2014-08-28 15-40-00', '2014-08-28 16-40-00'); 

insert into individual_exercise_logs
values (00000000000000000049, 51788, 'title here', 'running', '2015-01-24 09-30-00', '2015-01-24 10-30-00'); 

insert into individual_exercise_logs
values (00000000000000000050, 75492, 'title here', 'running', '2014-04-02 12-30-00', '2014-04-02 13-30-00'); 

insert into individual_exercise_logs
values (00000000000000000051, 25175, 'title here', 'weight lifting', '2015-07-23 18-50-00', '2015-07-23 19-50-00'); 

insert into individual_exercise_logs
values (00000000000000000052, 47404, 'title here', 'push-ups', '2016-09-23 11-20-00', '2016-09-23 12-20-00'); 

insert into individual_exercise_logs
values (00000000000000000053, 93832, 'title here', 'running', '2016-02-22 14-00-00', '2016-02-22 15-00-00'); 

insert into individual_exercise_logs
values (00000000000000000054, 12118, 'title here', 'running', '2014-01-27 18-50-00', '2014-01-27 19-50-00'); 

insert into individual_exercise_logs
values (00000000000000000055, 32928, 'title here', 'weight lifting', '2015-02-02 16-40-00', '2015-02-02 17-40-00'); 

insert into individual_exercise_logs
values (00000000000000000056, 15265, 'title here', 'weight lifting', '2014-04-27 13-20-00', '2014-04-27 14-20-00'); 

insert into individual_exercise_logs
values (00000000000000000057, 29929, 'title here', 'push-ups', '2016-04-25 19-20-00', '2016-04-25 20-20-00'); 

insert into individual_exercise_logs
values (00000000000000000058, 20662, 'title here', 'push-ups', '2015-12-22 07-50-00', '2015-12-22 08-50-00'); 

insert into individual_exercise_logs
values (00000000000000000059, 13791, 'title here', 'weight lifting', '2016-04-19 09-20-00', '2016-04-19 10-20-00'); 

insert into individual_exercise_logs
values (00000000000000000060, 76919, 'title here', 'weight lifting', '2016-07-09 14-00-00', '2016-07-09 15-00-00'); 

insert into individual_exercise_logs
values (00000000000000000061, 38916, 'title here', 'weight lifting', '2014-02-15 18-10-00', '2014-02-15 19-10-00'); 

insert into individual_exercise_logs
values (00000000000000000062, 32928, 'title here', 'weight lifting', '2014-03-24 09-30-00', '2014-03-24 10-30-00'); 

insert into individual_exercise_logs
values (00000000000000000063, 90042, 'title here', 'running', '2016-01-04 13-40-00', '2016-01-04 14-40-00'); 

insert into individual_exercise_logs
values (00000000000000000064, 21051, 'title here', 'running', '2014-03-13 07-20-00', '2014-03-13 08-20-00'); 

insert into individual_exercise_logs
values (00000000000000000065, 60388, 'title here', 'running', '2014-10-16 17-20-00', '2014-10-16 18-20-00'); 

insert into individual_exercise_logs
values (00000000000000000066, 90042, 'title here', 'push-ups', '2015-02-12 19-40-00', '2015-02-12 20-40-00'); 

insert into individual_exercise_logs
values (00000000000000000067, 54646, 'title here', 'weight lifting', '2016-02-06 10-40-00', '2016-02-06 11-40-00'); 

insert into individual_exercise_logs
values (00000000000000000068, 60388, 'title here', 'running', '2014-04-26 11-20-00', '2014-04-26 12-20-00'); 

insert into individual_exercise_logs
values (00000000000000000069, 33657, 'title here', 'weight lifting', '2015-11-26 16-40-00', '2015-11-26 17-40-00'); 

insert into individual_exercise_logs
values (00000000000000000070, 51788, 'title here', 'push-ups', '2014-07-26 12-10-00', '2014-07-26 13-10-00'); 

insert into individual_exercise_logs
values (00000000000000000071, 77157, 'title here', 'running', '2014-01-21 09-00-00', '2014-01-21 10-00-00'); 

insert into individual_exercise_logs
values (00000000000000000072, 25175, 'title here', 'push-ups', '2015-03-07 08-20-00', '2015-03-07 09-20-00'); 

insert into individual_exercise_logs
values (00000000000000000073, 58989, 'title here', 'running', '2014-06-11 18-40-00', '2014-06-11 19-40-00'); 

insert into individual_exercise_logs
values (00000000000000000074, 60388, 'title here', 'weight lifting', '2014-06-23 17-10-00', '2014-06-23 18-10-00'); 

insert into individual_exercise_logs
values (00000000000000000075, 19753, 'title here', 'weight lifting', '2014-08-03 12-50-00', '2014-08-03 13-50-00'); 

insert into individual_exercise_logs
values (00000000000000000076, 62689, 'title here', 'weight lifting', '2015-04-07 15-30-00', '2015-04-07 16-30-00'); 

insert into individual_exercise_logs
values (00000000000000000077, 38916, 'title here', 'running', '2014-04-10 08-10-00', '2014-04-10 09-10-00'); 

insert into individual_exercise_logs
values (00000000000000000078, 19753, 'title here', 'running', '2016-05-06 07-50-00', '2016-05-06 08-50-00'); 

insert into individual_exercise_logs
values (00000000000000000079, 77157, 'title here', 'push-ups', '2015-05-11 10-30-00', '2015-05-11 11-30-00'); 

insert into individual_exercise_logs
values (00000000000000000080, 75492, 'title here', 'push-ups', '2016-04-01 07-00-00', '2016-04-01 08-00-00'); 

insert into individual_exercise_logs
values (00000000000000000081, 24746, 'title here', 'running', '2014-01-23 11-50-00', '2014-01-23 12-50-00'); 

insert into individual_exercise_logs
values (00000000000000000082, 62689, 'title here', 'push-ups', '2014-06-16 08-10-00', '2014-06-16 09-10-00'); 

insert into individual_exercise_logs
values (00000000000000000083, 12118, 'title here', 'push-ups', '2016-04-22 08-20-00', '2016-04-22 09-20-00'); 

insert into individual_exercise_logs
values (00000000000000000084, 77157, 'title here', 'running', '2014-12-25 10-20-00', '2014-12-25 11-20-00'); 

insert into individual_exercise_logs
values (00000000000000000085, 25444, 'title here', 'running', '2015-04-15 09-10-00', '2015-04-15 10-10-00'); 

insert into individual_exercise_logs
values (00000000000000000086, 25444, 'title here', 'running', '2016-04-21 08-40-00', '2016-04-21 09-40-00'); 

insert into individual_exercise_logs
values (00000000000000000087, 40071, 'title here', 'weight lifting', '2015-11-10 09-40-00', '2015-11-10 10-40-00'); 

insert into individual_exercise_logs
values (00000000000000000088, 77157, 'title here', 'weight lifting', '2016-12-02 15-30-00', '2016-12-02 16-30-00'); 

insert into individual_exercise_logs
values (00000000000000000089, 47404, 'title here', 'running', '2014-01-05 17-20-00', '2014-01-05 18-20-00'); 

insert into individual_exercise_logs
values (00000000000000000090, 21051, 'title here', 'running', '2014-08-24 18-50-00', '2014-08-24 19-50-00'); 

insert into individual_exercise_logs
values (00000000000000000091, 25444, 'title here', 'running', '2014-12-03 13-50-00', '2014-12-03 14-50-00'); 

insert into individual_exercise_logs
values (00000000000000000092, 19753, 'title here', 'weight lifting', '2014-05-15 13-30-00', '2014-05-15 14-30-00'); 

insert into individual_exercise_logs
values (00000000000000000093, 37715, 'title here', 'push-ups', '2016-09-01 19-30-00', '2016-09-01 20-30-00'); 

insert into individual_exercise_logs
values (00000000000000000094, 75492, 'title here', 'push-ups', '2016-09-16 12-20-00', '2016-09-16 13-20-00'); 

insert into individual_exercise_logs
values (00000000000000000095, 88884, 'title here', 'push-ups', '2015-01-01 19-20-00', '2015-01-01 20-20-00'); 

insert into individual_exercise_logs
values (00000000000000000096, 30401, 'title here', 'running', '2014-01-08 16-50-00', '2014-01-08 17-50-00'); 

insert into individual_exercise_logs
values (00000000000000000097, 77157, 'title here', 'push-ups', '2016-06-06 19-30-00', '2016-06-06 20-30-00'); 

insert into individual_exercise_logs
values (00000000000000000098, 29929, 'title here', 'push-ups', '2014-11-28 16-10-00', '2014-11-28 17-10-00'); 

insert into individual_exercise_logs
values (00000000000000000099, 13251, 'title here', 'push-ups', '2014-08-14 09-30-00', '2014-08-14 10-30-00'); 

insert into individual_exercise_logs
values (00000000000000000100, 47404, 'title here', 'running', '2014-01-02 14-50-00', '2014-01-02 15-50-00'); 

