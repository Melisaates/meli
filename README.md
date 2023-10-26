# Student Management System - Backend

This project is a Java Spring Boot application for managing students. It stores, updates, and retrieves student information using RESTful APIs.

## Getting Started

To run this application on your local machine, follow these steps:

1. Resolve the required dependencies using the `pom.xml` file in the project directory.

2. Configure the database connection in the `application.properties` file.

3. Start the application by running the `StudentManagementApplication.java` class.

To confirm that the application is running, visit `http://localhost:8080` in your browser.

## API Endpoints

This application provides the following API endpoints:

- Create a student: POST `/api/students`
- Retrieve all students: GET `/api/students`
- Retrieve a specific student: GET `/api/students/{id}`
- Update a student: PUT `/api/students/{id}`
- Delete a student: DELETE `/api/students/{id}`

## License

This project is licensed under the MIT License. For more information, review the `LICENSE` file.

