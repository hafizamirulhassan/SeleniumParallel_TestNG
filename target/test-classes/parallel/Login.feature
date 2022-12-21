Feature: Login page feature

@LoginPageTitle
Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Automation Practice Site"

@ForgotPasswordLink
Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

@LoginInfo
Scenario: Login with correct credentials
Given user is on login page
When user enters username "fiha0095@gmail.com"
And user enters password "fiha0095@"
And user clicks on Login button
Then user gets the title of the home page
#And page title should be "My Account - Automation Practice Site"