# spring-boot-docker-boilerplate

# To pull latest mysql image 
```
docker pull mysql
```
# To create network for spring boot application to communicate 
```
docker network create springboot-mysql-net
```

# To run the mysql docker image 
```
docker run --name mysqldb --network springboot-mysql-net
```
# To access the DB container
```
docker exec -it mysqldb bash
```
# To run Spring boot jar

```
mvn clean package

docker build -t springboot-restful-webservices .

docker run --network springboot-mysql-net --name springboot-mysql-container -p 8888:8888 springboot-restful-webservices
```
