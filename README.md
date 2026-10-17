# Spring Security Secured Customer REST API

A Spring Boot REST API secured with Spring Security, where only users registered in the MySQL database can access protected customer data using HTTP Basic Authentication.

## Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

## Features

- Authentication using employee credentials stored in a MySQL database.
- Protects customer data from unauthorized access.
- Retrieves user details from the database using a custom `UserDetailsService`.
- Uses `DaoAuthenticationProvider` to authenticate users.
- Performs CRUD operations on customer data.
- Tests REST API endpoints using Postman.

## How It Works

1. A user sends a request to a protected customer API.
2. Spring Security checks the user's credentials.
3. The application retrieves the user details from the MySQL database.
4. If the credentials are valid, the user can access the protected customer data.
5. If the credentials are invalid, access is denied.

## Project Structure

```text
src/main/java/com/sp/www/
├── Beans/
│   ├── Customers.java
│   ├── Employees.java
│   └── MyEmployees.java
├── Configurations/
│   └── SecurityConfigurations.java
├── Controllers/
│   └── CustomersController.java
├── Repositories/
│   ├── CustomersRepo.java
│   └── EmployeesRepo.java
├── Services/
│   ├── CustomersService.java
│   └── EmployeeDetails.java
└── SpringSecurityProject1Application.java
```

## Database Setup

Create the database and tables in MySQL.

```sql
CREATE DATABASE springsecuritydb;
USE springsecuritydb;

CREATE TABLE Employees (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    password VARCHAR(20)
);

CREATE TABLE Customers (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(50)
);
```

Insert sample records:

```sql
INSERT INTO Employees VALUES
(1, 'Ram', 'r@123'),
(2, 'Sita', 's@123'),
(3, 'Laxman', 'l@123');

INSERT INTO Customers VALUES
(1, 'Siva Praneesh', 'Hyd'),
(2, 'Ajay', 'AP'),
(3, 'Chalapathi', 'Rayachoty');
```

The `Employees` table stores user credentials, while the `Customers` table stores customer information.

## API Endpoints

All endpoints require valid user authentication.

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/getAllCustomers` | Get all customers |
| GET | `/getCustomerById/{id}` | Get a customer by ID |
| GET | `/getCustomerByName/{name}` | Get a customer by name |
| POST | `/addCustomer` | Add a new customer |
| PUT | `/updateCustomer` | Update a customer |
| DELETE | `/deleteCustomer/{id}` | Delete a customer by ID |

## How to Run the Project

1. Install Java 17, Maven, and MySQL.
2. Clone this repository.
3. Create the database and tables using the SQL commands above.
4. Configure your MySQL connection in `application.properties`.
5. Open the project in Eclipse as a Maven project.
6. Run `SpringSecurityProject1Application.java`.
7. Use Postman to test the APIs.

## Testing with Postman

1. Send a request to `http://localhost:8080/getAllCustomers`.
2. Open the **Authorization** tab.
3. Select **Basic Auth**.
4. Enter a username and password registered in the `Employees` table.
5. Click **Send**.

Valid credentials allow access to the protected customer data. Invalid credentials do not grant access.

## Security Note

This project is created for learning and demonstration purposes. It currently uses `NoOpPasswordEncoder` with plaintext passwords, which is not suitable for production. A production application should use BCrypt password hashing and HTTPS.

All authenticated users can access all customer endpoints in the current implementation. Role-based authorization and individual customer access restrictions are not implemented.

## License

This project is created and maintained by **Siva Praneesh Velpula**.

This project is licensed under the [MIT License](LICENSE).

Copyright (c) 2026 Siva Praneesh Velpula
