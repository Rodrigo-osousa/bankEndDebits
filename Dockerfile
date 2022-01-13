FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/bankenddebits.jar bankenddebits.jar
ENTRYPOINT ["java","-jar","/bankenddebits.jar"]