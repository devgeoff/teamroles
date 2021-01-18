FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD /target/teamsproject-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","teamsproject-0.0.1-SNAPSHOT.jar"]