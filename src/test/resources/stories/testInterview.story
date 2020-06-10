Story: Verify Payment Alert Message

Narrative:
In order to communicate effectively to the business some functionality
As a testing team
I want to use Behaviour-Driven Development
					 
Scenario:  To verify alert message for non-selection of payment method
Meta: @smoke

Given the user is on test homepage
When the user selects the source
Then the user selects the destination
And the user selects date of travel
When the user clicks the booknow button
Then list of buses is displayed
When the user selects the bus
Then the user selects seat to be occupied
And the user verifies the seats are selected
When the user clicks Proceed button
Then the user enters personal details
When the user clicks Proceed To Payment Button
Then user verifies the alert