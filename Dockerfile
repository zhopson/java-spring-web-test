FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD

# copy the pom and src code to the container
COPY ./ ./
 
# package our application code
#RUN bash -c 'while !</dev/tcp/db/5432; do sleep 1; done; mvn clean package'
RUN mvn clean package -DskipTests=true
#RUN mvn compile
RUN ls -al target
#RUN pwd
FROM openjdk:8-jdk-alpine

#FROM openjdk
MAINTAINER man24@yandex.ru
#VOLUME /tmp
#EXPOSE 8080
#mvn compile
#ADD target/web-maven-spring-0.0.1-SNAPSHOT.jar springbootpostgresqldocker.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springbootpostgresqldocker.jar"]

#COPY --from=MAVEN_BUILD /java-spring-web-test/target/web-maven-spring-0.0.1-SNAPSHOT.jar /demo.jar
COPY --from=MAVEN_BUILD /target/web-maven-spring-0.0.1-SNAPSHOT.jar /demo.jar

#RUN apt-get install -y \
#     default-posgresql-client

EXPOSE 8080
# set the startup command to execute the jar
CMD ["java", "-jar", "/demo.jar"]
#CMD ["psql", "-h", "127.0.0.1", "-p", "5433", "-U", "ruser", "-d", "services"]
#CMD ["ps"]