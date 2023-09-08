FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
ARG JAR_FILE
COPY ${JAR_FILE} house.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","house.jar"]
