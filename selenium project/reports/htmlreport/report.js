$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/login.feature");
formatter.feature({
  "name": "Login feature",
  "description": "  I want to signin in my portal",
  "keyword": "Feature"
});
formatter.background({
  "name": "Verify Login into portal",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigated to the Login page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinationclass.user_navigated_to_the_Login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter Username \"admin\" and password \"Admin@123\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinationclass.enter_Username_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to login",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinationclass.user_should_be_able_to_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on side menu button",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinationclass.click_on_side_menu_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the coupons button",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinationclass.click_on_the_coupons_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to navigate to Coupons page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinationclass.user_should_be_able_to_navigate_to_Coupons_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add Coupons",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is in the Coupons page and click on Add Coupon button",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinationclass.user_is_in_the_Coupons_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add Coupon details and click save",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefinationclass.add_Coupon_details_and_click_save()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the added Coupon",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinationclass.verify_the_added_Coupon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click Edit the added Coupon",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinationclass.click_Edit_the_added_Coupon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the Edited coupon in coupon list",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinationclass.verify_the_Edited_coupon_in_coupon_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Delete the coupon",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinationclass.delete_the_coupon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Couple should get deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinationclass.couple_should_get_deleted()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});