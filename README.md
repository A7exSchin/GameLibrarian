# REST API and SPA Example Project

> This repository contains the solutions for exercise 2: A web application based on a RESTful API with Spring Boot (`api/`). The single page application with Vue.js (`frontend/`) can now be used, after starting the development server.
> Please refer to the `README.md` files in the respective folders for concrete instructions. Especially regarding the EMail setup for the API!

## Quickstart
>:warning: **The email service is deactivated by default to prevent a flood of emails outbound and inbound on your account!** To activate the email service change the `email.isUsed` property to `true` found in `api/src/main/resources/application.properties`.

Assuming all prerequisites are fulfilled, you can follow these instructions to get to know the application:
- First please configure the email properties in `./api/src/main/resources/application.properties`.
- Start the API by navigating into its folder and executing `./mvnw spring-boot:run`.
- Start the frontend by navigating into its folder and executing `./mvnw spring-boot:run`.
- Open `http://localhost:8000` to acces the Vuejs frontend
- API calls need to be directed at `http://localhost:8080/api/v1`
- The swagger UI is reachable at `http://localhost:8080/api/v1/swagger-ui`
