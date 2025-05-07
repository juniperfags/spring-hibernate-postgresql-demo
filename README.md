# 📚 Book API - Spring Boot MVC

This project is a simple REST API built with **Spring Boot** using the traditional **Spring MVC** (blocking) stack. It manages `Book` resources with three basic operations.

---

## 🧱 Main model: `Book`

```java
public class Book {
    private Long id;
    private String title;
    private String description;
    private String author;
}
```

---

## 🚀 Technologies Used

- Java 17+
- Spring Boot 3+
- Spring Web (MVC)
- Maven

---

## 📌 Available Endpoints

### 🔍 GET `/api/books/find/{id}`

Find a book by its ID.

- **Path Variable**: `id` (Long)  
- **Response**: `200 OK` with a `Book` object or `404 Not Found`

#### Example Response

```json
{
  "id": 1,
  "title": "Clean Code",
  "description": "A handbook of agile software craftsmanship",
  "author": "Robert C. Martin"
}
```

---

### 📚 GET `/api/books/list`

List all av books.

- **Response**: `200 OK` with a list of `Book` objects

#### Example

```json
[
  {
    "id": 1,
    "title": "Clean Code",
    "description": "A handbook of agile software craftsmanship",
    "author": "Robert C. Martin"
  },
  {
    "id": 2,
    "title": "Effective Java",
    "description": "Best practices for Java programming",
    "author": "Joshua Bloch"
  }
]
```

---

### ➕ POST `/api/books/create`

Create a new book.

- **Request Body**: JSON object with `id`, `title`, `description`, and `author`  
- **Response**: `201 Created` with the created `Book`

#### Example Request

```json
{
  "id": 3,
  "title": "The Pragmatic Programmer",
  "description": "Your journey to mastery",
  "author": "Andy Hunt"
}
```

---

## ✅ Running the Project

### 1. Clone the repository

```bash
git clone https://github.com/juniperfags/spring-hibernate-postgresql-demo
cd spring-hibernate-postgresql-demo
```

### 2. Build and Run

```bash
./mvnw spring-boot:run
```

The server will start by default at `http://localhost:8080`.

---

## 🧪 Quick Test with curl

```bash
curl -X POST http://localhost:8080/api/books/create \
  -H Content-Type: application/json" \
  -d '{"id":1,"title":"Clean Code","description":"Agile book","author":"Robert C. Martin"}'

curl http://localhost:8080/api/books/list

curl http://localhost:8080/api/books/find/1
```

---
