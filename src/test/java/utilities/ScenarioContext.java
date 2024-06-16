package utilities;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

/**
 * Used to assist in sharing states between step definitions
 */
public class ScenarioContext
{
    /**
     * Map between the Context variables and Object values set during the execution of a Scenario
     */
    private Map<Context, Object> scenarioContext;

    /**
     * Container to which scenario context data is stored
     */
    public interface Context
    {
        /**
         * Context relating to general information
         */
        enum GENERAL implements Context
        {
            SECTION_NAME, FILTER_NAME_VALUE
        }
    }

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Hash map the scenario context
     */
    public ScenarioContext()
    {
        scenarioContext = new HashMap<>();
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Maps a value of type Object to a context key of type String
     * <p>
     * @param key Context enum of type String
     * @param value Object type
     */
    public void setContext(Context key, Object value)
    {
        scenarioContext.put(key, value);
    }

    /**
     * Used to get the context of the enum context
     * <p>
     * @param key Takes key context enum as a parameter
     * @return context Returns the object which matches the key
     */
    public Object getContext(Context key)
    {
        return scenarioContext.get(key);
    }

    /**
     * Gets the scenario context as a String
     * <p>
     * @param key Takes key context enum as a parameter
     * @return string Returns a String
     */
    public String getScenarioContextAsString(Context key)
    {
        Object value = this.getContext(key);
        if (!(value instanceof String))
        {
            fail();
        }
        return (String) value;
    }

    /**
     * Gets the Scenario context as a String map
     * <p>
     * @param key The scenario context to get
     * @return the Scenario context as a String map
     */
    public Map<String, String> getScenarioContextAsStringMap(Context key)
    {
        return getScenarioContextAsMap(key, String.class);
    }

    /* **************** 
     *  PRIVATE METHODS 
     ****************** */

    /**
     * First check is to ensure the Object value is a map, the second check is to ensure that the Map is not empty.
     * <p>
     * @param key Takes key context enum as a parameter
     * @param type Class type
     * @return a Map of generic type
     */
    @SuppressWarnings("unchecked")
    private <T> Map<T, T> getScenarioContextAsMap(Context key, Class<T> type)
    {
        Object value = this.getContext(key);
        if (!(value instanceof Map<?, ?>))
        {
            fail();
        }
        if (CollectionUtils.sizeIsEmpty((Map<?, ?>) value))
        {
            fail();
        }
        return (Map<T, T>) value;
    }
}