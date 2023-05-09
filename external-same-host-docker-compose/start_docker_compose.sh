#docker image rm -f bitnami/kafka:3.4
#docker image rm -f bitnami/zookeeper:3.8
#docker image rm -f confluentinc/cp-zookeeper:7.0.1
#docker image rm -f wurstmeister/zookeeper:latest
#docker image rm -f confluentinc/cp-zookeeper 
docker compose build --no-cache
docker compose down --remove-orphans
docker compose up --remove-orphans



