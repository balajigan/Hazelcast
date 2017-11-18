
# Hazelcast
## Installing and starting Hazelcast server

git clone https://github.com/balajigan/Hazelcast.git

cd Hazelcast/HzServer

### create the executable jar

mvn package

### start the server in background. The server will be listening in port 5701. REST Api is also enabled

java -jar target/HzServer-1.0.0.jar &
