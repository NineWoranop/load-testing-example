FROM ninetom/openjdk8-debian11:8u302-b08-1
LABEL Vendor="Example" \
      maintainer="nineworanop@gmail.com"

# Refer to Maven build -> finalName
ARG JAR_FILE=app-spring-boot.jar

# cd /opt/app
WORKDIR /opt/app

# cp spring-boot.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8081

# java -jar /opt/app/app.jar
CMD ["-jar", "app.jar"]
ENTRYPOINT ["java"]