# Selenium Java Web Automation Framework

## Libraries Used:

1. **selenium-java** - Web Automation
2. **testng** - Unit Testing
3. **webdrivermanager** - Driver manager
4. **extentreports** - Reporting
5. **assertj-core** - Assertions
6. **jackson-databind** - Work with Json files
7. **jackson-core** - Work with Excel files
8. **commons-io** - Work with Excel files
9. **poi-ooxml** - Work with Excel files
10. **poi-ooxml-schemas** - Work with Excel files
11. **poi-scratchpad** - Work with Excel files
12. **poi** - Work with Excel files
13. **commons-email** - Work with Excel files
14. **rest-assured** - Send results to ELK

## UML Diagram:
![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img.png)

## File/Package description:
1. **/.github** - runs github actions
2. **/extent-test-output** - contains extent reports
3. **docker-compose.yaml** - runs tests in docker container using selenium grid in chrome and firefox browsers, sends results to ElasticSearch and visualize in Kibana
4. **pom.xml** - contains all necessary dependencies and uses maven as a build tool
5. **testng.xml** - contains information regarding tests suites, included tests, listeners, thread count and level of parallel execution
6. **.gitignore** - ignores files from adding to git repository
7. **/src/test/java/pages** - contains common methods to interact with pages and uses POM design pattern classes for each Web Page
8. **/JQMax/src/test/java/tests** - contains written tests
9. **/src/test/resources/excel** - data provider and tests management lists for Data-Driven Testing
10. **/src/test/resources/config** - contains preferences for test execution (currently using config.properties)
11. **/src/main/java/annotations** - custom @Framework Annotation that contains author and category information
12. **/src/main/java/constants** - framework constants, getters and setters
13. **/src/main/java/driver** - ThreadLocal driver and methods to initialize and quite driver
14. **/src/main/java/enums** - enums to work with config.properties, waiting strategies for synchronization and category types of tests for @FrameworkAnnotation
15. **/src/main/java/exceptions** - custom exceptions
16. **/src/main/java/factories** - factories to configure driver based on local/remote and chrome/firefox conditions, explicit wait factory to configure synchronization strategy to check if element is clickable/present/visible/nono
17. **/src/main/java/listeners** - listeners that based on the test results, retry strategy, data provider manager
18. **/src/main/java/reports** - ThreadLocal extent report, its configuration and logger
19. **/src/main/java/utils** - utility methods that are used across the framework

## To Run Tests:

### Locally:
1. In /src/test/resources/config/config.properties set: ```runmode=local```; ```sendresultstoelk=no```;
2. Make sure test classes are included in testng.xml in **\<classes> \</classes>** tag
3. In **testdata.xlsx** include test names on **"RUNMANAGER"** tab under **"testname"** column. Define **"testdescription"**, **"execute"**, **"priority"**, **"count"** fields
4. In **testdata.xlsx** include test names on **"DATA"** tab and populate fields with necessary data for execution
5. In terminal from project folder run command ```mvn clean test```
6. Results will be opened in the new browser tab 

NOTE: For parallel execution change parameters in testng.xml for **data-provider-thread-count="1"** and **thread-count="1"** to desired

![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img_1.png)
![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img_2.png)
![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img_3.png)
![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img_4.png)

### Docker container using Selenium Grid
1. In /src/test/resources/config/config.properties set: ```runmode=remote```; ```sendresultstoelk=yes```;
2. Make sure test classes are included in testng.xml in **\<classes> \</classes>** tag
3. In **testdata.xlsx** include test names on **"RUNMANAGER"** tab under **"testname"** column. Define **"testdescription"**, **"execute"**, **"priority"**, **"count"** fields
4. In **testdata.xlsx** include test names on **"DATA"** tab and populate fields with necessary data for execution
5. Open Docker
6. Run ```docker-compose -f docker-compose.yaml up```

7. In terminal from project folder run command ```mvn clean test```
8. To check runs is Selenium Grid - navigate to URL Open [Selenium-Grid](http://localhost:4444/ui/index.html#/)
9. Results will be opened in the new browser tab
![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img_1.png)
![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img_2.png)
![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img_3.png)
![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img_4.png)
10. To check results in Kibana - navigate to URL [Kibana](http://localhost:5601/) -> Stack Management -> Index Patterns and create index patter for "regression"
![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img_6.png)
11. To create visualizations navigate to "Visualize Library" and create diagrams
![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img_7.png)
12. Add the visualization to a Dashboard
![](/Users/maxsudik/IdeaProjects/JQMax/readmeImages/img_8.png)

NOTE: For parallel execution change parameters in testng.xml for **data-provider-thread-count="1"** and **thread-count="1"** to desired

