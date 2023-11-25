FROM openjdk:17-jdk

COPY ./target/api-recommendation.jar /opt/app/app.jar

WORKDIR /opt/app

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]