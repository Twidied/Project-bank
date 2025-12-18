admin123



crediya_db
docker run --name crediya_db -e MYSQL_ROOT_PASSWORD=admin123 -p 3309:3306 -d mysql:8.4.3

docker exec -it crediya_db mysql -h localhost -u root -P 3306 -p 


CREATE DATABASE crediya_db;

USE crediya_db;

git checkout cambiar rama
git branch 
git merge (nombre rama)


funcionalidad que permita consultar y filtrar los préstamos activos y vencidos, con base en la fecha de vencimiento y el estado del préstamo
optimizando la visualización de la información y preparando el sistema para la generación de reportes.
dentro del sistema una nueva clase llamada GestorPrestamos 