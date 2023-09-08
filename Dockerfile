FROM maven:3.9.1-jdk-17-slim AS build
COPY ..
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17-jre-slim
COPY --from=build /house/target/house-0.0.1.jar /usr/local/lib/house.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/usr/local/lib/house.jar"]



