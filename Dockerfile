FROM registry.access.redhat.com/ubi8/openjdk-11:1.14-5 as build
WORKDIR /app/build
COPY . /app/build/.
RUN ["mvn", "clean", "package"]

FROM registry.access.redhat.com/ubi8/openjdk-11-runtime:1.14-5
COPY --from=build /app/build/target/*.jar /app/todolist.jar
CMD ["java", "-jar", "/app/todolist.jar"]