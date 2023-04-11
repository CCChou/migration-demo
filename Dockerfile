FROM quay.io/rh_ee_dechou/openjdk-11:1.14-5 as build
USER 1001
WORKDIR /home/jboss/build
COPY . /home/jboss/build/.
RUN mvn clean package

FROM quay.io/rh_ee_dechou/openjdk-11-runtime:1.14-5
COPY --from=build /home/jboss/build/target/*.jar /home/jboss/todolist.jar
CMD ["java", "-jar", "/home/jboss/todolist.jar"]