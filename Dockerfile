# Use official OpenJDK image
FROM openjdk:17-jdk-alpine

# Add a volume to avoid issues with Spring Boot temp files
VOLUME /tmp

# Copy the jar file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
