select murid.id as id_murid, murid.name as name, pendidikan.status as pendidikan_terkahir, murid.time_create as time_create, pendidikan.time_create as time_update
from murid left join pendidikan
                     on (murid.id = pendidikan.id);