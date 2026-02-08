# StarHealth Premium Calculator 🏥

## 📌 Overview

The **StarHealth Premium Calculator** is a robust backend logic engine designed to automate the complex world of health insurance pricing. Unlike static retail products, insurance premiums are dynamic and risk-sensitive. This system eliminates human error and financial inaccuracies by leveraging Object-Oriented Programming (OOP) and high-precision arithmetic.

## 🚀 The Problem & Solution

### The Core Issue

* **Error-Prone Manual Entry:** Human agents often overlook "loading rules" (extra charges based on risk).
* **Precision Loss:** Standard `float` and `double` types in Java cause "penny-rounding" errors, which are unacceptable in the **BFSI (Banking, Financial Services, and Insurance)** sector.
* **Rigidity:** Legacy systems require massive code rewrites to add new policy types.

### Our Solution

* **Precision Engine:** Uses `BigDecimal` for all financial calculations to ensure zero-loss accuracy.
* **Automated Loading:** Business rules (Age, Smoking habits, Dependents) are applied dynamically.
* **Extensible Architecture:** Built on the **Open/Closed Principle**—new policy types can be added without modifying existing logic.

---

## 🏗️ Architecture

### 1. Class Diagram

The system uses **Abstraction** to define a base policy and **Polymorphism** to calculate premiums differently for individuals versus families.

### 2. Logic Flow

The engine follows a strict sequence to ensure all risk factors are accounted for before applying taxation.

---

## 🛠️ Tech Stack

* **Language:** Java (Core Java 17+)
* **Concepts:** Abstraction, Polymorphism, Encapsulation.
* **Financial Handling:** `java.math.BigDecimal` with `RoundingMode.HALF_UP`.

---

## 📂 Project Structure

```text
src/
└── com/starhealth/
    ├── model/          # Domain Entities (Individual, Family Floater)
    ├── util/           # Constants and Business Loading Rules
    └── main/           # Application Entry Point

```

---

## 💻 Code Snippet: The Precision Logic

We avoid `double` to prevent precision errors. Below is how we handle the "Loading" math:

```java
// Age Loading Logic using BigDecimal
if (this.age > PolicyRules.AGE_RISK_THRESHOLD) {
    finalAmount = finalAmount.multiply(PolicyRules.AGE_LOAD_FACTOR);
}

// Ensure 2-decimal precision for currency
return finalAmount.setScale(2, RoundingMode.HALF_UP);

```

---

## 🚦 Getting Started

### Prerequisites

* JDK 17 or higher.
* An IDE (IntelliJ IDEA, Eclipse, or VS Code).

### Installation

1. **Clone the repository:**
```bash
git clone https://github.com/your-username/StarHealth-Premium-Calculator.git

```


2. **Navigate to the project directory:**
```bash
cd StarHealth-Premium-Calculator

```


3. **Compile and Run:**
```bash
javac src/com/starhealth/main/PremiumCalculatorApp.java
java com.starhealth.main.PremiumCalculatorApp

```



---

## 📈 Future Roadmap

* [ ] **Senior Citizen Plan:** Specialized loading for age > 60.
* [ ] **Critical Illness Add-on:** Modular loading for specific medical history.
* [ ] **REST API:** Wrapping this logic in a Spring Boot microservice.

---

## 🤝 Contributing

Contributions are welcome! If you find a bug or want to add a new policy type, please open an issue or submit a pull request.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](https://www.google.com/search?q=LICENSE) file for details.

---

**Developed with ❤️ for the BFSI Sector.**

Would you like me to help you draft a **Senior Citizen Policy** class to see how easily it integrates into this existing structure?