 Extract:
 
 	The Project is created to test successful and unsuccessful transaction by entering different credit cards while buying a pillow from the website "https://demo.midtrans.com".
 	It is a Maven project which uses Page Object Model. The test framework is created using Serenity BDD with jBehave and jUnit.
 
 
 
 
 CodeFlow:
 
 	The entry-point for the code is runnerClass.java. This class extends "Serenity Stories" class and is used to find stories file to start the test.
 	The story file is a feature file written in Gherkin language to make people understand the test flow in a layman language. The story file is mapped to a testStep(testStep.java) file through different annotations.
 	Test Step file is basically a java class file with the methods defined for each-steps individually. All the methods are defined in a separate java file(testMethods.java) and is called to testStep file the instance of testMethods.java in the step file.
 	To make webdriver interact with web element we need locators.These locators are stored in a property file(webElementLocators.properties) and are accessed using key-value pair.
 	Another property file(testData.properties) is used for storing test data. A separate java class(commonUtilites.java) is created to create generic methods to be reused.
 	In simple language the code flow in following way:
 	
 	runnerClass.java --> story --> testStep.java --> testMethods.java(uses webElementLocators.properties and testData.properties for locators and testData)-->commonUtilities.java
 	
 	
 	A ".bat" and ".sh" file is created to run script on different OS platform. Steps to run test on different OS platforms are mentioned below
 	The test execution ends at the last line of story and report are generated automatically at the end of the test execution. Steps to view report is mentioned below.
 	
  
 
 
 Pre-Requisite to run the script:
 
 	- The system must have Java(Java 8 or above) and JVM installed( version 1.8)
 	- JAVA_HOME must have been set up in the system environment variable
 	- The system must have Apache Maven installed(version - 3.6.2)
 	- MAVEN_HOME and M2-HOME must have been set up in the system environment variable
 	- The system must have latest version of chrome and firefox //VERSION
 
 	
 To run the script from command line follow the steps mentioned below:
 	- On MAC Machine
 		- Open Terminal
 		- Navigate to the folder location
 		- Type command "sh runTest.sh"
 		- Hit Enter
 		
 	- On Windows Machine
 		- Open command prompt
 		- Navigate to the folder location
 		- Type command "runTest.bat"
 		- Hit Enter
 		
 		
 To see the report follow the steps mentioned below:
 	- Go to folder location on your local machine and open it
 	- Open "Target" folder
 	- Open "Site" folder
 	- Open "Serenity" folder
 	- Inside serenity folder open "index.html" with the web-browser of your choice


 By default the browser is set to chrome. To change the browser to Firefox follow the steps given below:
	- Open pom.xml file
	- look for <webdriver.driver> tag
	- change the name from chrome to Firefox
	- Save the change
	- Run the project using the steps mentioned above
 	
 	

 
 		