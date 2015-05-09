create table route (
	route_id SERIAL PRIMARY KEY, 
	tag varchar(255),
	title varchar(255),
	constraint route_tag_idx unique (tag)
);

create sequence route_seq;
