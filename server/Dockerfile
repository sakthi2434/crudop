# Stage 1: Build WAR
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Deploy to Tomcat
FROM tomcat:9.0-jdk17

# Disable Tomcat shutdown port
RUN sed -i 's/port="8005"/port="-1"/' /usr/local/tomcat/conf/server.xml || true

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=builder /app/target/PROJECT_1-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
