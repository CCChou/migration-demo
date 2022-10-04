FROM registry.access.redhat.com/ubi8/openjdk-17-runtime:1.14-4
COPY target/*.jar /app/todolist.jar
CMD ["java", "-jar", "/app/todolist.jar"]