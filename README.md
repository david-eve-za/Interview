# Read Me First

The following was discovered as part of building this project:

For testing purposes, the `spring-boot-starter-test` dependency is included in the `pom.xml` file. This dependency is not recommended for production use. For more information, see the [Spring Boot documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-build-systems.html#using-boot-maven-with-the-cli).

## Running the application

To run the application, run the following command in a terminal from the project directory:

```shell
./mvnw spring-boot:run
```

## Building the application

To build the application, run the following command in a terminal from the project directory:

```shell
./mvnw clean package
```

## Running the tests

To run the tests, run the following command in a terminal from the project directory:

```shell
./mvnw clean test
```

## Running the application locally

To run the application locally, run the following command in a terminal from the project directory:

```shell
./mvnw spring-boot:run
```

## Running the application in a container

To run the application in a container, run the following command in a terminal from the project directory:

```shell
./mvnw spring-boot:build-image
docker run -p 8080:8080 spring-boot:0.0.1-SNAPSHOT
```

## Running the application in a container using Docker Compose

To run the application in a container using Docker Compose, run the following command in a terminal from the project directory:

```shell
docker-compose up
```

## Running the application in a container using Kubernetes

To run the application in a container using Kubernetes, run the following command in a terminal from the project directory:

```shell
./mvnw spring-boot:build-image
kubectl apply -f k8s
```

## Running the application in a container using Cloud Foundry

To run the application in a container using Cloud Foundry, run the following command in a terminal from the project directory:

```shell
./mvnw spring-boot:build-image
cf push
```

## Developing with Spring Boot DevTools

Spring Boot DevTools adds development-time features to your application. It includes a file watcher that detects changes to your application classes, static resources, templates, and configuration files. When a change is detected, DevTools triggers a restart, which picks up the changes.

For more information, see the [Spring Boot DevTools documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html).

## Developing with Spring Boot Actuator

Spring Boot Actuator adds production-ready features to your application. It includes health checks, metrics gathering, and externalized configuration.

For more information, see the [Spring Boot Actuator documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html).

## Developer

* Name: David Gonzalez

* Github: [@david-eve-za](https://github.com/david-eve-za)

* LinkedIn: [David Gonzalez](https://www.linkedin.com/in/david-gonzalez-aabb71a4/)
