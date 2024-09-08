FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/target/sendwhatsupmessage-0.0.1-SNAPSHOT-plain.jar /sendwhatsupmessage.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/sendwhatsupmessage.jar"]