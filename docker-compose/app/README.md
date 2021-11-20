# Setup monitoring on application side (CentOS 7)

#### Install Docker
yum install docker
#### Download Docker Image for cAdvisor
docker pull google/cadvisor:v0.33.0

#### Download Docker Image for nginx
docker pull nginx:1.20.1

#### Download NodeExporter
curl -LO "https://github.com/prometheus/node_exporter/releases/download/v1.2.2/node_exporter-1.2.2.linux-amd64.tar.gz"
