# FROM maven:3.8.3-jdk-11 AS MAVEN_BUILD
# COPY ./ ./
# RUN mvn clean package -DskipTests
# # build will use open jdk 11 on adoptopenjdk - hotspot
# FROM adoptopenjdk:11-jre-hotspot
# COPY --from=MAVEN_BUILD /target/demo-0.0.1-SNAPSHOT.jar /demo.jar
# CMD ["java", "-jar", "/demo.jar"]

FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]