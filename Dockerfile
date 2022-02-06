FROM openjdk:11
EXPOSE 8080
ADD target/school-registration-system.jar school-registration-system.jar
ENTRYPOINT ["java", "-jar", "/school-registration-system.jar"]


#docker container run --name school-registration-system -p 8080:8080 -d school-registration-system
