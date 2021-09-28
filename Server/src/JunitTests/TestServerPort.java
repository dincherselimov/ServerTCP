package JunitTests;

import Config.*;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;

public class TestServerPort {
    /**
     * This Junit test is testing the port for connection to ClientTCP
     * @int port //Gets the port from config.properties file
     * @asserEquals //Checks if the port is as expected
     */

    @Test

    public void testConfig() throws IOException {
        Config config = new Config();
        //Getting the port form config.properties
        int port = config.getPort();
        //Compares whether the ports are equal or not
        assertEquals(80,port);
        System.out.println("Test passed!");
        System.out.println("Ports are equal!");
    }
}