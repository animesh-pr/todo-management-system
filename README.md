# Todo Management System

## Overview

This project is a **Command Line Interface (CLI) Todo Management System** developed in Java.
It demonstrates a layered architecture using **DAO, Service, Repository, and Factory patterns** with support for **multiple databases**.

The system allows users to manage tasks such as creating, updating, deleting, and viewing todos.

---

## Features

* Create a new Todo
* Retrieve a Todo by ID
* Update an existing Todo
* Delete a Todo
* View all Todos
* Multiple database support (MySQL, MongoDB, PostgreSQL)
* Clean architecture using Factory Pattern
* Unit testing with JUnit
* Static code analysis using SonarQube
* Security scan using Gitleaks

---

## Project Structure

```
todo-assignment
│
├── src
│   ├── main/java/com/todo
│   │   ├── dao
│   │   ├── factory
│   │   ├── model
│   │   ├── repository
│   │   ├── service
│   │   └── Main.java
│   │
│   └── test/java/com/todo
│
├── sql
│   └── database scripts
│
├── pom.xml
└── README.md
```

---

## Technologies Used

* Java
* Maven
* JDBC
* JUnit
* SonarQube
* Gitleaks
* Git & GitHub

---

## Running the Application

### 1. Clone the repository

```
git clone https://github.com/animesh-pr/todo-management-system.git
```

### 2. Navigate to the project directory

```
cd todo-assignment
```

### 3. Build the project

```
mvn clean install
```

### 4. Run the application

```
java -cp target/classes com.todo.Main
```

---

## SonarQube Analysis

The project was analyzed using SonarQube.

Results:

* Quality Gate: **PASSED**
* Code Coverage: **87.6%**
* Bugs: **0**
* Vulnerabilities: **0**

---

## Security Scan

A security scan was performed using **Gitleaks**.

Result:

```
No leaks found
```

---

## Demo

A demo video of the application is included in the repository.

---

Animesh Vaish
