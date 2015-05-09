create table stop (
	stop_id SERIAL PRIMARY KEY, 
	tag varchar(255),
	title varchar(255),
	lat float,
	lon float,
	id varchar(255),
	route_id integer,
	foreign key(route_id) references route(route_id),
	constraint stop_id_idx unique (id)
);

create sequence stop_seq;
