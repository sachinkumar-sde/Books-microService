FROM openjdk:21
EXPOSE 8080
ADD books-service.jar
ENTRYPOINT ["java", "-jar", "/books-service.jar"]
