Feature: Admin Portal Web

  @WEB @LOGIN_USER
  Scenario: Verify Web Portal is launched successfully
    Given Setting Web Selenium connection for "TARGET_ADMIN_WEB"
    And   [Admin Portal] User enters Email "standard_user"
    And   [Admin Portal] User enters Password "secret_sauce"
    And   [Admin Portal] Click on login button


  @WEB @ORDER_PLACING
  Scenario: Verify User should be able To place order successfully
    And   [Admin Portal] User should be able to add item in cart
    And   [Admin Portal] User should be able to visit on checkout screen by click on checkout icon
    And   [Admin Portal] Click on chckout to continue
    And   [Admin Portal] Enter first name as "John"
    And   [Admin Portal] Enter last name as "Smith"
    And   [Admin Portal] Enter postal code as "3493489"
    And   [Admin Portal] Click on continue button to continue ordering
    And   [Admin Portal] Click on finish button to complete ordering
    And   [Admin Portal] Go to side menu

  @WEB @LOGOUT_USER
  Scenario: Verify User should be able To logout successfully
    And   [Admin Portal] Click on login button
