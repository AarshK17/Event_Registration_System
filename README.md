# Event_Registration_System

A desktop-based **Event Registration System** built with **Java Swing (JFrame)** for the UI and **Java Servlets** for backend processing, connected to a **MySQL** database.

---

## 📌 Features

### **Welcome Page**
- Two buttons:
  - **Admin Login** → Opens Admin frame.
  - **Student Registration** → Opens Student frame.

### **Admin Login**
- Admin selects the event from a dropdown list.
- Enters a predefined password stored in MySQL.
- On successful authentication:
  - Admin can manage event data (view participants, etc. if implemented).

### **Student Registration**
- Student enters:
  - Name
  - Email
  - Contact number
  - Any other required details
- Selects the event they want to participate in.
- Clicks **Register** → Student details are stored in the MySQL database.

---

## 🛠️ Technologies Used
- **Java Swing (JFrame)** → GUI
- **Java Servlets** → Backend logic
- **JDBC** → Database connection
- **MySQL** → Database
- **Apache Tomcat** → Servlet container

---

## 📂 Project Structure 

<img width="550" height="407" alt="welcomePage" src="https://github.com/user-attachments/assets/31612d7a-69b8-4550-80e5-a85b527df14f" />
<img width="550" height="407" alt="adminLogin" src="https://github.com/user-attachments/assets/5a3edc3f-7376-4c82-a0b4-42f7e91b9b09" />
<img width="550" height="407" alt="adminDb" src="https://github.com/user-attachments/assets/f0fd690e-33f2-448a-913c-d2931d90d50d" />
<img width="550" height="407" alt="successPrompt" src="https://github.com/user-attachments/assets/5b5edcf4-e724-4b28-962b-e0da5eae29b9" />
<img width="550" height="407" alt="studentRegistration" src="https://github.com/user-attachments/assets/54f8835e-6dbe-4f6c-88da-a772e616216a" />
<img width="550" height="407" alt="studentDb" src="https://github.com/user-attachments/assets/cc2f9fdf-7fd5-49a7-906d-630e5bc75ba7" />

