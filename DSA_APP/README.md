# DSA Spring Boot REST API

This project exposes DSA (Data Structures & Algorithms) solutions as RESTful APIs using Spring Boot. Each DSA topic is a package, and each problem is accessible via a dedicated endpoint.

## Features
- Modular structure: Each topic (arrays, strings, etc.) is a package.
- Each problem is a REST endpoint (POST /api/{topic}/{problem-name-short})
- JSON input/output for all endpoints
- OpenAPI/Swagger UI for easy testing

## Getting Started
1. Build the project with Maven:
   ```sh
   mvn clean install
   ```
2. Run the application:
   ```sh
   mvn spring-boot:run
   ```
3. Access Swagger UI at: `http://localhost:8080/swagger-ui.html`

## Project Structure
- `src/main/java/com/example/dsa/` — Main source code
- `.github/copilot-instructions.md` — Copilot custom instructions

## Contributing
Feel free to add new DSA problems or improve existing endpoints.
