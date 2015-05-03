create table route (
	route_id SERIAL PRIMARY KEY, 
	tag varchar(255),
	title varchar(255)
);

create sequence route_seq;
