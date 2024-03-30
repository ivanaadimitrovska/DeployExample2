FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/DeployExample2-1.0.0.jar DeployExample2.jar
EXPOSE 5432
ENTRYPOINT ["java", "-jar", "DeployExample2.jar"]
