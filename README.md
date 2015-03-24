
This sample is built for DaoCloud, a docker based continuous integration and deployment platform.

## Default DB Connection
* DB_NAME = daocloud
* DB_USERNAME = root
* DB_PASSWORD = /* root user don't need password by default */
* DB_HOST = mysql
* DB_PORT = 3306

## Run Container
docker run --link your_mysql:mysql -p 8080:8080 java-mysql-sample
