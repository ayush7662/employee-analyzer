
Employee Analyzer

Overview
This project analyzes the organizational structure of a company to identify potential improvements in manager salaries and reporting lines.


It ensures:

Every manager earns at least 20% more and no more than 50% more than the average salary of their direct subordinates.

Reporting lines are not too long; employees with more than 4 managers above them are identified.



The program reads employee data from a CSV file and prints the analysis results to the console.




File Structure


employee-analyzer/
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com/company/swissre/
│   │   │       ├── App.java
│   │   │       ├── model/Employee.java
│   │   │       ├── service/EmployeeAnalyzer.java
│   │   │       └── util/CsvReader.java
│   │   └── resources/
│   │       └── employees.csv
│   └── test
│       └── java
│           └── (Optional JUnit tests)




How to Run

mvn clean install
mvn exec:java