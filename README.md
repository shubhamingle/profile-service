# profile-service

This service is responsible for managing profiles (CRUD operations)

****** For my reference ******

Import profile-service and notification-service into STS

After creating a new profile, the notification-service can be called using two methods.

1. RestTemplate
2. Apache Kafka

profile-service runs on port 8080 and notification-service runs on port 8081.

1. RestTemplate:

a. Remove comments for RestTemplate in ProfileController.java file and comment Kafka part. <br/>
b. Run both projects.<br/>
c. While posting records for profile you will get an SQL error since the GenerationType is set to IDENTITY. To resolve that open MySQL CLI. Use jiodb. Execute the following command<br/>
ALTER TABLE notification CHANGE id id INT(5) AUTO_INCREMENT;<br/>
d. Now post a new profile, new notification will be generated. (Check db)<br/>


2. Apache Kafka

a. comment out the RestTemplate part and uncomment kafka part<br/>
b. Start Zookeeper, then kafka-server and create a new topic - NOTIFICATION_TOPIC<br/>
c. Start both the projects and create a new profile.<br/>
