# Invoice Processing System

This project is a backend system that receives invoice data encoded in Base64 XML format, decodes and validates it, and stores it in a PostgreSQL database. The system provides REST APIs with Swagger/OpenAPI documentation.

## 🧩 Roles

The system currently does not include authentication and is intended for internal/backend use only.

---

## ⚙️ Technologies Used

### Backend:
- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL**
- **Swagger / OpenAPI (springdoc-openapi)**
- **SLF4J & Logback** (Logging)
- **JAXB** (for parsing XML)
- **Lombok**

---

## 🧾 Project Overview

- The user sends an XML invoice encoded as a Base64 string via a POST request.
- The XML is decoded and parsed into Java classes (POJO) using JAXB.
- If the XML is invalid, a custom error message is returned.
- Valid invoices are persisted into the `Invoice` table in the database.
- All errors are handled by a global exception handler and returned in a consistent response structure.

---

## 📄 Sample Request

### `POST /api/v1/invoice`

```json
{
  "baseXml": "PEZha3R1cmEgeG1sbnM6eHNkPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYSIgeG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hNTFNjaGVtYS1pbnN0YW5jZSIgeG1sbnM9Imh0dHA6Ly9jcmQuZ292LnBsL3d6b3IvMjAyMy8wNi8yOS8xMjY0OC8iPgo8TmFnbG93ZWs+CjxLb2RGb3JtdWxhcnphIGtvZFN5c3RlbW93eT0iRkEgKDIpIiB3ZXJzamFTY2hlbXk9IjEtMEUiPkZBPC9Lb2RGb3JtdWxhcnphPgo8V2FyaWFudEZvcm11bGFyemE+MjwvV2FyaWFudEZvcm11bGFyemE+CjxEYXRhV3l0d29yemVuaWFGYT4yMDIzLTA4LTI5VDEyOjM0OjEzLjc4MDI1NzFaPC9EYXRhV3l0d29yemVuaWFGYT4KPFN5c3RlbUluZm8+U2FtcGxvZmFrdHVyPC9TeXN0ZW1JbmZvPgo8L05hZ2xvd2VrPgo8UG9kbWlvdDE+CjxEYW5lSWRlbnR5ZmlrYWN5am5lPgo8TklQPjk3ODEzOTkyNTk8L05JUD4KPE5hendhPkFCQyBBR0Qgc3AuIHogby4gby48L05hendhPgo8L0RhbmVJZGVudHlmaWthY3lqbmU+CjxBZHJlcz4KPEtvZEtyYWp1PlBMPC9Lb2RLcmFqdT4KPEFkcmVzTDE+dWwuIEt3aWF0b3dhIDE8L0FkcmVzTDE+CjwvQWRyZXM+CjxEYW5lS29udGFrdG93ZT4KPEVtYWlsPmV4YW1wbGVAZXhhbXBsZS5jb208L0VtYWlsPgo8L0RhbmVLb250YWt0b3dlPgo8L1BvZG1pb3QxPgo8UG9kbWlvdDI+CjxEYW5lSWRlbnR5ZmlrYWN5am5lPgo8TklQPjEyNTA3NTM1MDU8L05JUD4KPE5hendhPkNlRGVFIHMuYy48L05hendhPgo8L0RhbmVJZGVudHlmaWthY3lqbmU+CjxBZHJlcz4KPEtvZEtyYWp1PlBMPC9Lb2RLcmFqdT4KPEFkcmVzTDE+dWxpY2EgaSBudW1lcjwvQWRyZXNMMT4KPC9BZHJlcz4KPC9Qb2RtaW90Mj4KPEZhPgo8S29kV2FsdXR5PlBMTjwvS29kV2FsdXR5Pgo8UF8xPjIwMjMtMDgtMzE8L1BfMT4KPFBfMj5GSzIwMjMvMDgvMzE8L1BfMj4KPFBfMTNfMT4wPC9QXzEzXzE+CjxQXzE0XzE+MDwvUF8xNF8xPgo8UF8xM18yPjA8L1BfMTNfMj4KPFBfMTRfMj4wPC9QXzE0XzI+CjxQXzEzXzM+MDwvUF8xM18zPgo8UF8xNF8zPjA8L1BfMTRfMz4KPFBfMTNfND4wPC9QXzEzXzQ+CjxQXzE0XzQ+MDwvUF8xNF80Pgo8UF8xM181PjA8L1BfMTNfNT4KPFBfMTNfNz40MDAxLjQ5PC9QXzEzXzc+CjxQXzE1PjQwMDEuNDk8L1BfMTU+CjxBZG5vdGFjamU+CjxQXzE2PjI8L1BfMTY+CjxQXzE3PjI8L1BfMTc+CjxQXzE4PjI8L1BfMTg+CjxQXzE4QT4yPC9QXzE4QT4KPFp3b2xuaWVuaWU+CjxQXzE5Tj4xPC9QXzE5Tj4KPC9ad29sbmllbmllPgo8Tm93ZVNyb2RraVRyYW5zcG9ydHU+CjxQXzIyTj4xPC9QXzIyTj4KPC9Ob3dlU3JvZGtpVHJhbnNwb3J0dT4KPFBfMjM+MjwvUF8yMz4KPFBNYXJ6eT4KPFBfUE1hcnp5Tj4xPC9QX1BNYXJ6eU4+CjwvUE1hcnp5Pgo8L0Fkbm90YWNqZT4KPFJvZHphakZha3R1cnk+VkFUPC9Sb2R6YWpGYWt0dXJ5Pgo8RmFXaWVyc3o+CjxOcldpZXJzemFGYT4xPC9OcldpZXJzemFGYT4KPFBfNz5TcHJ6ZWRhxbwgdG93YXLDs3cgMjMlPC9QXzc+CjxQXzhBPnN6dC48L1BfOEE+CjxQXzhCPjIuMzIzPC9QXzhCPgo8UF85QT4yMzQuMjQ8L1BfOUE+CjxQXzExPjU0NC4xNDwvUF8xMT4KPFBfMTI+enc8L1BfMTI+CjwvRmFXaWVyc3o+CjxGYVdpZXJzej4KPE5yV2llcnN6YUZhPjI8L05yV2llcnN6YUZhPgo8UF83PkdUVV8xPC9QXzc+CjxQXzhBPi08L1BfOEE+CjxQXzhCPjIuNTYxPC9QXzhCPgo8UF85QT4xMzUwLjAwPC9QXzlBPgo8UF8xMT4zNDU3LjM1PC9QXzExPgo8UF8xMj56dzwvUF8xMj4KPC9GYVdpZXJzej4KPC9GYT4KPC9GYWt0dXJhPg=="
}

```

