-- change log
-- equipment rid now references changed to main_activity_rooms from activity_rooms 
-- in group_classes table removed class_name (Oliver said to remove since the name is in table class_type)
-- in membership_types changed name of first field to type_id from pid
-- in table membership_types changed domain of type_id from char(10) to char(2)
-- in table member/employee changed domain of mid/emp_id to char(5)

--  **Possible problem to check: classname/classtype tables



create database gym;

use gym;

create table gym
	(branch_id integer auto_increment, 
	name char (40),
	address char (100),
	open_date date,
	telephone char(20),
	unique (telephone),
	unique (name),
	unique (address),
	primary key (branch_id));

create table room 
	(rid integer auto_increment,
	descriptive_name char (40),
	capacity integer,
	branch_id integer not null,
    activity_room_flag bit,
    main_equipment_room_flag bit,
	unique (branch_id,descriptive_name),
	primary key (rid),
	foreign key (branch_id) references gym (branch_id) on delete cascade);

create table suppliers 
	(sid integer auto_increment,
	name char (40),
	telephone char(20),
	address char (100),
	unique (name, telephone),
	primary key (sid));

create table equipment
	(equip_id integer auto_increment,
	name char (40),
	model_no char (20),
	price real,
	purchase_date date,
	last_service_date date,
	months_to_next_service integer,
	rid integer not null,
	sid integer not null,
	primary key (equip_id),
	foreign key (rid) references room (rid),
	foreign key (sid) references suppliers (sid));

create table employees 
	(emp_id integer auto_increment,
	name char (40),
	job_title char (40),
	salary integer,
	address char (100),
	dob date,
	telephone char(20),
	manager_flag real,
	instructor_flag real,
	primary key (emp_id));

create table works_in 
	(emp_id integer auto_increment,
	branch_id integer,
	from_date date,
	to_date date,
	primary key (emp_id, branch_id, from_date, to_date),
	foreign key (emp_id) references employees (emp_id) on delete cascade,
	foreign key (branch_id) references gym (branch_id) on delete cascade);

create table class_type 
	(class_name char (40),
	primary key (class_name));

create table group_classes
	(gid integer auto_increment,
	price_for_std_member real,
	start_time datetime,
	end_time datetime,
	rid integer not null,
	class_name char (40) not null,
	unique (rid, start_time, end_time),
	primary key (gid),
	foreign key (rid) references room (rid) on delete cascade,
	foreign key (class_name) references class_type (class_name) on delete cascade);
    
create table teaches 
	(emp_id integer not null,
	gid integer not null,
	primary key (emp_id,gid),
	foreign key (emp_id) references employees (emp_id) on delete cascade,
	foreign key (gid) references group_classes (gid) on delete cascade);

create table members 
	(mid integer auto_increment,
	name char (40),
	telephone char(20),
	dob date,
	address char (100),
	std_exp_date date,
	prm_exp_date date,
	branch_id integer not null,
	unique (name,telephone),
	primary key (mid),
	foreign key (branch_id) references gym (branch_id));

create table class_purchases 
	(pid integer auto_increment,
	gid integer not null,
	mid integer,
	amt_paid real,
	paid_date date,
	primary key (pid),
	foreign key (gid) references group_classes (gid),
	foreign key (mid) references members (mid) on delete cascade);

create table membership_types 
	(type_id integer,
	name char (40),
	monthly_fee real,
	unique (name),
	primary key (type_id));

create table group_exercise_logs 
	(log_no integer auto_increment,
	title char (40),
	mid integer not null,
	gid integer not null,
	primary key (log_no, mid),
	foreign key (mid) references members (mid) on delete cascade,
	foreign key (gid) references group_classes (gid));

create table individual_activity_type 
	(individual_activity_name char(40),
	primary key (individual_activity_name));

create table individual_exercise_logs 
	(log_no integer auto_increment,
	mid integer not null,
    title char (40),
	individual_activity_name char (40),
	start_time datetime,
	end_time datetime,
	unique (mid,start_time,end_time),
	primary key (log_no,mid),
	foreign key (mid) references members (mid) on delete cascade,
	foreign key (individual_activity_name) references individual_activity_type (individual_activity_name) on delete cascade);