# School Registration System

Please follow below instruction to run this project:

Technology stack:
1. Java - 11
2. Spring Boot
3. Maven
4. MySQL
5. Docker
6. JUnit
7. Zalando (Problem Library)
8. Swagger

Run Commands:
1. mvn clean
2. mvn install
3. mvn spring-boot:run

Generate and run jar file:
1. mvn clean install.
2. cd target
3. java -jar school-registration-system.jar

### Create docker image and run
1. docker build -t school-registration-system .
2. docker run -p 8080:8080 school-registration-system
3. docker container run --name school-registration-system -p 8080:8080 -d school-registration-system
4. docker start <container id>
5. docker logs <container id>

