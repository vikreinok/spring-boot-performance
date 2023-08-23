###

A project to demonstrate different types of dependency injection concepts to improve the design of a Spring Boot application.
Also, it compares the performance of different types of dependency injection.

1. Simple Dependency Injection with factory
2. Local BeanFactory implementation
3. AOP approach (AspectJ)
4. Making beans scope prototype
5. Do we get performance benefits from lightweight threads

## How to run

`mvn spring-boot:run` to start the webapp - see the amazing feature at http://localhost:8080/

`mvn gatling:test` while the webapp is running to run the performance test

If AOP does not work, rebuild the project
