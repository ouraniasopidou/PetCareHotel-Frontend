# Pet Hotel Frontend

## Overview
This is the frontend for the **Pet Care Hotel Application**, built using **Thymeleaf** with **Server-Side Rendering (SSR)**.

## Technologies Used
- **Thymeleaf**
- **Spring Boot**
- **Apache Tomcat**

## Running the Frontend
```bash
git clone https://github.com/yourusername/frontend-repo
cd frontend-repo
mvn spring-boot:run

The frontend will run at http://localhost:8080

Connecting to Backend
Make sure the backend is running at http://localhost:8081
If needed, update the backend URL in the application.properties file.

Database Connection
The frontend does not interact directly with the database, but it connects to the backend API.
The backend manages the database connection and authentication.

