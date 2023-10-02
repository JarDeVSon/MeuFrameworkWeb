#author: Jardeson Santos
#encoding: UTF-8

@regressivo @slider @desafio
Feature: Slider

  Background: Slider Page
    Given Open the browser and Enter the URL "https://demo.automationtesting.in/Slider.html"

  Scenario Outline: Slider with <CT->
    When i perform the slider action with 50 porcents
    Then should be displayed 50 porcents

    Examples:
      | CT-         |
      | 50 porcents |