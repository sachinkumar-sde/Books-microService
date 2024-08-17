FROM openjdk:21
EXPOSE 8080
ADD target/books-service.jar books-service.jar
ENTRYPOINT ["java", "-jar", "/books-service.jar"]
