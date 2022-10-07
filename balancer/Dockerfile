FROM openjdk:8

WORKDIR /labDocker/balancer/bin


COPY /target/classes /labDocker/balancer/bin/classes

COPY /target/dependency /labDocker/balancer/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arep.Balancer"]
