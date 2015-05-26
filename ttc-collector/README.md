
# EB Setup
http://blog.goforyt.com/laravel-aws-elastic-beanstalk-dev-guide/

	CREATE EXTENSION postgis;
	SELECT PostGIS_full_version();

    update vehicle_location
    set location = ST_SetSRID(ST_MakePoint(lon, lat), 4326);

http://maps.google.com/maps?q=24.197611,120.780512

-- Get the distance a particular car is from Jameson
select
	v.vehicle_id,
	v.id,
	to_timestamp(v.time/1000) AT TIME ZONE 'EDT' as time, 
	ST_Distance(
		ST_Transform(v.location, 26986),
		ST_Transform(s.location, 26986)
		) as dist, 
	s.title
from vehicle_location v, stop s
where 
    to_timestamp(v.time/1000) AT TIME ZONE 'EDT' > '2015-04-29'
and to_timestamp(v.time/1000) AT TIME ZONE 'EDT' < '2015-04-29 09:00:00'
and s.stop_id =15454
and v.id = '4251';


select to_timestamp(v.time/1000) AT TIME ZONE 'EDT', ST_Distance(v.location, s.location) * 1000 as dist, s.title
from vehicle_location v, stop s
where v.id = '4222'
and to_timestamp(v.time/1000) AT TIME ZONE 'EDT' > '2015-04-28'
and to_timestamp(v.time/1000) AT TIME ZONE 'EDT' < '2015-04-29'
and s.stop_id in (15454, 15472)
and ST_Distance(v.location, s.location) * 1000 < 1
order by time
;

/*
select title, lat, lon, location as stop_loc
from stop
where stop_id in (15454, 15472);
*/

select to_timestamp(1430875194) AT TIME ZONE 'EDT', current_time AT TIME ZONE 'EDT';

select title, lat, lon, location as stop_loc
from stop
where stop_id in (15454, 15472);


select s.title, 'http://maps.google.com/maps?q=' || to_char(lat,'99.9999999') || ',' || to_char(lon,'99.9999999'), s.*
from route r
join stop s on r.route_id = s.route_id
where s.title like '%Jameson%'
and r.tag = '501';

Inbound 
Stop Id 15454, Jameson http://maps.google.com/maps?q=43.6403900,-79.4375200
Stop Id 15472, Univ http://maps.google.com/maps?q=43.6507000,-79.3869300
http://maps.google.com/maps?q=43.640533,-79.39755

