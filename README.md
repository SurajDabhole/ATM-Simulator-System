# ATM Simulator Application

A desktop-based **ATM Simulator** application developed in Java, simulating real-world ATM functionalities like cash withdrawal, fast cash, balance enquiry, and deposits. The application uses a MySQL database to manage user accounts and transaction history, demonstrating OOP principles, JDBC connectivity, and GUI development with Swing.

---

## Features

- User-friendly GUI built with Java Swing  
- Multiple transaction types:  
  - Cash Withdrawal (including fast cash options)  
  - Deposit money  
  - Balance Enquiry  
- Secure PIN-based user sessions  
- Real-time balance calculation by fetching transaction history from MySQL  
- Modular code structure using Object-Oriented Programming (OOP)  
- Input validations to handle incorrect or empty inputs  
- Simple navigation with Back buttons between screens  

---

## Technologies Used

- **Java** (Core Java, Swing for GUI)  
- **MySQL** (Relational database for data persistence)  
- **JDBC** (Java Database Connectivity for SQL operations)  
- **OOP Concepts** (Classes, Encapsulation, Abstraction)  
- **Event-driven programming** (ActionListeners for UI interaction)  

---

## Project Structure

- `FastCash.java` — Fast cash withdrawal options  
- `Deposit.java` — Deposit money into account  
- `BalanceEnquiry.java` — Check current account balance  
- `Conn.java` — Database connection utility  
- Additional classes for transactions, login, and user sign-up screens  

---

## Database Schema

The project uses a MySQL database `bankmanagementsystem` with the following tables:

- `signup` — Stores user personal details  
- `signuptwo` — Stores additional user info (income, category, etc.)  
- `signupthree` — Stores account info (card number, PIN)  
- `login` — User login credentials  
- `bank` — Transaction records (pin, date, type, amount)  

---

## Getting Started

### Prerequisites

- JDK 8 or above installed  
- MySQL server installed and running  
- IDE like Eclipse/IntelliJ or command line for Java compilation  
- MySQL Connector/J library added to your project build path  

### Setup Instructions
1. Clone the repository: 
   git clone [https://github.com/SurajDabhole/ATM-Simulator-System.git]
2. Create the database and tables by running the SQL scripts included in database.sql (or manually run the queries).
3. Update the database credentials in Conn.java if needed:
  DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","your_password");
4. Compile and run the project from your IDE or terminal.
5. Start with the login or signup screens and use the ATM simulator features.
