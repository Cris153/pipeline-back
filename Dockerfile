FROM openjdk:17.0.1-jdk-slim

WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

EXPOSE 8060

CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]