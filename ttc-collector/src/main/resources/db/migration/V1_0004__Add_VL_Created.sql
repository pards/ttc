alter table vehicle_location 
add created timestamp with time zone;

update vehicle_location
set created = TIMESTAMP WITH TIME ZONE 'epoch' + (time/1000) * INTERVAL '1 second'
where created is null;

alter table vehicle_location 
ALTER created SET DEFAULT current_timestamp;

alter table vehicle_location 
ALTER created SET NOT NULL;
