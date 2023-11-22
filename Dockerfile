FROM openjdk:17-jdk

COPY ./target/api-recommendation.jar /opt/app/app.jar

WORKDIR /opt/app


ENTRYPOINT ["java", "-jar", "app.jar"]