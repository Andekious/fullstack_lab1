# 🧩 Task Management Web App  
**Fullstack Development Labs — Spring Boot + React + MariaDB**

---

## 📘 Overview
This project is a fullstack **Task Management Web Application** developed as part of the **Fullstack Development Labs**.  
It allows users to manage tasks by priority, assign them to users, and reorder them using drag-and-drop functionality.

The system is divided into three main parts:
- **Backend:** Spring Boot (Lab 1)
- **Frontend:** React (Lab 2)
- **Database:** MariaDB
- **Version Control:** Git + GitHub

---

## ⚙️ Lab 1 — Backend Development
### Focus:
Build a REST API using **Spring Boot** and **JPA/Hibernate** to manage tasks and users, with database integration and JWT-based authentication.

### Features:
- Entity setup: `User`, `Task`, `Project`, etc.  
- CRUD operations for tasks and users  
- JWT Authentication (`/api/auth/login`, `/api/auth/register`)  
- Data stored in **MariaDB**  
- Connected via **Spring Data JPA**  
- Tested using Postman  

### Example API Endpoints:
| Method | Endpoint | Description |
|--------|-----------|-------------|
| `POST` | `/api/auth/register` | Register a new user |
| `POST` | `/api/auth/login` | Authenticate user & return JWT |
| `GET`  | `/api/tasks` | Get all tasks |
| `GET`  | `/api/tasks?priority=HIGH` | Filter tasks by priority |
| `POST` | `/api/tasks` | Create a new task |
| `PUT`  | `/api/tasks/{id}` | Update a task |
| `DELETE` | `/api/tasks/{id}` | Delete a task |

---

## 💻 Lab 2 — Frontend Development
### Focus:
Create a **React** interface that interacts with the backend API and allows managing tasks visually.

### Tools:
- React + React Router  
- Axios for API requests  
- react-beautiful-dnd for drag & drop sorting  
- Styled Components / CSS Modules for styling  

### Components:
| Component | Description |
|------------|--------------|
| `UserLogin` | Handles authentication; validates email & password using `useState`. Stores JWT in `localStorage`. |
| `TaskCard` | Displays individual task details with color-coded priority and supports drag events. |
| `TaskList` | Displays and reorders tasks using drag & drop, syncing changes with the backend. |
| `Profile` | Shows user details and allows editing. |

### Routes:
| Path | Component |
|------|------------|
| `/login` | Login form |
| `/dashboard` | Task overview and management |
| `/profile` | User settings page |

---

## 🧠 How to Run the Project

### 1️⃣ Backend (Spring Boot)
```bash
# Navigate to lab1 folder
cd lab1

# Run backend
./mvnw spring-boot:run
