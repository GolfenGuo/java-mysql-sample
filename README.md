
This sample is built for DaoCloud, a docker based continuous integration and deployment platform.

## App env and defaul value
* MYSQL_INSTANCE_NAME = daocloud
* MYSQL_USERNAME = root
* MYSQL_PASSWORD = /* root user don't need password by default */
* MYSQL_PORT_3306_TCP_ADDR = localhost
* MYSQL_PORT_3306_TCP_PORT = 3306

## Run Container
docker run --link your_mysql:mysql -p 8080:8080 java-mysql-sample