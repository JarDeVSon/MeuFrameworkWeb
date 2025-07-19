# Web Automation Selenium WebDriver, Cucumber, and JUnit with Java - Framework

Sample project to demonstrate Web Automation tests written with [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/getting_started/install_library/), [Cucumber](https://cucumber.io/docs/installation/java/#maven), and [JUnit](https://cucumber.io/docs/installation/java/#junit-5-integration) in [Java](https://www.oracle.com/java/technologies/downloads/#java11) running on GitHub Actions.

## Pre-requirements

To clone and run this project, you will need:

- [Git](https://git-scm.com/downloads)(I've used version `2.34.1` while writing this doc)
- [Java 11](https://jdk.java.net/java-se-ri/11-MR2)(I've used version `11` while writing this doc)
- [Maven](https://maven.apache.org/download.cgi)(I've used version `3.9.4` while writing this doc)
- [IntelliJ IDEA Community Edition
](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC)(Install the IntelliJ IDEA Community Edition)
- [Cucumber for Java Extension Plugin](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java)(Install the plugin Cucumber for Java also will include the Gherkin plugin to accept both).

- DISCLAIMER: make sure to set up the JAVA_HOME and MAVEN_HOME environments in your machine.

## Project Structure: Page Object Model and Single Responsibility Principle Pattern:


| Package  | Responsibility                                                                  |
|----------|---------------------------------------------------------------------------------|
| core     | responsible for managing the Webdriver config                                   |
| maps     | responsible for identifying web elements                                        |
| pages    | responsible for page actions (navigation, sendKeys, getText, clicks, selects.)  |
| steps    | responsible for snippets steps generated from feature file                      |
| runner   | responsible for executing the test suite                                        |
| features | responsible for Scenarios written in BDD/Gherkin                                |

  
## Installation

Install the Libraries using the Command Line:

- `mvn install`
  
## Running the tests

In this project, 
- you can run tests via CLI handle with multiple environments(dev,hom,uat) using 'mvn' -Denv=env.properties. 
- the flag '-Dcucumber.filter.tags=' with the Name Tag Runner '@regressivo'
- generate the reports with the 'cluecumber-report:reporting'
    

`mvn test -Denv=dev.properties -Dcucumber.filter.tags="@regressivo" cluecumber-report:reporting`

`mvn test -Denv=hom.properties -Dcucumber.filter.tags="@regressivo" cluecumber-report:reporting`

`mvn test -Denv=uat.properties -Dcucumber.filter.tags="@regressivo" cluecumber-report:reporting`

___

Made with ❤️ by [Jardeson Santos](https://github.com/JarDeVSon). [Meu Linkedin](https://www.linkedin.com/in/jardeson-santosqa).
