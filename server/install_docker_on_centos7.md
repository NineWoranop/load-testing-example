# Install Docker on CentOS 7

#### Copy from https://www.programmerall.com/article/140222171/
#### Uninstall old version
yum remove docker-ce-rootless-extras docker-ce docker-selinux docker-scan-plugin docker-ce-cli containerd.io

#### Copy the uploaded docker-ce.repo file to the /etc/yum.repos.d/ directory.
cp /tools/docker/docker-ce.repo /etc/yum.repos.d/

#### Install containerd.io, docker-ce-cli, container-selinux, docker-ce packages in order.
yum update -y
yum install -y policycoreutils-python 
yum install -y fuse-overlayfs
yum install -y slirp4netns
rpm -ivh container-selinux-2.107-3.el7.noarch.rpm
rpm -ivh containerd.io-1.4.11-3.1.el7.x86_64.rpm
rpm -ivh docker-scan-plugin-0.9.0-3.el7.x86_64.rpm docker-ce-cli-20.10.10-3.el7.x86_64.rpm
rpm -ivh docker-ce-rootless-extras-20.10.10-3.el7.x86_64.rpm docker-ce-20.10.10-3.el7.x86_64.rpm

#### Start docker, set to start automatically
systemctl start docker
systemctl enable docker

#### View docker version
docker version

#### install docker-compose
#### Copy the docker-compose file to the /user/local/bin/ directory
cp /somewhere_that_you_upload/docker-compose  /usr/local/bin/
mv ./docker-compose /usr/local/bin/
 
#### Install docker-compose
chmod +x /usr/local/bin/docker-compose
 
#### View docker-compose version
docker-compose --version
