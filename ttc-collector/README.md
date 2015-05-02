
CREATE EXTENSION postgis;
SELECT PostGIS_full_version();

    update vehicle_location
    set location = ST_SetSRID(ST_MakePoint(lon, lat), 4326);
