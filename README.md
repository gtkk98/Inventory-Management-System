# Mini ERP – Inventory Management System

A console-based Mini ERP Inventory Management System developed using Java and MySQL. This project simulates real-world inventory workflows by allowing users to manage products through a structured, layered architecture. It demonstrates core ERP concepts such as data persistence, CRUD operations, and clean separation of concerns using the DAO design pattern.

## Features

* Add new products to the inventory
* View all available products
* Update existing product details
* Delete products from the system
* MySQL database integration using JDBC
* Menu-driven console interface
* Maven-based project structure
* Clean and modular codebase

## Technologies Used

* Java
* MySQL
* JDBC
* Maven
* VS Code

## Project Architecture

This project follows a layered architecture:

* **Model Layer** – Represents database entities
* **DAO Layer** – Handles database operations (CRUD)
* **Utility Layer** – Manages database connections
* **Main Layer** – Acts as the user interface (console-based)

This structure makes the application scalable, maintainable, and closer to real-world enterprise systems.

## Project Structure

```
src/main/java/com/mini/erp
│
├── model        → Entity classes
├── dao          → Database logic (CRUD)
├── util         → Database connection
└── main         → Application entry point
```

## Setup Instructions

1. Clone the repository
2. Create the MySQL database and tables
3. Update database credentials in `DBConnection.java`
4. Run the `Main.java` file
5. Interact with the system through the console menu

## Learning Outcomes

* Understanding of JDBC and database connectivity
* Hands-on experience with DAO design pattern
* Improved object-oriented programming skills
* Exposure to ERP-style system design
* Practical experience with Maven project structure

---

This project was built for learning purposes and simulates how real-world ERP inventory modules work at a basic level.
