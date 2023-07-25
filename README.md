# SeleniumWithCucumberAndPOM
# STPES
1. Clone Code Repo
2. go to Base folder and run `mvn clean` 
3. run command `mvn install`
4. For run test run the command `mvn test -Dcucumber.filter.tags=@WEB -Denv=ENV_1` 
5. For generate allure report go to the Report Folder with command `cd Reports` and then run the command `allure generate allure-results/ --clean -o allure-report`



