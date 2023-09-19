#define base docker image
FROM openjdk:19
LABEL maintainer="javaguides.net"
ADD target/dockerizing-0.0.1-SNAPSHOT.jar dockerizing.jar
ENTRYPOINT ["java", "-jar", "dockerizing.jar"]