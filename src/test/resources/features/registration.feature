#author: Jardeson Santos
#encoding: UTF-8

@regressivo @register
Feature: Register

  Background: MY ACCOUNT - REGISTRATION
    Given Open the browser and Enter the URL "https://practice.automationtesting.in/my-account/"

  @ct0001
  Scenario: Caminho Feliz - Registration-Sign-in
    And Enter registered Email Address in Email-Address textbox
    And Enter your own password in password textbox
    And Click on Register button
    Then User will be registered successfully and will be navigated to the Home page

  @ct0002
  Scenario Outline: Caminho Nao Tao Feliz Assim - Registration with <CT->
    And Enter Email Address in Email-Address textbox
      | email | <email> |
    And Enter password in password textbox
      | password | <password> |
    And Click on Register button
    Then Registration must fail with a warning message

    Examples:
      | CT-                            | email          | password |
      | CT-0001 - invalid email        | asasxxx@ioasas | 124L$2m  |
      | CT-0002 - empty email          |                | 124L$2m  |
      | CT-0003 - empty password       | 1234@email.com |          |
      | CT-0004 - empty email password |                |          |



