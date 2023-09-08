FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests


#
# Package stage
#
FROM openjdk:17-jre-slim
COPY --from=build /house/target/house-0.0.1.jar /usr/local/lib/house.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/usr/local/lib/house.jar"]



