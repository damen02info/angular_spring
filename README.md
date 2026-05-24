# Inventory Stock Management - Backend Explanation

This repository contains the backend for a practice inventory stock application. The main goal of this project was to build a structured REST API using **Java 21** and **Spring Boot 4.0.3**, connected to a **MySQL** database, and prepared to serve an Angular frontend.

---

## 🛠️ Tech Stack Applied

- **Java 21** & **Spring Boot 4.0.3**: Core framework for the REST API.
- **Spring Data JPA**: Used for Object-Relational Mapping (ORM) and database communication without writing manual SQL queries.
- **MySQL**: Relational database chosen to persist inventory product data.
- **Lombok**: Integrated to reduce boilerplate code such as Getters, Setters, and Constructors.

---

## 🏗️ Architecture & How It Works

The backend follows a standard **layered architecture** to clearly separate responsibilities:

```text
src/main/java/com/mdz/angular_spring/
├── controller/
│   └── ProductoController.java      # REST Layer (Handles HTTP requests)
├── model/
│   └── Producto.java                # Data Layer (Database Entity Mapping)
├── repository/
│   └── ProductoRepository.java      # Data Access Layer (JPA Queries)
├── service/
│   ├── IProductoService.java        # Business Logic Layer (Interface)
│   └── ProductoService.java         # Business Logic Layer (Implementation)
└── AngularSpringApplication.java    # Application Entry Point
```

---

## 🔄 Data Flow Execution

### 1. Model Layer

The `Producto.java` class defines the structure of the inventory item (ID, name, stock quantity, price, etc.) and maps it as a table in MySQL using JPA annotations.

### 2. Repository Layer

`ProductoRepository.java` extends `JpaRepository`, providing built-in CRUD operations automatically:

- Create
- Read
- Update
- Delete

This avoids writing manual SQL queries.

### 3. Service Layer

The service layer (`IProductoService` and `ProductoService`) isolates the business logic from the controller. It manages how data is processed before being stored or returned.

### 4. Controller Layer

`ProductoController.java` exposes the REST API endpoints such as:

```http
GET /api/productos
POST /api/productos
PUT /api/productos/{id}
DELETE /api/productos/{id}
```

The controller receives HTTP requests from the Angular frontend, invokes the service layer, and returns JSON responses.

---

## 📸 Application Demonstration

Here is how the system looks and operates during execution:

### 1. Database Connection & API Initialization

```bash
./mvnw spring-boot:run
```
<img width="817" height="318" alt="image" src="https://github.com/user-attachments/assets/fd15b519-4c50-4044-af42-cd872513e115" />

---

### 2. Frontend Connection / Postman API Test

<img width="1551" height="527" alt="Productos" src="https://github.com/user-attachments/assets/c7ac1004-e932-4b75-8215-0389a20b026c" />

---

### 3. Inventory Operations (CRUD)

<img width="1614" height="527" alt="AgregarProducto" src="https://github.com/user-attachments/assets/da3679dc-ba72-4613-a292-55b4a9086773" />

<img width="1439" height="632" alt="PruebasPostman" src="https://github.com/user-attachments/assets/09201cc1-155d-4932-8adb-3c60532afed4" />

