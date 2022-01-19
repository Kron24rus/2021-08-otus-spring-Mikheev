FROM maven:3.8.4-jdk-11 as build

COPY ./frontend /tmp/frontend
RUN mvn -f /tmp/frontend/pom.xml clean package

COPY ./homework /tmp/homework
RUN mvn -f /tmp/homework/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /tmp/homework/target/book-library.jar /app/app.jar
EXPOSE 8098
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
