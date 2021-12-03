#!/bin/sh
echo "start java background"

## Used nohup to make sure to run java on new process from terminal.
### ">/dev/null 2>&1" used for prevent nohup.out from console out on java application

nohup /appl/java/jdk1.8.0_181/bin/java \
 -Dserver.port=9095 \
 -Dserver.tomcat.max-connections=5000 \
 -Dserver.tomcat.min-spare-threads=50 \
 -Dserver.tomcat.max-threads=60 \
 -Dspring.datasource.hikari.minimum-idle=50 \
 -Dspring.datasource.hikari.maximum-pool-size=60 \
 -Dmanagement.endpoint.metrics.enabled=true \
 -Dmanagement.endpoint.prometheus.enabled=true \
 -Dmanagement.endpoints.web.exposure.include=* \
 -Dserver.tomcat.mbeanregistry.enabled=true \
 -Dspring.datasource.url=jdbc:mysql://10.187.1.56:3306/example_db \
 -Dspring.datasource.username=example_user \
 -Dspring.datasource.password=example \
 -Dspring.datasource.driverClassName=com.mysql.jdbc.Driver \
 -Dspring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect \
 -Xms580m \
 -Xmx580m \
 -jar /appl/docker-compose/app.jar \
 >/dev/null 2>&1 \
 & # run as background