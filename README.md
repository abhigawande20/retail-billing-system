Retail Billing System (POS)

A full-stack Retail Billing System (Point of Sale) designed to manage product sales, generate invoices, and track sales data for retail stores.
The system allows operators to add products to a cart, calculate totals with tax, generate PDF invoices, and monitor sales through a dashboard.

Tech Stack
Backend

Spring Boot – REST API development

Java – Backend programming

MongoDB – NoSQL database

iText – PDF invoice generation

Frontend

React – User interface

JavaScript / HTML / CSS – Frontend development

Chart.js – Sales analytics dashboard

Axios – API communication

React Router – Navigation between pages

Tools

Git & GitHub

Maven

Node.js / npm

Postman (API testing)

Features
Product Management

Add, view, and delete products

Maintain product inventory

Customer Management

Store customer details

Use customer name in billing

Billing Dashboard

Operator can add items to cart

Automatic subtotal, tax, and total calculation

Invoice Generation

Generate downloadable PDF invoices

Each order has a unique order ID

Order History

View past orders

Download invoice again anytime

Sales Analytics Dashboard

View total revenue

View number of orders

Visualize data using charts

How to Run the Project
1. Clone the Repository
git clone https://github.com/abhigawande20/retail-billing-system.git

Go into the project folder:

cd retail-billing-system
Run Backend (Spring Boot)
Step 1 – Open backend folder
cd backend
Step 2 – Install dependencies
mvn clean install
Step 3 – Run the application
mvn spring-boot:run

Backend will start at:

http://localhost:8080
Run Frontend (React)
Step 1 – Open frontend folder
cd frontend
Step 2 – Install dependencies
npm install
Step 3 – Start React server
npm start

Frontend will start at:

http://localhost:3000
