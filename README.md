# Employee CRUD Application

This is a simple Employee Management web application built with Java, Spring MVC (XML configuration), JSP, JSTL, and MySQL. It demonstrates basic CRUD (Create, Read, Update, Delete) operations for managing employees.

## Features
- List all employees
- Add a new employee
- Edit existing employee details
- Delete an employee

## Technologies Used
- Java 8+
- Spring MVC (no annotations, XML-based configuration)
- JSP & JSTL
- MySQL
- JDBC
- Tomcat 9
- Gradle

## Project Structure
- `src/main/java/com/example/employee/` - Java source code (Controller, DAO, Model)
- `src/main/webapp/WEB-INF/views/` - JSP views
- `src/main/webapp/WEB-INF/dispatcher-servlet.xml` - Spring MVC configuration
- `src/main/webapp/WEB-INF/application-context.xml` - Spring beans configuration
- `src/main/webapp/WEB-INF/web.xml` - Web application deployment descriptor

## Setup Instructions
1. **Database**: Create a MySQL database and update the connection details in `application-context.xml`.
2. **Build**: Run `./gradlew build` to build the project.
3. **Deploy**: Deploy the generated WAR file to Tomcat 9.
4. **Access**: Open [http://localhost:8080/employee-crud/](http://localhost:8080/employee-crud/) in your browser.

## Default URLs
- List Employees: `/employees`
- Add Employee: `/employee/form`
- Save Employee: `/employee/save`
- Edit Employee: `/employee/edit?id={id}`
- Delete Employee: `/employee/delete?id={id}`

## Notes
- Make sure JSTL and MySQL connector JARs are present in `WEB-INF/lib`.
- The application uses only XML configuration (no Spring annotations).
- For any issues, check Tomcat logs for errors.

## License
This project is for educational/demo purposes.

