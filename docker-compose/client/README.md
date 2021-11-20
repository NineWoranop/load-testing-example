# Setup monitoring on client/monitoring side (CentOS 7)

#### Install Docker
yum install docker
#### Download Docker-Compose
sudo curl -L "https://github.com/docker/compose/releases/download/1.23.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
#### Grant permission to Docker-Compose
sudo chmod +x /usr/local/bin/docker-compose
#### Download Docker Image for Prometheus
docker pull prom/prometheus:v2.31.0
#### Download Docker Image for AlertManager
docker pull prom/alertmanager:v0.23.0
#### Download Docker Image for Grafana
docker pull grafana/grafana:8.2.2

#### Start dockers
docker-compose up

#### Access Prometheus
http://localhost:9090/
#### Access AlertManager
http://localhost:9093/
#### Access Grarana
http://localhost:3000/  --> admin / foobar
