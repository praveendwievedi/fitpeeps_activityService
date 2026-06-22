# Activity Service

The Activity Service is a core microservice of the **FitPeeps** fitness tracking platform. It is responsible for managing user activities such as workouts, exercises, running sessions, cycling sessions, and other fitness-related records.

## Features

* Create new activities
* Retrieve activity details
* Update existing activities
* Delete activities
* Fetch activities for a specific user
* Store activity duration and timestamps
* Persist activity data in PostgreSQL
* Expose REST APIs for inter-service communication

## Technology Stack

* Java 25
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* REST APIs

## Service Responsibilities

The Activity Service handles:

* Activity creation and management
* Activity history tracking
* Activity validation
* Persistence of activity records
* Communication with other FitPeeps services through REST APIs

## Project Structure

```text
src
├── main
│   ├── java
│   │   ├── controllers
│   │   ├── service
│   │   ├── repos
│   │   ├── models
│   │   ├── dtos
│   │   └── utils
│   └── resources
│       └── application.properties
└── test
```

## Database Schema

### Activity

| Field          | Type          | Description               |
| -------------- | ------------- | ------------------------- |
| activityId             | Long          | Activity Identifier       |
| userId         | Long          | User Identifier           |
| activityType   | String        | Type of Activity          |
| startTime      | LocalDateTime | Activity Start Time       |
| endTime        | LocalDateTime | Activity End Time         |
| duration       | Integer       | Duration in Minutes       |
| caloriesBurned | Double        | Estimated Calories Burned |

## API Endpoints

### Create Activity

```http
POST /api/activities
```

Request Body

```json
{
  "userId": 1,
  "activityType": "Running",
  "startTime": "2026-06-22T07:00:00",
  "endTime": "2026-06-22T08:00:00"
}
```

### Get Activity By Id

```http
GET /api/activities/{activityId}
```

### Get User Activities

```http
GET /api/activities/user/{userId}
```

### Update Activity

```http
PUT /api/activities/{activityId}
```

### Delete Activity

```http
DELETE /api/activities/{activityId}
```

## Configuration

Example `application.properties`

```properties
spring.application.name=activity-service

server.port=8083

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Running the Service

### Clone Repository

```bash
git clone <repository-url>
cd activity-service
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

The service will start on:

```text
http://localhost:8083
```

## Future Enhancements

* Activity categorization
* Activity analytics
* Weekly and monthly reports
* RabbitMQ event publishing
* AI-powered activity recommendations
* Activity goal tracking

## Part of FitPeeps

This service is one of the microservices that power the FitPeeps platform. It collaborates with User, and Recommendation services to provide a complete fitness tracking experience.
