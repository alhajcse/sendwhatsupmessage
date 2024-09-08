FROM openjdk:17
EXPOSE 8080
ADD target/sendwhatsupmessage-0.0.1-SNAPSHOT-plain.jar sendwhatsupmessage-0.0.1-SNAPSHOT-plain.jar
ENTRYPOINT ["java","-jar","/sendwhatsupmessage-0.0.1-SNAPSHOT-plain.jar"]