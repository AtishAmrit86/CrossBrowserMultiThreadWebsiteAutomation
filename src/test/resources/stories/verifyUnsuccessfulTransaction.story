
Narrative:
In order to validate message at the end of transaction
As a tester
I want to use Behaviour-Driven Development
					 
Scenario:  To verify successful transaction on buying pillow
Meta:
@smoke
Given the user is on homepage
When the user clicks buy now button
Then shopping cart modal opens
And user verifies the fields on the shopping cart modal
Then the user enters required details
When the user clicks chekckout button
Then order summary modal is displayed
When the user clicks continue button
Then payment selection modal is displayed
When the user selects Credit Card payment method
Then the card details form is displayed
When the user enters incorrect card details
Then the user clicks on Paynow button
And OTP page is displayed
When the user enters OTP in the text box
Then the user clicks on OK button
Then transaction fail message is displayed


