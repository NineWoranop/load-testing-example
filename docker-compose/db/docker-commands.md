#### Export Docker Image
docker save -o cadvisor.tar google/cadvisor:v0.33.0
docker save -o mysql.tar mysql:5.7
docker save -o adminer.tar adminer:4

#### Import Docker Image
docker load --input cadvisor.tar
docker load --input mysql.tar
docker load --input adminer.tar

sudo systemctl stop docker.socket
sudo systemctl stop docker
sudo systemctl start docker.socket
sudo systemctl start docker
sudo systemctl daemon-reload
sudo systemctl restart docker
