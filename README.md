### To pull latest mysql image 
```
docker pull mysql
```
### To create network for spring boot application to communicate 
```
docker network create springboot-mysql-net
```

### To run the mysql docker image 
```
docker run --name mysqldb --network springboot-mysql-net -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=employeedb -d mysql
```
### To access the DB container
```
docker exec -it mysqldb bash
```
### To run Spring boot jar

```
mvn clean package

docker build -t springboot-restful-webservices .

docker run --network springboot-mysql-net --name springboot-mysql-container -p 8080:8080 springboot-restful-webservices
```

### Access API endpoints

```
localhost:8080/api/employees
```

![image](https://github.com/DIVYA-19/spring-boot-docker-boilerplate/assets/41481377/53e0d7d0-3457-4052-9425-fe0a515d310a)


![image](https://github.com/DIVYA-19/spring-boot-docker-boilerplate/assets/41481377/abfa7e94-b569-4cae-9c04-2a72ff979dc4)
