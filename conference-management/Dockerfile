FROM openjdk:17-jdk-slim


WORKDIR /app

COPY target/conference-management-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
