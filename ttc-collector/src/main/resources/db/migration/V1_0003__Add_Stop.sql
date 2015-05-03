create table stop (
	stop_id SERIAL PRIMARY KEY, 
	tag varchar(255),
	title varchar(255),
	lat float,
	lon float,
	id varchar(255),
	route_id bigint,
	foreign key(route_id) references route(route_id)
);

create sequence stop_seq;
