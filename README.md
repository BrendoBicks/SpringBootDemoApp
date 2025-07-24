# 🧩 Asset Management API

A Spring Boot REST API that performs basic CRUD operations on assets and related tables. The API demonstrates proper use of DTOs, service layers, validation, and database migrations using Flyway.

---

## 🚀 Features

- Basic CRUD operations on:
  - `assets`
  - `asset_types`
  - `asset_status`
- Relationships:
  - Each Asset is associated with a single AssetType and AssetStatus
- **DTOs** used to return only selected Asset fields (for demonstration)
- Returns **400 Bad Request** when required fields are missing
- Returns **404 Not Found** when entities cannot be located
- Some business logic is abstracted into AssetService for a cleaner AssetController
- **Flyway** is used to manage and version the database schema

---

## Tech Stack

| Tool                 | Purpose                                                  |
|----------------------|----------------------------------------------------------|
| Spring Boot          | Java application framework                               |
| Spring Web           | Build RESTful APIs                                       |
| Spring Data JPA      | ORM for database interactions                            |
| Flyway               | Database version control and migrations                  |
| Lombok               | Generate boilerplate code (getters/setters/constructors) |
| MySQL                | Database                                                 |


## API Endpoints

## 📫 API Endpoints

| Method | Route                 | Description                           |
|--------|-----------------------|---------------------------------------|
| GET    | /assets               | Get all assets                        |
| GET    | /assets/{id}          | Get a single asset by ID              |
| POST   | /assets/create        | Create a new asset                    |
| PUT    | /assets/{id}          | Update an existing asset              |
| DELETE | /assets/{id}          | Delete an asset by ID                 |
| GET    | /asset-status         | Get all asset statuses                |
| GET    | /asset-status/{id}    | Get a single asset status by ID       |
| POST   | /asset-status/create  | Create a new asset status             |
| PUT    | /asset-status/{id}    | Update an existing asset status       |
| DELETE | /asset-status/{id}    | Delete an asset status by ID          |
| GET    | /asset-types          | Get all asset types                   |
| GET    | /asset-types/{id}     | Get a single asset type by ID         |
| POST   | /asset-types/create   | Create a new asset type               |
| PUT    | /asset-types/{id}     | Update an existing asset type         |
| DELETE | /asset-types/{id}     | Delete an asset type by ID            |
