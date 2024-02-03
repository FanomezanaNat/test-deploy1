FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17.0.1-jdk-slim

COPY --from=build /target/Cielux-0.0.1-SNAPSHOT.jar demo.jar
COPY database.db data/database.db
VOLUME data/
EXPOSE 4005
ENTRYPOINT ["java","-jar","demo.jar"]