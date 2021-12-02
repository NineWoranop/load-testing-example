# Install Node Exporter on CentOS 7

#### Copy from https://www.airwallet365.com/post/how-to-install-node-exporter-on-centos-7-linux-monitoring
####Paste the copied URL after wget in the following command:

```
wget https://github.com/prometheus/node_exporter/releases/download/v1.2.2/node_exporter-1.2.2.linux-amd64.tar.gz
chown root:root node_exporter-1.2.2.linux-amd64.tar.gz
```

#### Extract the downloaded package:
```
tar -xzvf node_exporter-1.2.2.linux-amd64.tar.gz
```

#### Create a user for the node exporter:
```
sudo useradd -rs /bin/false nodeusr
```

#### Move binary to “/usr/local/bin” from the extracted package:
```
 sudo mv ./node_exporter-1.2.2.linux-amd64/node_exporter /usr/local/bin/
sudo chown nodeusr:nodeusr /usr/local/bin/node_exporter
```

#### Create a system service fil for the node exporter:
```
sudo vim /etc/systemd/system/node_exporter.service
sudo mv ./node_exporter.service /etc/systemd/system/
```

#### Add the following content to the file:
```
[Unit]
Description=Node Exporter
After=network.target

[Service]
User=nodeusr
Group=nodeusr
Type=simple
ExecStart=/usr/local/bin/node_exporter

[Install]
WantedBy=multi-user.target
```

#### Save & exit file.
#### Reload the system daemon:
```
sudo systemctl daemon-reload
```

#### Enable boot-up system service auto-start after rebooting:
```
sudo systemctl enable node_exporter
sudo systemctl start node_exporter
```

#### Verify port 9100
```
curl http://localhost:9100
```

#### Check Firewall is running or not
```
sudo firewall-cmd --state
sudo systemctl status firewalld
```

#### Add a firewall rule to allow node exporter:
```
sudo firewall-cmd --zone=public --add-port=9100/tcp --permanent
```

#### Reload firewall service:
```
sudo systemctl restart firewalld
```

#### View the metrics browsing node explorer URL:
```
http://IP-Address:9100/metrics
```
