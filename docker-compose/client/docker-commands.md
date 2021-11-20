#### Export Docker Image
docker save -o client-jmeter.tar ninetom/jmeter5:5.4.1
docker save -o cadvisor.tar google/cadvisor:v0.33.0
docker save -o prometheus.tar prom/prometheus:v2.31.0
docker save -o alertmanager.tar prom/alertmanager:v0.23.0
docker save -o nginx.tar nginx:1.21.4-perl
docker save -o grafana.tar grafana/grafana:8.2.2
docker save -o nginx.tar nginx:1.21.4-perl

#### Import Docker Image
docker load --input client-jmeter.tar
docker load --input cadvisor.tar
docker load --input prometheus.tar
docker load --input alertmanager.tar
docker load --input grafana.tar
docker load --input nginx.tar