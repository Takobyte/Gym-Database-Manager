create database gymDB;

use gymDB;

create table gym
	(branch_id char (5),
	name char (40),
	address char (100),
	open_date date,
	telephone integer,
	unique (telephone),
	unique (name),
	unique (address),
	primary key (branch_id));

create table main_equipment_rooms 
	(rid char (5),
	descriptive_name char (40),
	capacity integer,
	branch_id char (5) not null,
	unique (branch_id,descriptive_name),
	primary key (rid),
	foreign key (branch_id) references gym (branch_id) on delete cascade);

create table activity_rooms 
	(rid char (5),
	descriptive_name char (40),
	capacity integer,
	branch_id char (5) not null,
	unique (branch_id,descriptive_name),
	primary key (rid),
	foreign key (branch_id) references gym (branch_id) on delete cascade);

create table suppliers 
	(sid char (5),
	name char (40),
	telephone integer,
	address char (100),
	unique (name, telephone),
	primary key (sid));

create table equipment
	(equip_id char (5),
	name char (40),
	model_no char (20),
	price real,
	purchase_date date,
	last_service_date date,
	months_to_next_service integer,
	rid char (5) not null,
	sid char (5) not null,
	primary key (equip_id),
	foreign key (rid) references activity_rooms (rid),
	foreign key (sid) references suppliers (sid));

create table employees 
	(emp_id char (10),
	name char (40),
	job_title char (40),
	salary integer,
	address char (100),
	dob date,
	telephone integer,
	manager_flag real,
	instructor_flag real,
	primary key (emp_id));

create table works_in 
	(emp_id char (10),
	branch_id char (5),
	from_date date,
	to_date date,
	primary key (emp_id, branch_id, from_date, to_date),
	foreign key (emp_id) references employees (emp_id) on delete cascade,
	foreign key (branch_id) references gym (branch_id) on delete cascade);

create table class_type 
	(class_name char (40),
	primary key (class_name));

create table group_classes
	(gid char (10),
	class_name char (40),
	price_for_std_member real,
	start_time date,
	end_time date,
	rid char (5) not null,
	unique (rid, start_time, end_time),
	primary key (gid),
	foreign key (rid) references activity_rooms (rid) on delete cascade,
	foreign key (class_name) references class_type (class_name) on delete cascade);

create table teaches 
	(emp_id char (10),
	gid char (10),
	primary key (emp_id,gid),
	foreign key (emp_id) references employees (emp_id) on delete cascade,
	foreign key (gid) references group_classes (gid) on delete cascade);

create table members 
	(mid char (10),
	name char (40),
	telephone integer,
	dob date,
	address char (100),
	std_exp_date date,
	prm_exp_date date,
	branch_id char (5) not null,
	unique (name,telephone),
	primary key (mid),
	foreign key (branch_id) references gym (branch_id));

create table class_purchases 
	(pid char (10),
	gid char (10) not null,
	mid char (10),
	amt_paid real,
	paid_date date,
	primary key (pid),
	foreign key (gid) references group_classes (gid),
	foreign key (mid) references members (mid) on delete cascade);

create table membership_types 
	(pid char (10),
	name char (40),
	monthly_fee real,
	unique (name),
	primary key (pid));

create table group_exercise_logs 
	(log_no char (20),
	title char (40),
	mid char (10) not null,
	gid char (10) not null,
	primary key (log_no, mid),
	foreign key (mid) references members (mid) on delete cascade,
	foreign key (gid) references group_classes (gid));

create table individual_activity_type 
	(individual_activity_name char(40),
	primary key (individual_activity_name));

create table individual_exercise_logs 
	(log_no char (20),
	mid char (10) not null,
	title char (40),
	individual_activity_name char (40),
	start_time date,
	end_time date,
	unique (mid,start_time,end_time),
	primary key (log_no,mid),
	foreign key (mid) references members (mid) on delete cascade,
	foreign key (individual_activity_name) references individual_activity_type (individual_activity_name) on delete cascade);