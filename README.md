# What Does Microservices Mean?

A microservice is a modular software component that does one defined job. Microservices, which have become the default architecture for software development, can run as a process on an application server, virtual machines (VM) or container.

Each microservice is a mini-application that has its own business logic and adapters for carrying out functions such as database access and messaging. The resulting application will have small, loosely-coupled components that communicate with each other using lightweight communication protocols. Microservices typically communicate with each other using Application Programming Interfaces (APIs).

![alt text](https://user-images.githubusercontent.com/56096031/139155851-ad576cbd-8e74-4c45-9f28-50757bf28ce7.PNG)
# Micro services approach
- Microservices are an approach to the architecture and development of an
development of an application composed of small services.
- The idea is to break down a large problem into small units
  implemented in the form of micro-services
- Each service is responsible for one functionality,
- Each microservice is developed, tested and deployed
  separately from the others.
- Each microservice is developed using a technology that may be different from the others.
  (Java, C++, C#, PHP, NodeJS, Pyton,
  ...)
- Each service runs in a separate process.
- Using lightweight communication mechanisms (REST)
- The only relationship between the different microservices is the exchange of data
  data exchange through the different APIs they expose (
  SOAP, REST, RMI, CORBA, JMS, MQP, ...)
- When combined, these microservices can perform very complex
  complex operations.
- They are loosely coupled since
  each micro service is physically separated from
  separated from the others,
- Relative independence between the different
  teams that develop the different micro
  micro services.
- Ease of testing and deployment
- Continuous delivery.
- Well suited to the LGA process: TDD
  (Test Driver Development) and
  agile methods

## Application
We Created an application based on two business services:
  - Customer Service
  - Inventory service
  - Billing Service
  - External Services: RapidAPI.

The orchestration of the services is done through the
  services of Spring Cloud :
  - Spring Cloud Gateway Service as proxy service
  - Registry Eureka Service as a directory for registration and discovery of
  discovery of the services of the services of the architecture
  - Hystrix Circuit Breaker - Hystrix DashBoard

![alt text](https://user-images.githubusercontent.com/56096031/139157359-27b4acdd-9914-469c-bad1-7da06ee099ea.PNG)
### Customer Service
we have created a spring project customer-service.
dependencies:
- Spring Web 
- Spring Data JPA
- H2 Database 
- Rest Repositories 
- Lombok 
- Spring Boot DevTools
- Eureka Discovery Client
- Spring Boot Actuator
##### class Customer
```java
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Customer {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
}
```
#### interface CustomerRepository
```java
@RepositoryRestResource
@CrossOrigin("http://localhost:4200") // or @CrossOrigin("*")
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
```
#### class CustomerServiceApplication
```java
@SpringBootApplication
public class CustomerServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerServiceApplication.class, args);
  }
  @Bean
  CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
    restConfiguration.exposeIdsFor(Customer.class);
    return args -> {
      customerRepository.save(new Customer(null,"Enset","contact@enset-media.ma"));
      customerRepository.save(new Customer(null,"FSTM","contact@fstm.ma"));
      customerRepository.save(new Customer(null,"ENSAM","contact@ensam.ma"));
      customerRepository.findAll().forEach(System.out::println);
    };
  }
}
```

