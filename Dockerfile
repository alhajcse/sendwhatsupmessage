FROM openjdk:17
WORKDIR /app
COPY --from=build /app/build/libs/*.jar sendwhatsupmessage.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/sendwhatsupmessage.jar"]
