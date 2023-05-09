#provide KAFKA EXTERNAL_IP_ADDRESS to "$1" such as your family router IP 192.168.1.144
#make sure your .bashrc or .bath_profile point KAFKA_HOME to your local kafka installation directory
 
$KAFKA_HOME/bin/kafka-topics.sh --create --bootstrap-server "$1" --replication-factor 1 --partitions 1 --topic order_topic_topic
$KAFKA_HOME/bin/kafka-topics.sh --list --bootstrap-server "$1"
