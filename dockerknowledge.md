#Docker:
* Application Delivery technology
	* **Build** an application with a Docker Image
	* **Ship** an application with Docker Hub
	* **Run** an application as a Docker container
	
* WORA = Write Once, Run Anywhere  (e.g. Java)
* PODA = Package Once, Deploy Anywhere (e.g. Docker)

## Docker Toolbox
* It contains following components
	* Docker Engine
	* Docker Machine (this provides CLI interface)
	* Docker Compose
	* DOcker Kitematic (simple UI)
	* VirtualBox
	* Quick Start Terminal
	
### Docker Machine
	* Create a Docker Host on a computer or cloud provider
		```
		docker-machine create --driver=virtualbox myhost
		or
		docker-machine create -d virtualbox myhost
		
		here, driver can be aws, gce, azure based on the platform
		```
		
	* Configure client (or docker cli) to talk to docker host (machine)
		```
				docker-machine env myhost
				eval $(docker-machine env myhost)
				
			(on windows, to get docker env variables) 
			env | grep DOCKER
		```
		
## Docker commands
	```
		docker info (to get all about docker details on your host)
		
		docker version (to get docker client and server version details)
		
		docker --help
		
		docker image --help
		
		docker container run --help
		
		docker container stop <container id or container name>
		
		##To show all containers
		docker container ls -a 
		
		##To remove container
		docker container rm <container id or container name>

		##To assign a name. docker adds a name to each container by default if don't assign a name.
		docker container run --name firstContainer hello-world
		
		Note: To run in detach mode use, -d. For interactive mode, use -it in docker container run command
		
		##To stop and remove a running container
		docker container rm -f hello-world
		
		##To override the initial command, mention the command while running the container
		docker container run hello-world bash //In this case, we are overriding the initial command with bash
		
		##To run a container on a random port use option -P
		docker container run -d --name <container_name> -P <image>

		##To run a container on a specific port use option -p
		docker container run -d --name <container_name> -p <port on host>:<port on container> <image>

		e.g. docker container run -d --name web -p 8080:8080 jboss/wildfly

		##Use volume mapping for scenario like to deploy a war file on a web app
		docker container run -d --name web -p 8080:8080 -v `pwd`/something.war:/opt/jboss/wildfly/standalone/deployments/webapp jboss/wildfly

		This command will take the war file (something.war) from current working directory and place it in /opt/jboss/wildfly/standalone/deployments/webapp jboss/wildfly

	```


	## Building docker image
	```
		//Create a directory and then create a file named "Dockerfile" and add the following commands
		FROM ubuntu
		CMD echo "Hello World"

		//Run the below command to build the image
		docker image build -t myhelloworld .

		here, -t is for providing tag for the image.

		//Then you can run the container
		docker container run myhelloworld 

		//To get history of a image
		docker image history

		//You can create a file .dockerignore, same like .gitignore


	```

### CMD instruction
	* If we have multiple CMD instructions in a Dockerfile, only the last CMD instruction will effective.

### COPY Instruction
	* Copy new files or directories to the container filesystem


### ADD instruction
	* COPY instruction + Allows tar file auto-extraction in the image
	* Can download files from a remote URL

## How to package and run a jar file.

```
//Dockerfile
FROM openjdk:jdk-alpine

COPY myapp/target/myapp-1.0-SNAPSHOT.jar /deployments/

CMD java -jar /deployments/myapp-1.0-SNAPSHOT.jar

```


### RUN instruction
* RUN instruction is used for installing software update or one time stepup activity

```
	RUN apt-get update && apt-get install -y git

	RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#007 silent
```


### CMD
* Default for executing container; can be overridden by CLI

### ENTRYPOINT instruction
* configures the container executable; can be overridden using --entrypoint from CLI
	Default value: /bin/sh -c
	ENTRYPOINT ["/entrypoint.sh"]


### EXPOSE instruction
* network ports on which container is listening
	E.g.: EXPOSE 9990

	Need to explicitly publish the host port using -P or -p while running the container.

### VOLUME instruction
* creates a mount point with specified name
	VOLUME /opt/couchbase/var
	docker container run ... -v ~/data:/opt/couchbase/var


### USER
* sets the user name or UID to use when running the image

### HEALTHCHECK
* performs a healthcheck on the application inside the container
```
HEALTHCHECK  --interval=5s --timeout=3s CMD curl --fail http://localhost:8091/pools || exit 1
```


### To remove all 
```
//images
docker image rm -f $(docker image ls -aq)

//containers
docker container rm -f $(docker container ls -aq) 

```

### To rename the docker tag
```
//This command will create a new tag helloworld:latest which will have the same image as helloworld:1
docker image tag helloworld:1 helloworld:latest

```

### To push a docker image to docker hub
```
//To push the image to docker hub, first login

docker login

//correct the namespace of the image
docker image tag helloworld:latest amitkashyap01/helloworld:latest

//Push
docker push amitkashyap01/helloworld:latest

```

### To push the docker image to local registry

```
docker continer run -d -p 5000:5000 --restart always --name registry registry:2.6.0


//correct the namespace of the image
docker image tag helloworld:latest localhost:5000/helloworld:latest

docker push localhost:5000/helloworld:latest
```

## Docker Compose

* Define and run multicontainer applications
* Configuration defined in one or more files
docker-compose.yml (default)
docker-compose.override.yml (default)
Multiple files specified using -f

* Single command to manage all services
* Great for dev, staging and CI

```
//Below is the content of a sample docker-compose.yml file
version: '3'
services:
	web:
		image: jboss/wildfly
		volumes:
			- ~/deployments: /opt/jboss/wildfly/standalone/deployments
		ports:
			- 8080:8080

//To bring up all the services and run them in detached mode. It will create network for all the services mentioned in yml file.
docker-compose up -d

//To bring down all the services
docker-compose down


```

* -p : Create multiple isolated environments on a host by having different context (directory)
docker-compose -p myapp up -d
* docker-compose.override.yml - It replaces or extends value

* Multiple files using -f
	Replace or extend the parent value
	E.g. docker-compose -f docker-compose.yml -f docker-compose.db.yml up -d

	Note: Here the order of yml files are important because whichever will come later that will override 

* Extending services: Use extends




##Swarm
* Optional feature
* Natively managing a cluster of Docker Engines called a swarm
* No single point of failures (SPOF)
* Self organizing and self healing
* 


##VOLUME:

```
docker create volume my_mongodb_volume


docker volume ls

docker container run --name mongo mongo -v my_mongodb_volume:/data/db


##to remove container along with volume mapping


```
