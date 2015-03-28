FROM maven:3-jdk-7

MAINTAINER Golfen Guo "golfen.guo@daocloud.io"

# Prepare by downloading dependencies
WORKDIR /code
ADD pom.xml /code/pom.xml
RUN mvn -q dependency:resolve

# Adding source, compile and package into a WAR
ADD src /code/src
RUN mvn -q -DskipTests=true package
RUN mvn jetty:stop

# Expose port
EXPOSE 8080

CMD ["mvn", "jetty:run"]