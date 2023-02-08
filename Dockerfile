FROM alpine:3.17
ARG version=17.0.6.10.1
COPY build/libs/superkassa-backend-test-1.0-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "superkassa-backend-test-1.0-SNAPSHOT.jar"]