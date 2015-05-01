create table vehicle_location (
	vehicle_id SERIAL PRIMARY KEY, 
	id varchar(255),
	route_tag varchar(255),
	dir_tag varchar(255),
	lat float,
	lon float,
	heading float,
	secs_since_report int,
	predictable boolean,
	time bigint
);

create sequence vehile_location_seq;