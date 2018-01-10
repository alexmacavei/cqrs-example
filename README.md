# cqrs-example

This project aims to implement a simple CQRS example using the [Axon Framework](https://github.com/AxonFramework/AxonFramework) and [Axon Cdi](https://github.com/holisticon/axon-cdi) and a lightweight container like Wildfly Swarm. 

# Usage

To use this, we need to first build the project:
```
mvn clean package
```
And after that, run the container-in-a-jar from the project root:
```
java -jar target/cqrs-example-swarm.jar
```
