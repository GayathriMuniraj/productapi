# Use OpenJDK 17 image
FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Copy everything from your repo into container
COPY . .

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build the project
RUN mvn clean package

# Run the Spring Boot app
CMD ["java", "-jar", "target/productapi-0.0.1-SNAPSHOT.jar"]
