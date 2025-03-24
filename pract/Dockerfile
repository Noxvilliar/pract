FROM gradle:8.5.0-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/build/libs/pract-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"] 