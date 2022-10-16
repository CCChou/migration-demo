FROM quay.io/rh_ee_dechou/openjdk-11:1.14-5 as build
WORKDIR /app/build
COPY . /app/build/.
RUN ./mvnw clean package

FROM quay.io/rh_ee_dechou/openjdk-11-runtime:1.14-5
COPY --from=build /app/build/target/*.jar /app/todolist.jar
CMD ["java", "-jar", "/app/todolist.jar"]