#### Export Docker Image
docker save -o app-spring.tar ninetom/spring-boot2-examples-backend
docker save -o cadvisor.tar google/cadvisor:v0.33.0
docker save -o nginx.tar nginx:1.21.4-perl


#### Import Docker Image
docker load --input app-spring.tar
docker load --input cadvisor.tar
docker load --input nginx.tar