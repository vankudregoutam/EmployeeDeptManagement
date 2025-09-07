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

# # Single stage build
# FROM eclipse-temurin:17-jdk-alpine
# WORKDIR /app

# # Install Maven manually
# RUN apk add --no-cache maven

# # Copy source code
# COPY pom.xml .
# COPY src ./src

# # Build the application
# RUN mvn clean package -DskipTests

# # The JAR is created in target/ directory, so we need to reference it there
# EXPOSE $PORT

# # FIXED: Run the JAR from the correct location in target/ directory
# # Using find command to locate the exact JAR filename
# CMD ["sh", "-c", "java -jar target/*.jar --server.port=$PORT"]

# Single stage build - optimized for Render
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Install Maven
RUN apk add --no-cache maven

# Copy only what's needed for building
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Create a simple start script that handles the PORT variable
RUN echo '#!/bin/sh' > start.sh && \
    echo 'java -jar target/*.jar --server.port=$PORT' >> start.sh && \
    chmod +x start.sh

EXPOSE $PORT

# Use the script as entrypoint
CMD ["./start.sh"]