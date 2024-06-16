package utilities;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Manages properties of this project
 */
public class PropertiesManager
{
    private static PropertiesManager INSTANCE;
    private String filePath = System.getProperty("user.dir") + File.separator + "phones" + File.separator + "Phones.txt";
    private BufferedWriter myWriter;

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Initialise file writer
     */
    private PropertiesManager()
    {
        try
        {
            myWriter = new BufferedWriter(new FileWriter(filePath));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Checks if an instance for this class already exists or not, if it doesn't it creates one
     * <p>
     * @return an instance of PropertiesManager
     */
    public static PropertiesManager getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new PropertiesManager();
        }
        return INSTANCE;
    }

    /**
     * Create and write text to a file
     * <p>
     * @param phones The name of the phones to write to a file
     */
    public void createAndWriteToFile(String phones)
    {
        try
        {
            File myObj = new File(filePath);
            myObj.createNewFile();
            myWriter.write(phones);
            myWriter.newLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Close the writer
     */
    public void closeWriter()
    {
        try
        {
            myWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            fail();
        }
    }
}