# Spring Boot JWT Microservice

Simple microservice with JWT authentication.

## Features
- `POST /api/auth/login` issues a JWT token.
- `GET /api/hello` is protected and requires `Authorization: Bearer <token>`.
- In-memory demo user for quick testing:
  - username: `demo`
  - password: `demo123`

## Prerequisites
- Java 17+
- Maven 3.9+

## Build
```bash
cd springboot-jwt-service
mvn clean package
```

## Run
```bash
cd springboot-jwt-service
mvn spring-boot:run
```

Service runs on `http://localhost:8080`.

## Test
```bash
cd springboot-jwt-service
mvn test
```

## API Test (curl)

### 1) Login and get token
```bash
curl -s -X POST http://localhost:8080/api/auth/login \
  -H 'Content-Type: application/json' \
  -d '{"username":"demo","password":"demo123"}'
```

Example response:
```json
{"token":"<JWT_TOKEN>"}
```

### 2) Access protected endpoint with token
```bash
curl -s http://localhost:8080/api/hello \
  -H "Authorization: Bearer <JWT_TOKEN>"
```

Expected response:
```json
{"message":"Hello from JWT protected microservice"}
```

### 3) Verify unauthorized access without token
```bash
curl -i http://localhost:8080/api/hello
```
Expected: `401` or `403` depending on security entrypoint behavior.

## Notes
- This service is intentionally simple for learning and testing.
- Move the JWT secret to external configuration before production use.
- Replace in-memory users with database/identity-provider integration in real deployments.
