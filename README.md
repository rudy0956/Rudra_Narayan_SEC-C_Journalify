📓 Journalify - Personal Journal Application
👨‍💻 Team Members
Rudra Narayan Dash

📝 Short Project Description
Journalify is a secure and user-friendly web application that allows users to maintain their personal journals online.
It provides features like user registration, authentication (JWT-based), creating, updating, deleting journal entries, and role-based access control.
Built with Spring Boot and MongoDB, Journalify ensures a seamless experience with strong security and easy scalability.

🎥 Video Explanation
📽️ Click here to watch the video
https://drive.google.com/file/d/1GZINRh1NZ5AiX7rCqEh0tdCr0J7rOU41/view?usp=drivesdk

🛠️ Technologies Used
Java 17

Spring Boot

Spring Security (JWT Authentication)

MongoDB (NoSQL Database)

Lombok

Swagger (API Documentation)

Postman (Testing APIs)

Maven (Project management)

🚀 Steps to Run/Execute the Project
Prerequisites
Java 17 installed

Maven installed

MongoDB installed and running locally

Setup Instructions
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/Journalify.git
Navigate to the project directory:

bash
Copy
Edit
cd Journalify
Install dependencies and build:

bash
Copy
Edit
mvn clean install
Run the application:

bash
Copy
Edit
mvn spring-boot:run
Access the API Documentation (Swagger UI):

bash
Copy
Edit
http://localhost:8080/swagger-ui/index.html
Test the APIs:

Use Postman to test endpoints like registration, login, create/update journal entries.

JWT Token authentication must be used for protected routes.

✨ Key Features
User Registration and Login

JWT-based Authentication and Authorization

Create, View, Update, Delete Journal Entries

MongoDB Document Mapping with Spring Data

Secure Password Storage (BCrypt)

Role-based Access Control (Admin/User)

Automatic API documentation using Swagger

Email Notifications (Optional enhancement)

📌 Important
Always use the Bearer token in Postman for authenticated API access.

MongoDB must be running on default port 27017 unless configured otherwise.

Designed with ❤️ Rudra Narayan Dash

🚀 Ready to Go!
