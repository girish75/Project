Feature: Signin feature
  I want to signin in my portal
  
  Scenario Outline: Verify Login into portal 
    Given User navigated to the Login page
    And Enter Username "<username>" and password "<password>"
    Then User should be able to login

    Examples: 
      | username          | password       |
      | admin             | Admin@123    |
      
      
