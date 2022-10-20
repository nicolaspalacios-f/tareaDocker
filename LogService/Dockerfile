FROM openjdk:8

WORKDIR /tareaDocker/LogService/bin


COPY /target/classes /tareaDocker/LogService/bin/target/classes

COPY /target/dependency /tareaDocker/LogService/bin/target/dependency

CMD ["java","-cp","target/classes:target/dependency/*","edu.escuelaing.arep.app.App"]