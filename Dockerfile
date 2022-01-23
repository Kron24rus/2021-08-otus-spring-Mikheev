FROM maven:3.8.4-jdk-11 as build

COPY ./frontend/pom.xml /build/frontend/pom.xml
RUN mvn -f /build/frontend/pom.xml dependency:go-offline -B

COPY ./homework/pom.xml /build/homework/pom.xml
RUN mvn -f /build/homework/pom.xml dependency:go-offline -B

COPY ./frontend /build/frontend
RUN mvn -f /build/frontend/pom.xml package

COPY ./homework /build/homework
RUN mvn -f /build/homework/pom.xml package

FROM openjdk:11-jre-slim
COPY --from=build /build/homework/target/book-library.jar /app/app.jar
EXPOSE 8098
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
