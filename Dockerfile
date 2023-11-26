FROM openjdk:17-jdk

COPY ./target/api-recommendation.jar /opt/app/app.jar

WORKDIR /opt/app

EXPOSE 32188
ENTRYPOINT ["java", "-jar", "app.jar"]