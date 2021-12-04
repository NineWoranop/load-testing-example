# Setup Docker Compose as Service on CentOS 7

## Requirements
- Installed Docker on CentOS 7
- Verify that your docker-compose.yml could run without any issues.

## Prepare service file for your service
### 1. Create service file under folder /etc/systemd/system
/etc/systemd/system/myapp.service
```
[Unit]
Description     =myapp
Requires        =docker.service
After           =docker.service network.target

[Service]
Type            =oneshot
RemainAfterExit =yes
User            =root
Group           =root
WorkingDirectory=/tmp/docker-compose/app
ExecStartPre    =/usr/local/bin/docker-compose down
ExecStart       =/usr/local/bin/docker-compose up -d
ExecStop        =/usr/local/bin/docker-compose down
TimeoutStartSec =0

[Install]
WantedBy        =multi-user.target
```

### 2.  Install service
#### Reload the system daemon:
```sudo systemctl daemon-reload```
#### Enable service
```sudo systemctl enable myapp.service```
#### Start systemd service now
```sudo systemctl start myapp.service```
