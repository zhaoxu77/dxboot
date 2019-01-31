FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD dxboot-0.0.1-SNAPSHOT.jar dxboot.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dxboot.jar"]