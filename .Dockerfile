FROM openjdk:17-alpine
VOLUME /tmp 
COPY ${JAR_FILE} app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app.jar"]