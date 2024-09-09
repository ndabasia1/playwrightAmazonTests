# playwrightAmazonTests
**How to run a test**

To run a test through eclipse:
1. Clone the repository into your local and open it through eclipe
2. Navigate to a feature file which can be found in \test\resources\features. Select a tag that is on a feature file which is found at the top of a file and it'll be in a @[tagname] format.
3. Go to the TestRunner.java class, and replace the value within FILTER_TAGS_PROPERTY_NAME. By default, it will run @mobilePhones
4. Run this class as a JUnit test. When setting up the run configuration, ensure to use JUnit 5 as the test runner*
5. The test will run and a report will be generated within Düsseldorf\target\cucumber-reports\
6. By default, the test will run in headless mode. If you want to change this, you can pass in VM arguments into the arguments tab when doing step 4 e.g. -ea -Dheadless="false"

*Important note: If you don't see the option to run as JUnit test, you may have to do some changes to your project on eclipse to make it work. Try the following:
1. Ensure the project had the Maven and Java project natures.
2. Updated the maven sources.
3. Build the project
You should be able to run the test now.

To run a test through the command line:
1. Navigate to where the repo is stored in your terminal
2. Enter mvn test
3. It will then run the test of the FILTER_TAGS_PROPERTY_NAME in TestRunner with default properties.
a. To change if it runs in headless mode or not, add -Dheadless="false" to the end of the command. By default it runs in headless mode.
4. A report will be generated within playwrightAmazonTests\target\cucumber-reports\

To run a test with docker:
1. Navigate to where the repo is stored in your terminal
2. Turn on docker engine.
3. Enter docker-compose up --build into the command line
4. It will then run the test and a report will be generated within playwrightAmazonTests\target\cucumber-reports\