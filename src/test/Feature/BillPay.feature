#Author: manoj.chauhan@prodigylabs.net
#Keywords Summary : Android Automation 
#Feature: Bill Pay
#Scenario: #NA

Feature: Bill Pay  
@RegressionPack @TC001
Scenario Outline: Verify Meed customer is able to pay bill
Given user launches the app in "<Platform>" device
   And user enters email "<Email>"
   And user clicks on button "GET_STARTED"
   And user enters text "<Username>" in textbox "Username"
   And user enters text "<Password>" in textbox "Password"
   And user clicks on button "LOGIN"
   And user waits for "10" seconds
   And user clicks on button "Menu"
   And user waits for "2" seconds
   And user clicks on button "PAYMENT_&_DEPOSITS"
    And user waits for "2" seconds
    And user clicks on button "BILL_PAY"
    And user waits for "3" seconds
    And user clicks on button "Next"
    And user waits for "1" seconds
    And user clicks on button "Next"
    And user waits for "1" seconds
    And user clicks on button "Add_a_bill"
    And user waits for "2" seconds
    
     Examples: 
	|	Platform	|	Email													|	Username			|	Password		|
	|	Android		|	manoj.chauhan@prodigylabs.net	|	mchauhan9189	|	Qwerty123!!	|	