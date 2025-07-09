#author: Jardeson Santos
#encoding: UTF-8

@regressivo @frame @desafio
Feature: Frame

  Background: Frame Page
    Given Open the browser and Enter the URL Frame

  Scenario Outline: Frame with <CT->
    When fill the frame field
      | frame | <frame> |
    Then should be displayed "preenchido com sucesso"
    Examples:
      | CT-                          | frame                  |
      | texto preenchido com sucesso | preenchido com sucesso |
