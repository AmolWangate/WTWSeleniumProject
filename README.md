**Introduction**: 

This project is a comprehensive test automation framework built using Selenium WebDriver and TestNG. It is designed to efficiently test web applications by leveraging modern tools and practices such as the Page Object Model (POM) design pattern, parallel execution, and cloud-based testing with BrowserStack. Key features include the use of the Owners library, a custom retry analyser for handling flaky tests, and extensive reporting with Extent Reports. The framework also supports advanced customization through custom annotations and exceptions, as well as random data generation using the Faker library. Tests can be executed via command line, integrated into CI/CD pipelines, and are optimized for scalability and maintainability.

**Features**:
•	Selenium WebDriver: For browser automation.
•	TestNG: For test execution, configuration, and reporting.
•	Maven: For build and dependency management.
•	Page Object Model (POM): To organize web elements and actions.
•	Owners Library: For reading property data.
•	BrowserStack Integration: For executing tests on cloud-based browsers.
•	Parallel Execution: To run tests concurrently, reducing execution time.
•	Listener Implementation: For customizing TestNG behaviour during test execution.
•	Retry Analyzer: For rerunning failed tests automatically.
•	Custom Annotations and Exceptions: To enhance test customization and error handling.
•	Faker Library: For generating random test data.
•	Command Line Execution: To run tests via the command line or CI/CD pipelines.
•	Reusable Utilities: For common tasks like waiting, logging, assertions, etc.
•	Extent Reports: For detailed test execution reports.
•	Configurable Properties: To manage environment-specific settings.

**Prerequisites**: 
•	Java Development Kit (JDK) 11 or higher
•	Maven 3.x or higher
•	An IDE like IntelliJ IDEA or Eclipse
•	Web browsers
•	BrowserStack account (if using cloud-based execution)

**Setup**: 
1.	Clone the repository: git clone https://github.com/AmolWangate/WTWSeleniumProject.git
2.	Install dependencies: mvn clean install -DskipTests
3.	Running Tests
•	Using Maven: mvn test -Dbrowser=chrome -Dmode=local
•	Using TestNG: Right-click on the testng.xml file in your IDE and select "Run".
•	Running on BrowserStack: Configure BrowserStack credentials and desired capabilities in the remotecaps.properties and change the mode to browserstack in envconfig.properties

**Parallel Execution**: 
Tests can be executed in parallel by configuring the testng.xml file and specifying the parallel attribute at the suite or test level.

**Reporting**: 
Extent Reports are generated under the Extent-Report folder. Open the index.html file in a browser to view the detailed test report.



