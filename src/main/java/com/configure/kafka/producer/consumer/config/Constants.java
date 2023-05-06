package com.configure.kafka.producer.consumer.config;

public interface Constants {
    public static final String TOPIC_NAME="OrderTopic";

    public final String GROUP_ID_CONFIG="myGroup";

   // public final String BOOTSTRAP_NAME="localhost:9092";

    // connect tp kafka docker container from external Application within same cluster
    // create bitnami kafka external client listener by KAFKA_CFG_ADVERTISED_LISTENERS
    // KAFKA_CFG_ADVERTISED_LISTENERS=.....EXTERNAL_CLUSTER://192.168.1.144:9095
    // you can use your <external IP such as AWS EC2 elastic IP or your class C IP (192.168.x.x) or localhost IP 127.0.0.1:9095
    public final String BOOTSTRAP_NAME="192.168.1.144:9095";
}
