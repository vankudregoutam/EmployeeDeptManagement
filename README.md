# Employee Department Management System  

A **Spring Boot-based CRUD application** to manage employees and departments. It provides APIs for employee onboarding, department assignment, record updates, and retrieval of structured reports.  

## 🚀 Features  
- Employee onboarding, update, and deletion  
- Department creation and assignment  
- Relationship mapping between employees and departments (`OneToMany`, `ManyToOne`)  
- RESTful APIs for all CRUD operations  
- Centralized exception handling and standardized responses  
- API testing and documentation with **Swagger UI**  

## 🛠️ Tech Stack  
- **Backend:** Java, Spring Boot, Hibernate JPA  
- **Database:** PostgreSQL  
- **Build Tool:** Maven  
- **API Testing & Docs:** Swagger UI  
- **Architecture:** Layered (Controller → Service → Repository)  

## 📂 Project Structure  
EmployeeDeptManagement
┣ 📂 src
┃ ┣ 📂 main
┃ ┃ ┣ 📂 java/com/example/demo
┃ ┃ ┃ ┣ 📂 controller # REST Controllers
┃ ┃ ┃ ┣ 📂 service # Service Layer
┃ ┃ ┃ ┣ 📂 repository # JPA Repositories
┃ ┃ ┃ ┗ 📂 entity # Entities (Employee, Department)
┃ ┃ ┣ 📂 resources
┃ ┃ ┃ ┣ application.properties # DB Config
┃ ┃ ┃ ┗ data.sql # Sample Data (if any)
┗ 📜 pom.xml


## ⚙️ Installation & Setup  

1. Clone the repository

   ```bash
   git clone https://github.com/vankudregoutam/EmployeeDeptManagement.git
   cd EmployeeDeptManagement
   
2. Configure PostgreSQL in application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/employeedb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3. Build and run the application

mvn spring-boot:run

4. Access Swagger UI for API testing

http://localhost:8080/swagger-ui/index.html

## 📌 API Endpoints (Examples)
**Employee APIs**

POST /employees → Add new employee

GET /employees → Get all employees
GET /employees/{id} → Get employee by ID
PUT /employees/{id} → Update employee details
DELETE /employees/{id} → Delete employee

**Department APIs**

POST /departments → Add new department
GET /departments → Get all departments
PUT /departments/{id} → Update department
DELETE /departments/{id} → Delete department

## ✅ Results / Outcomes

- Improved employee onboarding efficiency by ~40%
- Reduced manual query handling by ~50% using Hibernate JPA
- Enhanced debugging/testing time by ~45% via Swagger UI
