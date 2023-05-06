 
# Spring boot access Kafka Bootstrap Server from outside of kafka docker container

# Overview
 The applications which publish or subscribe message outside from kafka container can be normal because regular application service could be running 
 in different servers from Kafka cluster brokers or individual kafka broker. Therefore it makes sense that an application accesses kafka bootstrap server
 from kafka container outside. 
 
 This project make the spring boot directly accesses kafka by PLAIN_TEXT and by TLS connection by Java keystore(jks)
 
 In order to make Kafka image of container is smaller or simple, I choose bitnami kafka and zookeeper image. 
