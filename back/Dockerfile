FROM maven:3.8.5-eclipse-temurin-17 AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package

FROM eclipse-temurin:17-jdk
COPY --from=build /app/target/*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]
