FROM ninetom/openjdk8-debian11:8u302-b08-1
LABEL Vendor="JMeter5.4" \
      maintainer="nineworanop@gmail.com"

RUN cd /home; \
    curl -O https://dlcdn.apache.org//jmeter/binaries/apache-jmeter-5.4.1.tgz; \
	tar -xvzf apache-jmeter-5.4.1.tgz; \
    rm -rf *.tgz; \
	mv apache-jmeter-5.4.1 jmeter; \
	cd /home/jmeter/bin; \
    printf '\n' | ./create-rmi-keystore.sh -dname 'CN=jmeter';
#    cp rmi_keystore.jks /home/jmeter/bin/;

COPY jmeter-prometheus-plugin-0.6.0.jar /home/jmeter/lib/ext/jmeter-prometheus-plugin-0.6.0.jar

WORKDIR /home/jmeter/bin

EXPOSE 1099

# -s, --server
#                run the JMeter server
# -n, --nongui
#                run JMeter in nongui mode
# -J, --jmeterproperty {argument}={value}
#                Define additional JMeter properties
CMD ["-s", \
     "-n", \
	 "-Jserver.rmi.port=1099", \
	 "-Jserver.rmi.ssl.disable=true" \
]

ENTRYPOINT ["/home/jmeter/bin/jmeter"]