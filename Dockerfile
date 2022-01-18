FROM openjdk:11-jre-slim
COPY homework/target/book-library.jar /app/app.jar
EXPOSE 8098
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
