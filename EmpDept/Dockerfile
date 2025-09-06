# Stage 1: Build the JAR file using Maven
FROM maven:3.8.6-openjdk-17 AS builder
WORKDIR /build
COPY pom.xml .
COPY src ./src
# Build the application and create the JAR file
RUN mvn clean package -DskipTests

# Stage 2: Create the final image to run the JAR
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copy the JAR from the builder stage
COPY --from=builder /build/target/*.jar app.jar
# Make port available to the world outside this container
EXPOSE $PORT
# Run the JAR file
CMD ["java", "-jar", "app.jar", "--server.port=$PORT"]