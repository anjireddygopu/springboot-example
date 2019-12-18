FROM openjdk:8
ADD target/springcrud.jar springcrud.jar
EXPOSE 9080
ENTRYPOINT ["java","-jar","springcrud.jar"]