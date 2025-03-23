FROM openjdk:21
COPY ecosphere-admin.jar /server.jar
ENTRYPOINT ["java"]
CMD ["-jar", "server.jar", "--spring.profiles.active=prod"]