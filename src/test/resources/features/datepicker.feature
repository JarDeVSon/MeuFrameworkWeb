#author: Jardeson Santos
#encoding: UTF-8

@regressivo @datepicker @desafio
Feature: Datepicker

  Background: Datepicker Page
    Given Open the browser and Enter the URL Datepicker

  Scenario Outline: Datepicker with <CT->
    When i choose the following date in datepicker
      | datepickerdisabled | <datepickerdisabled> |
      | datepickerenabled  | <datepickerenabled>  |

    Examples:
      | CT-                | datepickerdisabled | datepickerenabled |
      | Both Datepickers   | 05/15/1996         | 05/15/1996        |
      | DatepickerDisabled | 05/15/1996         |                   |
      | DatepickerEnabled  |                    | 05/15/1996        |

