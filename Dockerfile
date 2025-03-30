FROM openjdk:18
WORKDIR /app
COPY ./target/backend-0.0.1-SNAPSHOT.jar /app
EXPOSE 8083
CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]