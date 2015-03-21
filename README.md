
This sample is built for DaoCloud, a docker based continuous integration and deployment platform.

## Run Container
docker run --link your_mysql:mysql -e DB_NAME=daocloud -e DB_USERNAME=db_user -e DB_PASSWORD=db_pass -e DB_HOST=mysql -e DB_PORT=3306 -p 3000:3000 java-mysql-sample
