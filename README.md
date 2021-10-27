# task-1

Basic web-application on spring framework with rest endpoint which returns simple data from postgres db 

### docker
To run docker you need to build .jar file, copy it to docker folder and launch app docker image.
 
> ./mvnw clean package -DskipTests
> 
> cp target/demo-0.0.1-SNAPSHOT.jar src/main/docker
> 
> docker-compose up