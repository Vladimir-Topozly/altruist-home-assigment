# altruist-home-assigment
Simple Selenium project for the home assignment  based on a Page Object Model (POM) design pattern, which includes the following technologies: 

* Java 14
* Selenium 4.13.0
* TestNG 7.4

## How to run
Use ```.idea/testng.xml``` and run the file 

### Implementation notes: 
* Implemented '/src/main/java/GoogleFinanceMethods.java' to store the methods bodies for the PO class follwing OOP principles
* Implemented a PO '/src/main/java/GoogleFinancePage.java' that stores all locators and methods implementations for the Google Finance page
* Implemented '/src/main/java/Utilities.java' class to store general methods used by the test such as 'getHTMLListRows', 'compareLists', 'printListElements'
* Added dependecies pom.xml for TestNG Maven
* Added testng.xml to define the test suite
* Implemented '/src/test/java/GoogleFinanceTests.java' test calss with TestNG annotations and the tests themeselves 

