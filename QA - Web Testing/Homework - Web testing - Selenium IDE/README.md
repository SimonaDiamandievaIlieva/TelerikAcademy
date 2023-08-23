Alpha 50 QA - Web Testing
Intro to Automated Testing Homework
Intro to Automated Testing Homework
Preface
Before you start, read this document from top to bottom. It has some valuable information that will make your work way easier.

Description
Automate existing test cases using Selenium IDE

URL: https://www.saucedemo.com/

Ensure your tests pass everytime you run them.

Test Cases
Test Case Id	Priority	Test Suite	Scenario Name	Preconditions	Test Steps	Test Data	Expected Result
1	HIGH	Login Form	Authenticate with valid credentials	Existing user is registered	Navigate to Login Page	https://www.saucedemo.com/	Login page navigated
Fill valid username in the username field	standard_user	No validation errors
Fill valid password in the password field	secret_sauce	No validation Errors Password not visible
Click Login button		Form submitted
Verify user logged in		Page with inventory is displayed: https://www.saucedemo.com/inventory.html
2	HIGH		Authenticate with invalid credentials	Existing user is registered	Navigate to Login Page	https://www.saucedemo.com/	Login page navigated
Fill valid username in the username field	standard_user	No validation errors
Fill wrong password in the password field	secret_sauce_wrong	No validation Errors Password not visible
Click Login button		Form submitted
Verify Error message is displayed		Error message: Epic sadface: Username and password do not match any user in this service
3	HIGH		Add Product to Shopping Cart	Authenticate with Valid User	Navigate to Products page	https://www.saucedemo.com/inventory.html	Page navigated
Add product to shopping cart	Sauce Labs Backpack	Button changed from "Add to cart" to "Remove"
Click on Shopping Cart button		Should contain number "1"
Verify Product successfully added		Title, Description, Price are displayed as expected
Step-by-step guide
Create a new Selenium IDE Project
Create two test suites
Authentication
Add Product
Automate the scenarios into separate tests
Add proper validations and assertions
Save the Test Project as a .side file
Submit the homework as an archive
