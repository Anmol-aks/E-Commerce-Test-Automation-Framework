# E-Commerce Test Automation Framework

![CI/CD Workflow](https://github.com/YOUR_USERNAME/E-Commerce-Test-Automation-Framework/actions/workflows/maven-ci.yml/badge.svg)

## 📖 Overview

This project is a robust, end-to-end test automation framework built for the demo e-commerce website, [saucedemo.com](https://www.saucedemo.com/). It is designed to demonstrate best practices in Quality Engineering, including scalable architecture, data-driven testing, and full integration with a CI/CD pipeline. The framework validates the critical user paths of the application to ensure a seamless user experience.

---

## ✨ Key Features

* **Page Object Model (POM):** The framework is built on this design pattern to ensure a clean separation between test logic and UI interaction, leading to highly maintainable and reusable code.
* **End-to-End Scenarios:** Automates critical user flows including user authentication, product selection, shopping cart management, and the complete multi-step checkout process.
* **Data-Driven Testing:** Uses TestNG's `@DataProvider` to read various login credentials (valid, invalid, locked-out) from an external CSV file, allowing for extensive scenario coverage with minimal code.
* **Cross-Browser Parallel Execution:** Configured via `testng.xml` to run tests simultaneously on both **Chrome** and **Firefox**, significantly reducing execution time.
* **CI/CD Integration:** Fully integrated with **GitHub Actions**. The entire test suite is automatically triggered on every push to the `main` branch, providing an automated quality gate.
* **API Testing:** Includes backend tests for web services using **REST Assured** to validate business logic at the integration layer, demonstrating a full-stack testing approach.
* **Advanced Stability & Debugging:** Implemented robust solutions for common automation challenges:
    * **Headless Execution:** Configured to run reliably in headless environments.
    * **Explicit Waits:** Synchronizes the script with the application's state to handle dynamic elements.
    * **JavaScript Clicks:** Used for stubborn interactions where standard WebDriver clicks were unreliable.
* **Automatic Screenshots on Failure:** Utilizes a TestNG `ITestListener` to automatically capture screenshots of failed tests for quick and easy debugging.

---

## 🛠️ Tech Stack

| Category                  | Technology / Tool                                     |
| ------------------------- | ----------------------------------------------------- |
| **Language** | Java (JDK 18)                                         |
| **UI Automation** | Selenium WebDriver                                    |
| **Testing Framework** | TestNG                                                |
| **API Automation** | REST Assured                                          |
| **Build & Dependencies** | Maven                                                 |
| **CI/CD Platform** | GitHub Actions                                        |
| **Version Control** | Git & GitHub                                          |

---

## 📂 Project Structure

The project follows the standard Maven directory structure, with test code organized using the Page Object Model.

E-Commerce-Test-Automation-Framework/
├── .github/workflows/         # Contains the CI/CD workflow file (maven-ci.yml)
├── src/
│   └── test/
│       ├── java/
│       │   └── com/ecommerce/
│       │       ├── base/      # Base classes for browser setup and listeners
│       │       ├── pages/     # Page Object classes for each application page
│       │       └── tests/     # TestNG test classes
│       └── resources/         # Test data files (e.g., login-data.csv)
├── pom.xml                    # Manages project dependencies and plugins
└── testng.xml                 # TestNG suite configuration for running tests



---

## 🚀 Getting Started

### Prerequisites

* Java JDK 18 or higher
* Apache Maven
* Git

### Setup & Execution

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/YOUR_USERNAME/E-Commerce-Test-Automation-Framework.git](https://github.com/YOUR_USERNAME/E-Commerce-Test-Automation-Framework.git)
    cd E-Commerce-Test-Automation-Framework
    ```

2.  **Run the tests from the command line:**
    You can execute the entire test suite using Maven. This command will run the tests as defined in the `testng.xml` file.
    ```bash
    mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
    ```

3.  **Run the tests from an IDE (e.g., IntelliJ, Eclipse):**
    * Import the project as a Maven project.
    * Right-click on the `testng.xml` file.
    * Select "Run '.../testng.xml'".

---

### CI/CD Pipeline

This project's CI/CD pipeline is managed by GitHub Actions and is defined in the `.github/workflows/maven-ci.yml` file.

* **Trigger:** The workflow runs automatically on every `push` to the `main` branch.
* **Jobs:** It contains a single job that performs the following steps:
    1.  Checks out the repository code.
    2.  Sets up the JDK 18 environment.
    3.  Executes the full test suite in a headless environment.
* **Status:** The build status badge at the top of this README reflects the result of the latest workflow run.

