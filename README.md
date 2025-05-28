# ToDoApp

A simple, modern web-based To-Do List application built with Spring Boot, Thymeleaf, and MySQL. The app allows users to add, complete, and delete tasks with a clean, responsive UI.

## Features
- Add new tasks
- Mark tasks as completed/uncompleted
- Delete tasks
- Responsive and modern UI (Bootstrap, custom CSS)
- Persistent storage with MySQL
- Dockerized for easy deployment

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Thymeleaf
- MySQL
- Docker & Docker Compose
- Bootstrap 5

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+
- Docker (for containerized setup)

### Local Development
1. **Clone the repository:**
   ```bash
   git clone https://github.com/MahmoudOsama-007/todo-list.git
   cd ToDoApp
   ```
2. **Configure the database:**
    - By default, the app uses the following MySQL settings (see `src/main/resources/application.properties`):
        - URL: `jdbc:mysql://localhost:3306/todo`
        - Username: `root`
        - Password: `pass`
    - You can override these with environment variables:
        - `DB_SERVICE_NAME` (default: localhost)
        - `DATABASE_PORT` (default: 3306)
        - `DB_NAME` (default: todo)
        - `DB_USER` (default: root)
        - `DB_PASSWORD` (default: pass)
3. **Start MySQL locally** (or use Docker):
   ```bash
   docker run --name todo-mysql -e MYSQL_DATABASE=todo -e MYSQL_ROOT_PASSWORD=pass -p 3306:3306 -d mysql:8
   ```
4. **Build and run the app:**
   ```bash
   ./mvnw spring-boot:run
   ```
5. **Access the app:**
    - Open [http://localhost:8080](http://localhost:8080) in your browser.

### Dockerized Setup
1. **Create a `.env` file** in the project root with the following content:
   ```env
   MYSQL_VERSION=8
   DB_NAME=todo
   DB_USER=root
   DB_PASSWORD=password
   DB_ROOT_PASSWORD=pass
   ```
2. **Build and start the services:**
   ```bash
   docker-compose up --build
   ```
3. **Access the app:**
    - Open [http://localhost:8080](http://localhost:8080) in your browser.
    - MySQL will be available on port 3309.

## Project Structure
```
├── src/main/java/com/example/todoapp
│   ├── controller/        # Web controllers (TodoController)
│   ├── model/             # JPA entities (Todo)
│   └── repository/        # Spring Data JPA repositories
├── src/main/resources
│   ├── templates/         # Thymeleaf HTML templates (index.html)
│   ├── static/css/        # Custom CSS (style.css)
│   └── application.properties
├── Dockerfile
├── docker-compose.yml
└── pom.xml
```

## UI & Styling
- The app uses Bootstrap 5 and a custom CSS theme for a clean, modern look.
- All UI is rendered server-side with Thymeleaf.

## Screenshots
![Screenshot](Screenshot%202025-05-27%20121044.png)

## License
This project is for demo/educational purposes. 