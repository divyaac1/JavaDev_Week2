🏦 Simple Banking System (Java)
📌 Project Description

The Simple Banking System is a Java-based console application that simulates basic banking operations such as account creation, deposit, withdrawal, and balance enquiry.
The project demonstrates strong usage of Object-Oriented Programming (OOP) concepts along with File Handling for data persistence.

🎯 Features

Create a new bank account

Deposit money

Withdraw money

Check account balance

Support for multiple account types:

Savings Account

Current Account

Account data stored persistently using file handling

🛠 Tech Stack

Language: Java

Core Concepts: OOP (Encapsulation, Inheritance, Polymorphism)

Persistence: File Handling

Optional Extension: JDBC (can be integrated with MySQL)

🧱 OOP Concepts Used

Encapsulation:
Account details are protected using private fields and accessed via getters/setters.

Inheritance:
SavingsAccount and CurrentAccount extend the base Account class.

Polymorphism:
Overridden methods like getAccountType() allow dynamic behavior.

Abstraction:
Common account behavior defined in the abstract Account class.

📂 Project Structure
SimpleBankingSystem/
│
├── Account.java
├── SavingsAccount.java
├── CurrentAccount.java
├── BankService.java
├── FileRepository.java
├── Main.java
└── TestBanking.java

▶️ How to Run

Clone the repository:

git clone https://github.com/your-username/simple-banking-system.git


Open the project in any Java IDE (Eclipse / IntelliJ)

Compile and run:

javac Main.java
java Main

🧪 Sample Operations

Create account with account number and holder name

Deposit amount to account

Withdraw amount with balance validation

View current balance

🚀 Future Enhancements

Integrate JDBC + MySQL for database storage

Add user authentication

Implement transaction history

Improve exception handling and validations

Add GUI using JavaFX or Swing

👩‍💻 Author

Divya AC
Engineering Graduate | Java Developer
📌 Skills: Java, OOP, File Handling, JDBC
