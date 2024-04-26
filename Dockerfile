# Use a base image with Java 17 installed
FROM openjdk:17.0.2-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven Wrapper files
COPY .mvn/ .mvn/

# Copy the project files
COPY mvnw ./
COPY mvnw.cmd ./
COPY pom.xml ./

# Copy the source code
COPY src/ ./src/

# Build the Maven project
RUN ./mvnw package -DskipTests

# Expose the port specified in application.properties
EXPOSE 8081

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "target/url-shortener-1.0.jar"]
