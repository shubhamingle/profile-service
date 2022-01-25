# profile-service

This service is responsible for managing profiles (CRUD operations)

****** For my reference ******

After creating a new profile, the notification-service can called using two methods.

1. RestTemplate
2. Apache Kafka

profile-service runs on port 8080 and notification-service runs on port 8081.

1. RestTemplate:

a. Remove comments for RestTemplate in ProfileController.java file and comment Kafka part.
b. Run both projects.
c. While posting records for profile you will get an SQL error since the GenerationType is set to IDENTITY. To resolve that open MySQL CLI. Use jiodb. Execute the following command
ALTER TABLE notification CHANGE id id INT(5) AUTO_INCREMENT;
d. Now post a new profile, new notification will be generated. (Check db)


2. Apache Kafka

a. comment out the RestTemplate part and uncomment kafka part
b. Start Zookeeper, then kafka-server and create a new topic - NOTIFICATION_TOPIC
c. Start both the projects and create a new profile.
