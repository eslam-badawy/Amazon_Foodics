## This is a simple task using Cucumber Framework with Selenium JAVA which contains the below structure :-
1. Open https://www.amazon.eg/ and login
2. open “All” menu from the left side
3. click on “video games” then choose “all video games”
4. from the filter menu on the left side add filter “free shipping” & add the
filter of condition “ new”
5. in the right side open the sort menu then sort by price: high to low
6. add all products below that its cost below 15k EGP, if no product below
15k EGP move to next page
7. make sure that all products is already added to carts
8. add address and choose cash as a payment method
9. make sure that the total amount of all items is correct with the shipping
fees if exist

	
## The Framework specifications:-

•   I added a prerequisite step to cleanup the cart before the test

•   Support Cross-Browsing Mode (Chrome-Firefox-Edge)

•   Maven project: I add all the needed dependencies in the POM.xml

•	Test runner class: The place which we can run  

•	Properties file: I add the url, browser name, username, ..........

•	Junit dependency: I used Junit library

•	Page object model: I followed the POM

•	Hooks class: It contains the after and before scenario

•	Pretty report Plugin: it provided me with a pretty test report

•   Base class: It contains the webDriver, initializingBrowser(), implicit wait, and prop object

•   WebElement class: Which contains the clickOnElement() and getElementText() which can be used frequently

### Project structure: 
![Project structure](https://drive.google.com/file/d/16gZ17aXdcjz687j-OBBcMlZz9phBDHy0/view)

## Running Tests
### first method
* Clone the repository
* Open the command line in the repository directory
* Run the below commands
```shell
$ mvn clean
$ mvn build
$ mvn test
```
### second method
* Clone the repository
* Open the project in a Java IDE
* Run the project from the TestRunner class

## Test Results
* Test report automatically generated on `target` folder after finished the test execution
* See test report from `target/reports/report-html`
