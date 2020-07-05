FROM openjdk:8
EXPOSE 8080
ADD target/mocked-service-app.jar mocked-service-app.jar
ENTRYPOINT["java", "-jar", "mocked-service-app.jar"]