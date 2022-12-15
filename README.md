# AmazonAutomation
Prerequisite
1. Install JAVA and set JAVA_HOME and PATH variable 
2. Install Maven and set MAVEN_HOME and PATH variable
3. Install Google chrome version 108

#######
Linux environment
1. Open terminal Switch to root user
2. Go inside webdrivers/chromedriver_linux64 in the root folder
3. Execute sudo chmod 777 chromedriver command
4. Go back to root folder of the project in the terminal
5. Execute mvn clean test -Dcucumber.options="src/test/resources/features/AutomateTelevision.feature" -Dcucumber.options="--tags @test" command 


########
Windows & MacOS environment
1. Open terminal Switch to root user
2. Go back to root folder of the project in the terminal
3. Execute mvn clean test -Dcucumber.options="src/test/resources/features/AutomateTelevision.feature" -Dcucumber.options="--tags @test" command 

########
Grid Execution
1. To execute in selenium grid open src/main/resources/cucumber.properties
2. Set grid=true
3. Set hub with proper selenium hub id

Report path target/cucumberHtmlReport.html

*****Tested in Windows and Linux. But not tested in MacOS due to unavailability of environment. 
*****Screenshot will be captured for failed test scenario and attach with the step in cucumberHtmlReport.html report file  
