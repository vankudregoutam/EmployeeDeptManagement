# # Stage 1: Build the JAR file using Maven
# FROM maven:3.8.6-openjdk-17 AS builder
# WORKDIR /build
# COPY pom.xml .
# COPY src ./src
# # Build the application and create the JAR file
# RUN mvn clean package -DskipTests

# # Stage 2: Create the final image to run the JAR
# FROM eclipse-temurin:17-jre-alpine
# WORKDIR /app
# # Copy the JAR from the builder stage
# COPY --from=builder /build/target/*.jar app.jar
# # Make port available to the world outside this container
# EXPOSE $PORT
# # Run the JAR file
# CMD ["java", "-jar", "app.jar", "--server.port=$PORT"]

# # Single stage build (more reliable for network issues)
# FROM eclipse-temurin:17-jdk-alpine
# WORKDIR /app

# # Install Maven manually
# RUN apk add --no-cache maven

# # Copy source code
# COPY pom.xml .
# COPY src ./src

# # Build and run in one step
# RUN mvn clean package -DskipTests
# EXPOSE $PORT
# CMD ["java", "-jar", "/app/app.jar", "--server.port=$PORT"]

# Stage 1: Build the JAR file using Maven
FROM maven:3.8.6-openjdk-17 AS builder
WORKDIR /build
COPY pom.xml .
COPY src ./src
# Build the application and create the JAR file
RUN mvn clean package -DskipTests

# Debug: List the target directory to see the actual JAR filename
RUN ls -la /build/target/

# Stage 2: Create the final image to run the JAR
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the JAR from the builder stage - using the exact filename pattern
COPY --from=builder /build/target/*.jar app.jar

# Debug: List the app directory to verify the JAR is copied
RUN ls -la /app/

# Make port available to the world outside this container
EXPOSE $PORT

# Run the JAR file
CMD ["java", "-jar", "/app/app.jar", "--server.port=$PORT"]