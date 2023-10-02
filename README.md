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
  
## Installation

Install the Libraries using the Command Line:

- `mvn install`
  
## Running the tests

In this project, you can run tests via CLI using `mvn` the flag `-Dcucumber.filter.tags=` with the Name Tag Runner `@regressivo`
and generate the reports with the `cluecumber-report:reporting`

`mvn test -Dcucumber.filter.tags="@regressivo" cluecumber-report:reporting`
___

Made with ❤️ by [Jardeson Santos](https://github.com/JarDeVSon). [Meu Linkedin](https://www.linkedin.com/in/jardeson-santosqa).
