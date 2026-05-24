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

---
---

# Gestión de Stock de Inventario - Explicación del Backend

Este repositorio contiene el backend para una aplicación de práctica de gestión de stock de inventario. El objetivo principal de este proyecto fue construir una API REST estructurada utilizando **Java 21** y **Spring Boot 4.0.3**, conectada a una base de datos **MySQL**, y preparada para dar servicio a un frontend en Angular.

---

## 🛠️ Tecnologías Aplicadas

- **Java 21** y **Spring Boot 4.0.3**: Framework principal para el desarrollo de la API REST.
- **Spring Data JPA**: Utilizado para el mapeo objeto-relacional (ORM) y la comunicación con la base de datos sin necesidad de escribir consultas SQL manuales.
- **MySQL**: Base de datos relacional elegida para persistir los datos del inventario.
- **Lombok**: Integrado para reducir código repetitivo como Getters, Setters y Constructores.

---

## 🏗️ Arquitectura y Funcionamiento

El backend sigue una **arquitectura en capas** estándar para separar claramente las responsabilidades:

```text
src/main/java/com/mdz/angular_spring/
├── controller/
│   └── ProductoController.java      # Capa REST (Gestiona peticiones HTTP)
├── model/
│   └── Producto.java                # Capa de Datos (Entidad de Base de Datos)
├── repository/
│   └── ProductoRepository.java      # Capa de Acceso a Datos (Consultas JPA)
├── service/
│   ├── IProductoService.java        # Capa de Lógica de Negocio (Interfaz)
│   └── ProductoService.java         # Capa de Lógica de Negocio (Implementación)
└── AngularSpringApplication.java    # Punto de Entrada de la Aplicación
```

---

## 🔄 Flujo de Ejecución de los Datos

### 1. Capa Modelo

La clase `Producto.java` define la estructura del producto del inventario (ID, nombre, cantidad en stock, precio, etc.) y la mapea como una tabla en MySQL utilizando anotaciones JPA.

### 2. Capa Repositorio

`ProductoRepository.java` extiende `JpaRepository`, proporcionando automáticamente operaciones CRUD:

- Crear
- Leer
- Actualizar
- Eliminar

Esto evita escribir consultas SQL manualmente.

### 3. Capa de Servicio

La capa de servicio (`IProductoService` y `ProductoService`) aísla la lógica de negocio del controlador. Gestiona cómo se procesan los datos antes de almacenarlos o devolverlos.

### 4. Capa Controlador

`ProductoController.java` expone los endpoints REST como:

```http
GET /api/productos
POST /api/productos
PUT /api/productos/{id}
DELETE /api/productos/{id}
```

El controlador recibe las peticiones HTTP desde Angular, invoca la capa de servicio y devuelve respuestas en formato JSON.

---

## 📸 Demostración de la Aplicación

Así es como se ve y opera el sistema durante la ejecución:

### 1. Conexión a la Base de Datos e Inicialización de la API

```bash
./mvnw spring-boot:run
```

<img width="817" height="318" alt="image" src="https://github.com/user-attachments/assets/fd15b519-4c50-4044-af42-cd872513e115" />

---

### 2. Conexión con el Frontend / Prueba en Postman

<img width="1551" height="527" alt="Productos" src="https://github.com/user-attachments/assets/dc52af46-dbc2-48fe-a021-4fe957b8384b" />

---

### 3. Operaciones CRUD del Inventario

<img width="1614" height="527" alt="AgregarProducto" src="https://github.com/user-attachments/assets/4fdc432c-5d95-4db6-9487-397485385371" />

<img width="1439" height="632" alt="PruebasPostman" src="https://github.com/user-attachments/assets/444ce7f9-50fe-4fd8-8511-ef65b6d3a136" />

