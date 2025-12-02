# Stage 1: copy the already-built jar
FROM eclipse-temurin:17-jre-jammy AS runtime
WORKDIR /app
# Use the jar that mvnw produced
COPY target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
