# Notes for jmx files (Test Suites)

# load-test-0_2tps.jmx
## This is the example for make sure that your setup have been working well and you should see the throughput to be 2 requests per second. If the number is less than 2, your servers/machines might be too slow for load testing.

# load-test-1_loadbalancer.jmx
## This is the example for test on findAll api by configure for public network vi port 80 (nginx) as load balancer
HOST_IP_ADDRESS		10.187.1.52
HOST_PORT			80
PREFIX_PATH			/spring

# load-test_appspring1.jmx
## This is the example for test on findAll api by configure from internal network vi post 9095 on instance 1 directly
HOST_IP_ADDRESS		10.187.1.52
HOST_PORT			9095
PREFIX_PATH			
