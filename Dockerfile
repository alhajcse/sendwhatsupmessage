FROM openjdk:17
EXPOSE 8080
ADD target/whatsapp.jar whatsapp.jar
ENTRYPOINT ["java","-jar","/whatsapp.jar"]