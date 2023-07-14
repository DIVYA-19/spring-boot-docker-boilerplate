FROM eclipse-temurin:17

LABEL mentainer="javaguides.net@gmail.com"

WORKDIR /app

COPY target/myproject-0.0.1-SNAPSHOT.jar /app/springboot-restful-webservices.jar

RUN dir -s 

ENTRYPOINT ["java", "-jar", "springboot-restful-webservices.jar"]