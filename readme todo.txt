TODO APPLICATION
A simple Todo application built using Spring Boot, H2 Database, and MySQL. This application allows users to manage their tasks, providing functionality to add, view, and delete todos.

Features : 
•	Add Todos: Create new todos with a description, target date, and status.
•	View Todos: View a list of all todos associated with a user.
•	Delete Todos: Remove todos that are no longer needed.
•	Validation: Ensure todos meet the minimum description length requirement.
•	In-Memory Database (H2): For development and testing.
•	MySQL Integration: For production deployment.
•	Tech Stack
•	Spring Boot: Framework for building Java-based web applications.
•	H2 Database: In-memory database for development and testing.
•	MySQL: Relational database for production.
•	Thymeleaf: Server-side Java template engine for rendering dynamic web pages.
Getting Started :
Prerequisites
Ensure you have the following installed:

Java 8 or higher
Maven (for build management)
MySQL (for production setup)
An IDE such as IntelliJ IDEA or Eclipse EE
Setup Instructions
Clone the repository:

bash
Copy code
git clone https://github.com/yourusername/todo-application.git
cd todo-application
Configure MySQL Database:

Create a new MySQL database and update the application.properties file in src/main/resources/ with your MySQL configurations:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Run the application:

Use Maven to build and run the application:

bash
Copy code
mvn spring-boot:run
Access the Application:

Open your web browser and navigate to http://localhost:8080/list-todos.

Using H2 Database
To use the H2 in-memory database for development or testing, ensure the following properties are set in the application.properties file:

properties
Copy code
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
You can access the H2 console at http://localhost:8080/h2-console with the JDBC URL jdbc:h2:mem:testdb.

Project Structure
css
Copy code
src
│── main
│   ├── java
│   │   └── com.rakshan.todo.appli
│   │       ├── TodoController.java
│   │       ├── TodoService.java
│   │       └── TodoAppli.java
│   └── resources
│       ├── application.properties
│       └── templates
│           ├── listTodos.html
│           └── todo.html
│── test
│   └── java
└── pom.xml
Key Classes
TodoController: Handles web requests related to managing todos.
TodoService: Business logic for managing todos.
TodoAppli: Model class for representing a todo.
Contributing
Feel free to fork this project, create a feature branch, and submit a pull request. All contributions are welcome!

License
This project is open-source and available under the MIT License.

Acknowledgments
Spring Boot Documentation: Spring Boot
Thymeleaf Documentation: Thymeleaf
