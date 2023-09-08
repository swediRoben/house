FROM maven:3.6.0-jdk-11-slim AS build
COPY src /house/src
COPY pom.xml /house/ 
RUN mvn -f /house/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /house/target/house-0.0.1.jar /usr/local/lib/house.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/usr/local/lib/house.jar"]



