<h1> Maven, TestNG, Allure Report</h1>
<h1> Jenkinsfile for declarative pipeline - CI-CT</h1>

<h3>commands</h3>
### Allure_Maven_TestNG
mvn clean test

### allure serve command - to generate the report and host it on local jetty server
allure serve target/allure-results/

### mvn commands
mvn allure:serve
mvn allure report
