#Author: manoj.chauhan@prodigylabs.net
#Keywords Summary : Android Automation POC
#Feature: Internal Transfer from DDA to Savings
#Scenario: #NA

Feature: Internal Transfer - DDA to Savings  
@SmokeTest
Scenario Outline: Verify Meed customer is able to successfully able to make internal transfer on mobile device
 Given user launches the app in "<Platform>" device
   And user enters email "<Email>"
   And user clicks on button "GET_STARTED"
   And user enters text "<Username>" in textbox "Username"
   And user enters text "<Password>" in textbox "Password"
   And user clicks on button "LOGIN"
   And user waits for "10" seconds
   And user clicks on button "INTERNAL_TRANSFER"
   And user waits for "2" seconds
   And user clicks on button "NEXT"
   And user enters text "<Amount>" in textbox "Amount"
   And user selects option "Monthly"  from the dropdown "Frequency"
   And user clicks on button "NEXT"
   And user clicks on button "CONFIRM"
   
	Examples: 
	|	Platform	|	Email													|	Username			|	Password		|	Amount	|
	|	Android		|	manoj.chauhan@prodigylabs.net	|	mchauhan9189	|	Qwerty123!!	|	3.00				|

	
	