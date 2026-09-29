FROM amazoncorretto:27-alpine3.24
COPY target/documentprocessor-0.0.1-SNAPSHOT.jar documentprocessor.jar
ENTRYPOINT ["java","-jar","/documentprocessor.jar"]
