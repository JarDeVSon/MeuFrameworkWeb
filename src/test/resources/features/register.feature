#author: Jardeson Santos
#encoding: UTF-8

@regressivo @register2 @desafio
Feature: Register 2

  Background: Register 2 Page
    Given Open the browser and Enter the URL "https://demo.automationtesting.in/Register.html"

  Scenario Outline: Register with <CT->
    When I fill in the following information
      | country1 | <country1> |
      | country2 | <country2> |

    Examples:
      | CT-                     | country1       | country2 |
      | CT-0001 - country Japan | Select Country | Japan    |
