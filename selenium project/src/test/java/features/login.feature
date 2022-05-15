Feature: Login feature
  I want to signin in my portal

  Background: Verify Login into portal
    Given User navigated to the Login page
    And Enter Username "admin" and password "Admin@123"
    Then User should be able to login
    When Click on side menu button
    And click on the coupons button
    Then User should be able to navigate to Coupons page

  Scenario: Add Coupons
    Given User is in the Coupons page and click on Add Coupon button
    When Add Coupon details and click save 
    And Verify the added Coupon
    And Click Edit the added Coupon
    And Verify the Edited coupon in coupon list
    And Delete the coupon
    Then Couple should get deleted
    
