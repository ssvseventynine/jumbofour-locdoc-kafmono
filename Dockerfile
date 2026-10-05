# Step 1: Use an official lightweight OpenJDK runtime image
FROM eclipse-temurin:21-jdk-jammy

# Step 2: Set the working directory inside the container's virtual filesystem
WORKDIR /app

# Step 3: Copy the pre-built executable jar file from your local target folder into the container
COPY target/*.jar app.jar

# Step 4: Expose port 8080 so traffic can reach the internal Tomcat server
EXPOSE 8080

# Step 5: The startup command to run your monolith when the container boots
ENTRYPOINT ["java", "-jar", "app.jar"]