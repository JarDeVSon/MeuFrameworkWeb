#author: Jardeson Santos
#encoding: UTF-8

@regressivo @dragdrop @desafio
Feature: Drag and drop

  Background: Drag and Drop Page
    Given Open the browser and Enter the URL "https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html"

  Scenario: Drag drop with
    When i perform the drag drop action
