 
# Spring boot from outside access Kafka docker container

# Overview
 The applications which publish or subscribe message outside from kafka container can be normal because regular application service could be running 
 in different servers from Kafka cluster brokers or individual kafka broker. Therefore it makes sense that an application accesses kafka bootstrap server
 from kafka container outside. 
 
 This project make the spring boot directly accesses kafka by PLAIN_TEXT and by TLS connection by Java keystore(jks)
 
 In order to make Kafka image of container is smaller or simple, I choose bitnami kafka and zookeeper image. 
 
 # kafka plain text docker compose
   Samilar to environment confluent kafka parameters, bitnami image has different parts which add 'CFG' for Kafka environment variable
   Here are key env properties, first of all we can select our external and internal key words 
   
   KAFKA_LISTENER_SECURITY_PROTOCOL_MAP 
   we can select our external and internal key words such as EXTERNAL_LOCAL, EXTERNAL_CLUSTER, we map them as PLAINTEXT or SSL or TLS etc
                                  
   KAFKA_CFG_LISTENERS
   Bootstrap Server use it make internal socket opens to which IP arrage, ususally we open all comming IPs by 0.0.0.0:port_number, here port number
   is that you assign to internal or external of docker container access. 
   
   KAFKA_CFG_ADVERTISED_LISTENERS
   This is KAFKA client listener
   PLAINTEXT://kafka-services:9092 means internal connection, for example, if you have spring-boot application image and kafka image located in same 
   docker container platform,the application should use kafka-services:9092 as its bootstrap server 
   
   EXTERNAL_LOCAL://127.0.0.1:9094 means your application does not running in docker container and kafka running in docker container but both are in
   same node, the application can use 127.0.0.1:9094 as its bootstrap server
   
   EXTERNAL_CLUSTER://192.168.1.144:9095, here 192.168.1.144 is my family internal class C IP address, I take it as an example, it could be your any
   kafka node external IP address or DNS address. such as you can use your AWS elastic IP replace it, provide your IP where your kafka docker container 
   running in. Here is this important that this project implements spring boot application use kafka from other machine or other container such as 
   kubernate to access kafka docker container
  
      version: '3.8'
      services:
        zookeeper-services:
          image: docker.io/bitnami/zookeeper:3.8
          container_name: zookeeper-container
          restart: unless-stopped
          ports:
            - "2181:2181"
          volumes:
            - "zookeeper_data:/bitnami"
          environment:
            - ALLOW_ANONYMOUS_LOGIN=yes
            - ZOOKEEPER_CLIENT_PORT=2181
            - ZOOKEEPER_TICK_TIME=2000
          networks:
            - kafka-app-net
        kafka-services:
          image: docker.io/bitnami/kafka:3.4
          container_name: kafka-container
          restart: unless-stopped
          ports:
            - "9092:9092"
            - "9094:9094"
            - "9095:9095"
          volumes:
            - "kafka_data:/bitnami"
          environment:
            - ALLOW_PLAINTEXT_LISTENER=yes
            - KAFKA_CFG_AUTO_CREATE_TOPICS_ENABLE=true
            - KAFKA_ENABLE_KRAFT=no
            - KAFKA_ZOOKEEPER_CONNECT=zookeeper-services:2181
            - KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT,EXTERNAL_LOCAL:PLAINTEXT,EXTERNAL_CLUSTER:PLAINTEXT
            - KAFKA_CFG_LISTENERS=INTER://0.0.0.0:9092,EXTERNAL_LOCAL://0.0.0.0:9094,EXTERNAL_CLUSTER://0.0.0.0:9095
            - KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://kafka-services:9092,EXTERNAL_LOCAL://127.0.0.1:9094,EXTERNAL_CLUSTER://192.168.1.144:9095
            - KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1
            - KAFKA_TRANSACTION_STATE_LOG_MIN_ISR=1
            - KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR=1
          depends_on:
            - zookeeper-services
          networks:
            - kafka-app-net

      networks:
        kafka-app-net:
          driver: bridge

      volumes:
        zookeeper_data:
          driver: local
        kafka_data:
          driver: local
