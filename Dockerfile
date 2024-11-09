FROM maven:3.9-eclipse-temurin-21 AS builder
COPY api /usr/src/app/api
COPY src  /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -Dmaven.test.skip=true

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /usr/src/app/target/*.jar /app/phvr-app.jar
EXPOSE 8080
CMD [ "java", "-jar", "phvr-app.jar"]
