FROM maven:3.8.6-openjdk-18 AS MAVEN_BUILD

ADD /target/iksline-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]


