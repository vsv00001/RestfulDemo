FROM maven:3.6.1-jdk-8 as compile
COPY . /home/source/java
WORKDIR /home/source/java
RUN mvn clean install -U

FROM hub.comcast.net/traxion/phoenix-docker-common:1.0
#FROM phoe-common-mach:latest

WORKDIR /home/application/java
COPY --from=compile "/home/source/java/target/RestfulDemo-0.0.1-SNAPSHOT.jar" RestfulDemo.jar

EXPOSE 8090
ENTRYPOINT exec java -javaagent:/opt/appdynamics/javaagent.jar -jar -Dappdynamics.agent.reuse.nodeName.prefix=rest-ser -Dappdynamics.agent.reuse.nodeName=true RestfulDemo.jar -Xmx2048m -Xms1024m