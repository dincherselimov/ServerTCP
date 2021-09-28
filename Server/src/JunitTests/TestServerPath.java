package JunitTests;

import Config.*;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class TestServerPath {
    /**
     * This Junit test is testing the path for saving a file from ClientTCP
     * @String path //Gets the port from config.properties file
     * @asserEquals //Checks if the port is as expected
     */

    @Test

    public void testConfig() throws IOException {
        Config config = new Config();
        //Getting the path form config.properties
        String path = config.getAbsolute_path();
        //Compares whether the paths are equal or not
        assertEquals("D:\\Java\\ServerTCP\\Server\\src\\SavedFiles",path);
        System.out.println("Test passed!");
        System.out.println("Paths are equal!");
    }
}