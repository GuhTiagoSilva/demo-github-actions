FROM maven:3.6-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY --from=build /home/app/target/demo-github-actions-0.0.1.jar demo-github-actions.jar
ENTRYPOINT ["java","-jar","/demo-github-actions.jar"]