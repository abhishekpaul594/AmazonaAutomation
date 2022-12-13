# AmazonaAutomation
Prerequisite
1. Install JAVA and set JAVA_HOME and PATH variable 
2. Install Maven and set MAVEN_HOME and PATH variable
#######
Linux environment
1. Open terminal Switch to root user
2. Go inside webdrivers/chromedriver_linux64 in the root folder
3. Execute sudo chmod 777 chromedriver command
4. Go back to root folder of the project in the terminal
5. Execute mvn clean test -Dcucumber.options="src/test/resources/features/AutomationTelevision.feature" -Dcucumber.options="--tags @test" command 
########
Windows environment
1. Open terminal Switch to root user
2. Go inside webdrivers/chromedriver_win32 in the root folder
3. Go back to root folder of the project in the terminal
4. Execute mvn clean test -Dcucumber.options="src/test/resources/features/AutomationTelevision.feature" -Dcucumber.options="--tags @test" command 

Report path target/cucumberHtmlReport.html
