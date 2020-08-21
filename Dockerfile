FROM openjdk:8-alpine

COPY target/uberjar/legolas.jar /legolas/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/legolas/app.jar"]
