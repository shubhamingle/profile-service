# profile-service

This service is responsible for managing profiles (CRUD operations). Also, a message will be sent to the notification-service from profile-service after creating a new profile. 

notification-service can be called using two methods.<br/><br/>

1. RestTemplate:<br/><br/>
![profile-service-resttemplate-flow](https://user-images.githubusercontent.com/37982804/151371457-3f04d393-f54c-4357-a900-f3b419b04150.jpg)
<br/>
a. Uncomment RestTemplate in POST method in ProfileController.java file and comment the Kafka part <br/><br/>
b. Run both projects (profile-service runs on port 8080 and notification-service runs on port 8081) <br/><br/>
c. Perform CRUD operations using Postman <br/><br/>
d. Example:<br/>
i. Get all profiles - GET http://localhost:8080/api/profiles<br/><br/>
ii. Get profile by id - GET http://localhost:8080/api/profiles/1<br/><br/>
iii. Create a profile - POST http://localhost:8080/api/profiles along with Request body<br/><br/>
iv. Update a profile - PUT http://localhost:8080/api/profiles/1 along with Request body<br/><br/>
v. Delete a profile - DELETE http://localhost:8080/api/profiles/1<br/><br/>

2. Apache Kafka<br/><br/>
a. Comment out the RestTemplate part and uncomment kafka part<br/><br/>
b. Start Zookeeper using below command<br/>
zookeeper-server-start.bat ../../config/zookeeper.properties<br/><br/>
c. Start Kafka server<br/>
kafka-server-start.bat ../../config/server.properties<br/><br/>
d. Create a topic - NOTIFICATION_TOPIC<br/>
kafka-topics.bat --zookeeper localhost:2181 --create --topic TOPIC_NAME --partitions 1 --replication-factor 1<br/><br/>
e. Start both projects and perform CRUD operations using Postman
