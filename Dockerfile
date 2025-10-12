FROM maven:3.9-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/app-main/target/app-main-1.0.0.jar /app/app-main-1.0.0.jar
EXPOSE 8085
EXPOSE 9091
ENTRYPOINT [ "java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8787", "-jar", "/app/app-main-1.0.0.jar" ]



