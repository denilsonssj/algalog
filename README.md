# Algalog

## Installation

Clone the repository
``` 
$ git clone https://github.com/denilsonssj/algalog
```
## Getting started

### Prerequisites

First, make sure you use JDK version 11 or higher. You can download this version at this [link](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html).

After, create file application.yml in location *src/main/resources/* and copy with the values below and replace him.

```yml
spring:
    datasource:
        url: "jdbc:postgresql://127.0.0.1:5432/algalog"
        username: "postgres"
        password: "postgres"
    jpa:
        database-platform: org.hibernate.dialect.PostgreSQL94Dialect
        show-sql: false
        hibernate:
            ddl-auto: update
server:
    port: 8080
```
### Installing dependencies

Now, install all dependencies using maven: 
``` 
$ ./mvnw install -U clean
```
### Running the application

```
./mvnw spring-boot:run
``` 
$ ./m

## Technologies and tools

- [Java](https://www.java.com/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [JDK11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Flyway](https://flywaydb.org)
- [Lombok](https://projectlombok.org/)
- [Swagger](https://swagger.io/)
- [PostgreSQL](https://www.postgresql.org/)
## Demo

The demo project can be viewed [here](https://denilsonssj-algalog.herokuapp.com/).

## License

[MIT](https://github.com/denilsonssj/algalog/blob/main/LICENSE)
