# backendSample for a weeklyPlanner

### Project Structure

- FrontendSample // https://github.com/apokochito/frontendSample
- BackendSample // This repository
- SecuritySample // https://github.com/apokochito/securitySample
- ValidationJobSample // https://github.com/apokochito/validationJobSample

### Jenkins integration (only for development references)

Installation steps (by windows option)

- Download Jenkins from https://www.jenkins.io/download/#downloading-jenkins
- Run service as LocalSystem (not recommended)
- Configure port Number 9040 and open chrome using http://localhost:9040
- Set local system password
- Plugins nstallation process...
- Create admin user
- Instance configuration with (http://localhost:9040)

Note: Make sure that you have all necessary plugins, Maven, Git, and Java tools already configured in Jenkins.

Create pipeline

- From home page, select "New Item" and name it as Backend
- Select "Freestyle Project"
- Go to Settings and add the GitHub url for that project
- Configure GitHub and Heroku repositories/credentials as following...

	Github

	- Add repository URL
	- Add your account credentials
	- Add a brief description of those credentials
	- Leave ID field empty

	Heroku
	
	- Add git repository URL of your app from heroku portal
	- Add your account credentials (email), and run this following commands to get your respective password (use your git CLI)
	1. $heroku login
	2. $heroku auth:token

- Add a Build (Maven) as "package"
- Add another build to publish to Heroku "heroku master" (consider that if your build fails is going to be deployed no matter what)
- Run your build

### Getting Started

  Zookeper Server configuration (1st cmd)
  
  - Download Zookeper from [**Zookeper Releases**](https://downloads.apache.org/zookeeper/ "Heading link")
  - Rename zoo-Sample.cfg to zoo.cfg (apache-zookeper > conf)
  - Change dataDir property location inside zoo.cfg to an existing route or create one
  - Go to apache-zookeper > bin and execute `.\zkServer.cmd`
    - If it doesn't work properly, check if the ports in your configuration are in use already
    - Add admin.serverPort property inside zoo.cfg file if it is necessary (only when 8080 is in used).
  
  Kafka Server configuration (2nd cmd)
  
  - Download Kafka from [**Kafka Quickstart**](https://kafka.apache.org/quickstart "Heading link")
  - Change log.dirs property location inside server.properties to an existing route or create one (use this character "/" instead "\")
  - Go to kafka > bin > **windows folder** and execute `kafka-server-start.bat .\..\..\config\server.properties`
  
  Create a topic configuration (3rd cmd)
  
  - Create a topic using this following command, where 'test' is the name of your topic `kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test`
  
  Test your kafka configuration
  
  1. Review your topics using this following command, `kafka-topics.bat --list --zookeeper localhost:2181`
  2. Send a message using this following command, `kafka-console-producer.bat --broker-list localhost:9092 --topic test` type your message and end the process with CTRL + C
  3. Receive the message using this following command, `kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning` and finally you will see your message.

### Build Application

  Application configuration
  
  1. Create an Spring Application
  2. Add test starter and web spring dependencies to your POM file
  3. Define server port to an available port
  4. Create a basic rest-controller

  Kafka configuration
  
  1. Add spring-kafka dependency to your POM file
  2. Create and configure Sender and Receiver classes
  3. Modify your controller to send a message
  4. Add an application.yml file and configure the group-id, topic and auto-offset-reset
  
  Mongo DB configuration
  
  1. Add mongodb starter dependency to your POM file
  2. Add a spring.data.mongodb properties to call the mongo configuration
  
  Reference https://springframework.guru/configuring-spring-boot-for-mongo/

### Run Application
  1. Go to this endpoint http://localhost:3001/send?message=tryingToSendAMessage
  2. Review the logs in your application
