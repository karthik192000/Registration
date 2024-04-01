FROM openjdk:11
COPY target/Registration-1.0.0-SNAPSHOT.jar /Registration-1.0.0-SNAPSHOT.jar
CMD ["java", "-jar", "-noverify", "/Registration-1.0.0-SNAPSHOT.jar"]
EXPOSE 8080