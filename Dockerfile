FROM maven:3.9-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY ./pom.xml .
COPY ./src ./src
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/app-0.0.1.jar /app/app-0.0.1.jar
EXPOSE 8085
EXPOSE 9091
ENTRYPOINT [ "java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8787", "-jar", "/app/app-0.0.1.jar" ]




