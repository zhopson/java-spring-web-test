FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD

# copy the pom and src code to the container
COPY ./ ./
 
# package our application code
RUN mvn clean package -DskipTests=true
RUN ls -al target
#RUN pwd
FROM openjdk:8-jdk-alpine

MAINTAINER man24@yandex.ru
COPY --from=MAVEN_BUILD /target/web-maven-spring-0.0.1-SNAPSHOT.jar /demo.jar

#RUN apt-get install -y \
#     default-posgresql-client

EXPOSE 8080
# set the startup command to execute the jar
CMD ["java", "-jar", "/demo.jar"]
