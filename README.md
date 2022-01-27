# School Registration System

Please follow below instruction to run this project:

###Browse swagger:
http://localhost:8085/swagger-ui.html

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
4. docker run --name student_registration_container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=student_registration -e MYSQL_USER=manik -e MYSQL_PASSWORD=password -d mysql:latest
5. docker run -p 8080:8060 --name=school-registration-system_container --link student_registration_container:mysql -d school-registration-system
6. docker start <container id>
7. docker logs <container id>

# Docker Compose Spring Boot and MySQL example

## Run the System
Command to run docker-compose:
```bash
docker-compose up
```

Docker will pull the MySQL and Spring Boot images (if our machine does not have it before).

The services can be run on the background with command:
```bash
docker-compose up -d
```

## Stop the System
Stopping all the running containers is also simple with a single command:
```bash
docker-compose down
```

If you need to stop and remove all containers, networks, and all images used by any service in <em>docker-compose.yml</em> file, use the command:
```bash
docker-compose down --rmi all
```