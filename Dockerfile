FROM openjdk:17-jdk-slim-buster as builder
WORKDIR /builder
COPY . /builder/
RUN ./mvnw install

FROM gcr.io/distroless/java17-debian11 as app
WORKDIR /app
COPY --from=builder /builder/target/*.jar /app/
ENTRYPOINT ["java", "-jar", "springtryout-0.0.1-SNAPSHOT.jar"]