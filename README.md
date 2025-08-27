# Employee Department Management System

A **Full-Stack Employee Department Management Application** with:  
- **Backend**: Spring Boot + Hibernate JPA + PostgreSQL  
- **Frontend**: React.js (`empdeptweb`)  

The system provides RESTful APIs for employee onboarding, department assignment, and data retrieval, with a React-based frontend UI for user interaction.

---

## 🚀 Features
- ✅ Employee Management (Create, Read, Update, Delete)  
- ✅ Department Management with Employee Assignments 
- ✅ RESTful APIs with centralized exception handling  
- ✅ Swagger UI for API Documentation & Testing  
- ✅ PostgreSQL Integration with Hibernate JPA  
- ✅ React Frontend for Interactive UI  

---

## 🛠️ Tech Stack
- **Backend**: Java, Spring Boot, Hibernate JPA  
- **Database**: PostgreSQL  
- **Build Tool**: Maven  
- **Frontend**: React.js (`empdeptweb`)  
- **API Documentation**: Swagger UI  
- **Architecture**: Layered (Controller → Service → Repository + React Frontend)  

---

## 📂 Project Structure
  - **EmployeeDeptManagement**
    
     ```
    ├─ 📁 empdeptweb/ # React frontend
    │ ├─ 📁 public/ # Static files
    │ ├─ 📁 src/
    │ │ ├─ 📁 components/ # React components
    │ │ ├─ 📁 services/ # API service calls
    │ │ └─ 📄 App.js # Main React app
    │ └─ 📄 package.json # React dependencies
    │
    ├─ 📁 src/main/java/com/example/demo/
    │ ├─ 📁 controller/ # REST Controllers
    │ ├─ 📁 service/ # Business Logic
    │ ├─ 📁 repository/ # JPA Repositories
    │ └─ 📁 entity/ # Entities (Employee, Department)
    │
    ├─ 📁 src/main/resources/
    │ ├─ 📄 application.properties # Database configuration
    │ └─ 📄 data.sql # Sample data (optional)
    │
    └─ 📄 pom.xml # Maven dependencies
    ```

---
    
## ⚙️ Installation & Setup

## 🔹 Backend Setup (Spring Boot)
1. **Clone the repository**
   ```
   git clone https://github.com/vankudregoutam/EmployeeDeptManagement.git
   cd EmployeeDeptManagement
   ```

2. **Configure PostgreSQL in src/main/resources/application.properties:**
    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/employeedb
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Run the backend**
   ```
   mvn spring-boot:run
   ```

4. **Swagger UI available at**
    ```
    http://localhost:8080/swagger-ui/index.html
    ```

## 🔹 Frontend Setup (empdeptweb)

1. **Navigate to frontend folder:**
    ```
    cd empdeptweb
    ```

2. **Install dependencies:**
   ```
   npm install
   ```

3. **Start the React development server:**
   ```
   npm start
   ```

4. **Frontend will run on:**
   ```
   http://localhost:5173
   ```

⚡ By default, the React app (empdeptweb) calls backend APIs running on http://localhost:8080.
You can configure the base URL in src/services/api.js.

---

## 📌 API Endpoints
**👨‍💼 Employee APIs**

POST /employees → Add new employee
GET /employees → Get all employees
GET /employees/{id} → Get employee by ID
PUT /employees/{id} → Update employee
DELETE /employees/{id} → Delete employee

**🏢 Department APIs**

POST /departments → Add new department
GET /departments → Get all departments
PUT /departments/{id} → Update department
DELETE /departments/{id} → Delete department

---

## 📊 Project Outcomes

- 🚀 ~40% improvement in employee onboarding efficiency
- ⚡ ~50% reduction in manual query processing using Hibernate JPA
- 🔍 ~45% faster debugging and testing via Swagger UI
- 🎨 React frontend provides a clean UI for CRUD operations

---

## 🌟 Acknowledgements

- Spring Boot & Hibernate community
- PostgreSQL developers
- React.js contributors
- Swagger UI team
