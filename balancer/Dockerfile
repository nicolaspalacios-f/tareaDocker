FROM openjdk:8

WORKDIR /tareaDocker/balancer/bin


COPY /target/classes /tareaDocker/balancer/bin/target/classes

COPY /target/dependency /tareaDocker/balancer/bin/target/dependency

CMD ["java","-cp","target/classes:target/dependency/*","edu.escuelaing.arep.Balancer"]
