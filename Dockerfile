FROM openjdk

COPY build/libs/usuario-0.0.1-SNAPSHOT.jar example.jar
#ENTRYPOINT SIRVE PARA EJECUTAR UN ARCHIVO
#CMD SIRVE PARA EJECUTAR UN COMANDO
CMD sleep 15 && java -jar example.jar
#ENTRYPOINT  ["java", "-jar", "/example.jar"]