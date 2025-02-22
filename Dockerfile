# Build stage
FROM gradle:7-jdk17 AS build
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle build --no-daemon

# Run stage
FROM eclipse-temurin:17-jre
EXPOSE 8080
COPY --from=build /app/build/libs/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]