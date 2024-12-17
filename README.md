# Booking Task

This repository contains an automation framework for end-to-end testing of a hotel booking application using **Selenium WebDriver** and **TestNG**. The tests cover functionality such as searching for a hotel, selecting dates, verifying booking details, and reserving a room.

## Features

- **Framework:** Built using Selenium WebDriver for browser automation and TestNG for test management.
- **Page Object Model (POM):** Organized structure with dedicated classes for each page.
- **Explicit Waits:** Implemented to handle dynamic web elements.
- **Cross-Browser Testing:** Designed to support multiple browsers (can be extended).
- **Reusable Components:** Utility functions for common actions like clicking, sending text, and switching tabs.

---

## Project Structure

```
Booking-Task
├── src
│   ├── main
│   │   └── java
│   │       ├── Pages
│   │       │   ├── ConfirmationPage.java
│   │       │   ├── DestinationPage.java
│   │       │   ├── HotelsPage.java
│   │       │   ├── pageBase.java
│   │       │   └── SearchPage.java
│   ├── test
│   │    └── java
│   │        └── dataProvider
│   │            └── data.json
│   │
│   │        └── testPackage
│   │            └── AutoTest.java
│   │            └── TestClass.java
│   │
│   │       └── utilities
│   │           └── jsonReader.java
│   │
├── testng.xml
└── pom.xml
```

### Explanation of Key Directories and Files

1. **`Pages/`:** Contains page-specific classes following the Page Object Model.
    - `pageBase.java`: Contains reusable methods like `setTextElementText`, `clicbutton`, etc.
    - `SearchPage.java`: Handles interactions for the search page, such as entering location, selecting dates, and initiating a search.

2. **`testPackage/`:** Contains test classes.
    - `AutoTest.java`: Includes test methods for validating the booking functionality.

3. **`testng.xml`:** Configuration file for TestNG test execution.

4. **`pom.xml`:** Maven configuration file for managing dependencies and build lifecycle.

---

## Key Functionalities

### Test Scenarios Covered

1. **Search and Book Hotel:**
    - Enter location for the trip.
    - Select check-in and check-out dates.
    - Search for available hotels.

2. **Select Hotel Room and Reserve:**
    - Select a specific hotel from the search results.
    - Choose a room option.
    - Proceed to the reservation step.

3. **Verify Booking Details:**
    - Verify hotel name, selected dates, and pricing.
    - Ensure booking details match user input.

### Sample Methods

- **`enterLocation(String locationForTrip)`**
  Handles entering the desired location and selecting from suggestions.

- **`datePicker()`**
  Selects check-in and check-out dates on the calendar.

- **`selectDate(String date)`**
  Dynamically picks a date based on input.

- **`switchToNewTab()`**
  Handles switching between tabs when required (e.g., during reservation).

---

## Installation and Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/HaZim-Ali/Booking-Task.git
   ```

2. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).

3. Ensure you have the following prerequisites installed:
    - **Java Development Kit (JDK):** Version 8 or higher.
    - **Maven:** To manage dependencies and build the project.
    - **Browser Drivers:** Ensure the appropriate WebDriver (e.g., ChromeDriver, GeckoDriver) is available in your system's PATH.

4. Install dependencies:
   ```bash
   mvn clean install
   ```

5. Update the `WebDriverUtils.java` file to specify the browser type and driver path.

---

## Running Tests

### Using TestNG XML
To execute the tests, run the `testng.xml` file located in the root directory. You can do this via your IDE or Maven:

```bash
mvn test
```

### Individual Test Execution
Run specific test methods by right-clicking the method in your IDE and selecting "Run." Ensure your browser drivers are correctly configured.

---

## Technologies Used

- **Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA (recommended)

---

## Future Enhancements

- **Integrate with CI/CD:** Use Jenkins or GitHub Actions for automated test execution.
- **Parallel Testing:** Leverage TestNG's parallel execution capabilities to speed up test runs.
- **Data-Driven Testing:** Parameterize test methods using TestNG `@DataProvider` or external data sources (e.g., Excel, JSON).
- **Browser Compatibility Testing:** Extend support for multiple browsers.

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Author

Developed by **Eng.Hazim Aly**. Feel free to reach out for feedback or questions:
- **Email:** [hazimaly5@gmail.com](mailto:hazimaly5@gmail.com)
- **LinkedIn:** [LinkedIn Profile](www.linkedin.com/in/hazim-aly-161476325)

---

## Contributing

Contributions are welcome! If you'd like to improve the project or add new features, feel free to fork the repository and create a pull request.
