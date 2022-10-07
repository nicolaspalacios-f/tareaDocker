FROM openjdk:8

WORKDIR /labDocker/LogService/bin


COPY /target/classes /labDocker/LogService/

COPY /target/dependency /labDocker/LogService/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arep.app.App"]