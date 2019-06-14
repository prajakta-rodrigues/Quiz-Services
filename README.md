# Quiz-Services

This repository contains implementation of RESTful web service using Spring boot framework with PostgreSQL database.

## Requirements:
- JDK 1.8
- PostgreSQL 11+
- PGAdmin 4
- Maven 3.6

## Steps for getting started:
1. Clone the repository
2. Run the startup.sql script present under resources in PGAdmin to create the database(can also modify spring.jpa.hibernate.ddl-auto property under application.properties from update to create).
3. Modify the application properties to point to your local postgreSQL database.
4. Run the following command to build the project:
mvn clean install
5. You can run the jar using the command: 
java -jar jar-file-name.jar
6. The application is now started at localhost:8080
