Hackathon Project 
====================================================================

Problem Statement : Identify Courses

Search and display all web development courses 
1. Should be for beginners level.
2. Courses offered in English language
3. Display first two courses with name, total learning hours and rating.
(Suggested Site: coursera.org however  you are free to choose any other legitimate  site)

Detailed Description: Hackath Ideas

----Identify Courses------


1. Search for web development courses for Beginners level & English Language 
   Extract the course names, total learning hours & rating for first 2 courses

2. Look for Language Learning under Explore menu and click on All Language Courses under popular skills
   Extract all the languages and different levels with its total count & display them
   
3. In Home page, go to "For Business"; Scroll down to form ; 
   Fill the form with any one input invalid (example: email); Capture the error message & display
   

Key Automation Scope
---------------------------------------------
Handling different browser windows, search option
Extract multiple  list items  
Filling form (in different objects in web page)
Capture warning message

The Tools and Technology :
----------------------------------------------------------------------------------------
TestNG
Selenium
cucumber Framework
Page Object Model [POM]
Apache poi[MS Excel]
Extent Report

Project Output Files :
----------------------------------------------------------------------------------------
For Cucumber Report:
   Refer folder reports -> myreport.html
   
For Extent Report:
   Refer folder test-output -> SparkReport->Report->CucumberExtentReport.html

For excel output:
  Refer folder testData -> Outputdata.xlsx
 
 
Project Output in console :
-----------------------------------------------------------------------------------------
Course Name: Meta Front-End Developer Professional Certificate
Course Rating: 4.7
Duration of course in hours: 212

Course Name: Web Design for Everybody: Basics of Web Development & Coding Specialization
Course Rating: 4.8
Duration of course in hours: 74

Total languages count: 25
Language names:
English
Spanish
Arabic
French
Portuguese(Brazil)
Japanese
Korean
Chinese(China)
German
Indonesian
Ukrainian
Hindi
Italian
Swedish
Dutch
Greek
Polish
Thai
Turkish
Russian
Kazakh
Hungarian
Chinese(Traditional)
Hebrew
Portuguese

Levels count: 4
Level names:
Beginner
Intermediate
Advanced
Mixed

Error message for Invalid email-id: 
Must be valid email.
example@yourdomain.com


Added dependencies:
==========

<dependencies>
	<!--  https://mvnrepository.com/artifact/commons-io/commons-io  -->
	<dependency>
		<groupId>commons-io</groupId>
		<artifactId>commons-io</artifactId>
		<version>2.15.1</version>
	</dependency>
	<!--  https://mvnrepository.com/artifact/org.apache.commons/commons-lang3  -->
	<dependency>
		<groupId>org.apache.commons</groupId>
		<artifactId>commons-lang3</artifactId>
		<version>3.14.0</version>
	</dependency>
	<!--  https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java  -->
	<dependency>
		<groupId>org.seleniumhq.selenium</groupId>
		<artifactId>selenium-java</artifactId>
		<version>4.18.1</version>
	</dependency>
	<!--  https://mvnrepository.com/artifact/org.testng/testng  -->
	<dependency>
		<groupId>org.testng</groupId>
		<artifactId>testng</artifactId>
		<version>7.9.0</version>
		<scope>test</scope>
	</dependency>
	<!--  https://mvnrepository.com/artifact/org.apache.poi/poi  -->
	<dependency>
		<groupId>org.apache.poi</groupId>
		<artifactId>poi</artifactId>
		<version>5.2.5</version>
	</dependency>
	<!--  https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml  -->
	<dependency>
		<groupId>org.apache.poi</groupId>
		<artifactId>poi-ooxml</artifactId>
		<version>5.2.5</version>
	</dependency>
	<!--  https://mvnrepository.com/artifact/com.aventstack/extentreports  -->
	<dependency>
		<groupId>com.aventstack</groupId>
		<artifactId>extentreports</artifactId>
		<version>5.1.1</version>
	</dependency>
	<!--  https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api  -->
	<dependency>
		<groupId>org.apache.logging.log4j</groupId>
		<artifactId>log4j-api</artifactId>
		<version>3.0.0-beta2</version>
	</dependency>
	<!--  https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core  -->
	<dependency>
		<groupId>org.apache.logging.log4j</groupId>
		<artifactId>log4j-core</artifactId>
		<version>3.0.0-beta2</version>
	</dependency>
	<!--  https://mvnrepository.com/artifact/io.cucumber/cucumber-java  -->
	<dependency>
		<groupId>io.cucumber</groupId>
		<artifactId>cucumber-java</artifactId>
		<version>7.16.1</version>
	</dependency>
	<!--  https://mvnrepository.com/artifact/io.cucumber/cucumber-junit  -->
	<dependency>
		<groupId>io.cucumber</groupId>
		<artifactId>cucumber-junit</artifactId>
		<version>7.16.1</version>
	    <scope>test</scope>
	</dependency>
	<dependency>
		<groupId>io.cucumber</groupId>
		<artifactId>cucumber-testng</artifactId>
		<version>7.16.1</version>
		<scope>test</scope>
	</dependency>
	<!--  https://mvnrepository.com/artifact/com.aventstack/extentreports-cucumber4-adapter  -->
	<dependency>
		<groupId>tech.grasshopper</groupId>
		<artifactId>extentreports-cucumber7-adapter</artifactId>
		<version>1.14.0</version>
	</dependency>
</dependencies>