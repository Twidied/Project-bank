admin123



crediya_db
docker run --name crediya_db -e MYSQL_ROOT_PASSWORD=admin123 -p 3309:3306 -d mysql:8.4.3

docker exec -it crediya_db mysql -h localhost -u root -P 3306 -p 


CREATE DATABASE crediya_db;

USE crediya_db;