## 🚨 Error Handling
Errors are returned in a structured ExceptionResponse.

Example – Invalid XML:

```json

{
  "businessErrorCode": 400,
  "businessErrorDescription": "Validation Error",
  "error": "Invalid XML format"
}
```



## 🚀 Running the Project
1. Build the project
  ```bash
   mvn clean install
   ```

2. Start the Spring Boot application

  ```bash
   mvn spring-boot:run
   ```

   The app will run at:
   http://localhost:8088/api/v1/invoice


## 📚 Swagger / OpenAPI UI
You can access the Swagger UI for interactive API documentation at:

  ```bash
http://localhost:8088/api/v1/swagger-ui.html
   ```

   or

  ```bash
http://localhost:8088/api/v1/swagger-ui/index.html
   ```


## Contact

### Omer Faruk Kodat

<a href="https://github.com/omerfarukkodat" target="_blank">
<img  src=https://img.shields.io/badge/github-%2324292e.svg?&style=for-the-badge&logo=github&logoColor=white alt=github style="margin-bottom: 20px;" />
</a>
<a href = "mailto:farukkodat@gmail.com?subject = Feedback&body = Message">
<img src=https://img.shields.io/badge/send-email-email?&style=for-the-badge&logo=microsoftoutlook&color=CD5C5C alt=microsoftoutlook style="margin-bottom: 20px; margin-left:20px" />
</a>
<a href="https://linkedin.com/in/omerfarukkodat" target="_blank">
<img src=https://img.shields.io/badge/linkedin-%231E77B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white alt=linkedin style="margin-bottom: 20px; margin-left:20px" />
</a>  


<br />
