$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/login.feature");
formatter.feature({
  "name": "Signin feature",
  "description": "  I want to signin in my portal",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify Login into portal",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User navigated to the Login page",
  "keyword": "Given "
});
formatter.step({
  "name": "Enter Username \"\u003cusername\u003e\" and password \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User should be able to login",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "admin",
        "Admin@123"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify Login into portal",
  "description": "",
  "keyword": "Scenario Outline"
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
formatter.after({
  "status": "passed"
});
});