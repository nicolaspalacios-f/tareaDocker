FROM openjdk:8

WORKDIR /labDocker/LogService/bin


COPY /target/classes /labDocker/LogService/bin/classes
COPY /target/dependency /labDocker/LogService/bin/dependency

CMD ["java","-cp","./classes:target/dependency/*","edu.escuelaing.arep.app.App"]