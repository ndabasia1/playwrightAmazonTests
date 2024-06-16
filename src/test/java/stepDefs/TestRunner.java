package stepDefs;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * @SelectClasspathResource links to where the feature files are stored
 * GLUE_PROPERTY_NAME refers to where the step definitions for each feature file is stored
 * FILTER_TAGS_PROPERTY_NAME refers to the specific tag to run
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepDefs")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@mobilePhones")
public class TestRunner
{
}