#### Export Docker Image
docker save -o app-spring.tar ninetom/spring-boot2-examples-backend
docker save -o cadvisor.tar google/cadvisor:v0.33.0
docker save -o nginx.tar nginx:1.21.4-perl
docker save -o mysql.tar mysql:5.7
docker save -o adminer.tar adminer:4

#### Import Docker Image
docker load --input app-spring.tar
docker load --input cadvisor.tar
docker load --input nginx.tar
docker load --input mysql.tar
docker load --input adminer.tar

sudo systemctl stop docker.socket
sudo systemctl stop docker
sudo systemctl start docker.socket
sudo systemctl start docker
sudo systemctl daemon-reload
sudo systemctl restart docker
