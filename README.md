
## Employee Analyzer

 ## Overview
This project analyzes the organizational structure of a company to identify potential improvements in manager salaries and reporting lines.


It ensures:

Every manager earns at least 20% more and no more than 50% more than the average salary of their direct subordinates.

Reporting lines are not too long; employees with more than 4 managers above them are identified.



The program reads employee data from a CSV file and prints the analysis results to the console.




## File Structure


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

## mvn clean install
## mvn exec:java


## output

Managers earning LESS than allowed:
Manager Aman should earn at least 66000.0 but earns 60000.0 (short by 6000.0)

Managers earning MORE than allowed:
Manager Pallavi should earn no more than 90000.0 but earns 100000.0 (excess by 10000.0)

Employees with TOO LONG reporting lines:
Employee Ayush has a reporting depth of 5 levels (too long by 1)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.437 s
[INFO] Finished at: 2025-12-04T20:13:52+05:30
