create table User(user_id int not null auto_increment,
	username varchar(10) not null,
	`password` varbinary(256) not null,
	role varchar(20),
	primary key(user_id));

create table Contact(contact_id int not null auto_increment,
	user_id int not null,
	firstName varchar(50) not null,
	lastName varchar(50) not null,
	address varchar(45) not null,
	city varchar(45) not null,
	state varchar(45) null,
	zip varchar(10) null,
	country varchar(45) not null,
	phone varchar(20) not null,
	primary key(contact_id, user_id),
	foreign key(user_id) references User(user_id));

create table Service(service_id int not null auto_increment,
	user_id int not null,
	start_date date null,
	end_date date null,
	short_desc varchar(45) null,
	long_desc varchar(250) null,
	primary key(service_id),
	foreign key(user_id) references User(user_id));

create table User_Service(user_id int not null,
	service_id int not null,
	primary key(user_id, service_id),
	foreign key(user_id) references Volunteer(user_id),
	foreign key(service_id) references Service(service_id));

create table Location(location_id int not null auto_increment,
	service_id int not null,
	city varchar(45) not null,
	state varchar(45) null,
	zip varchar(10) null,
	country varchar(45) not null,
	primary key(location_id, service_id),
	foreign key(service_id) references Service(service_id));
	

